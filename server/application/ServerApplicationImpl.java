package server.application;

import another.console.DateConverter;
import another.file.FileManager;
import another.file.FileWriter;
import another.DateConverterImpl;
import another.connection.request.*;
import another.connection.response.*;
import another.console.ConsoleInputManager;
import another.ConsoleInputManagerImpl;
import another.ConsoleReader;
import another.InputCommandConverterImpl;
import another.exceptions.*;
import server.file.FileReaderImpl;
import another.messenger.RussianMessenger;
import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.collection.SpaceMarineCollectionManager;
import server.commandModule.*;
import server.commandModule.commands.commandInterfaces.CommandWithElement;
import server.connection.*;
import server.file.*;
import server.collection.spaceMarineCreation.SpaceMarineFactoryImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class ServerApplicationImpl implements ServerApplication {

    private ClientCommandManager clientCommandManager;

    private ServerCommandManager serverCommandManager;

    private ConsoleInputManager consoleInputManager;

    private CommandInvoker commandInvoker;

    private CommandReceiver commandReceiver;

    private Messenger messenger;

    private ServerConnectionManager serverManager;

    private ResponseFactory responseFactory;

    private FileManager fileManager;

    private boolean isRunning;

    public ServerApplicationImpl(InetSocketAddress inetSocketAddress) {
        responseFactory = new ResponseFactoryImpl();
        clientCommandManager = new ClientCommandManagerImpl(new HashMap<>());
        FileWriter fileWriter = new FileWriterImpl("file.csv");
        DateConverter dateConverter = new DateConverterImpl(new SimpleDateFormat("dd-mm-yy"));
        fileManager = new FileManagerImpl(new FileReaderImpl(), fileWriter,
                new ParserCsv(new SpaceMarineFactoryImpl(),
                        dateConverter), new SerializerCsv(dateConverter));
        SpaceMarineCollectionManager collectionManager = new SpaceMarineCollectionManager(fileManager, "file.csv");
        commandReceiver = new CommandReceiverImpl(this, collectionManager,
                clientCommandManager);
        serverCommandManager = new ServerCommandManager(commandReceiver);
        clientCommandManager.initCommands(commandReceiver);
        commandInvoker = new CommandInvokerImpl();
        consoleInputManager = new ConsoleInputManagerImpl(new InputCommandConverterImpl(), new ConsoleReader());
        serverManager = new ServerConnectionManagerImpl(new RequestReceiverImpl(), new ResponseSenderImpl(),
                inetSocketAddress);
        isRunning = false;
    }

    /**
     * Исполнение команд в обычном режиме
     */
    @Override
    public void run() {
        isRunning = true;
        Runnable r = () -> {
            Messenger messenger = new RussianMessenger(new DateConverterImpl(new SimpleDateFormat("dd-mm-yy")));
            while (isRunning){
                String[] command = consoleInputManager.readCommand();
                try {
                    commandInvoker.invokeSpecialServerCommand(serverCommandManager.convertToCommand(command[0]));
                } catch (NoSuchCommandException e) {
                    System.out.println(messenger.getExceptionMessage("NoSuchCommand"));
                }
            }
        };
        Thread t = new Thread(r);
        t.start();

        serverManager.updateConnection();

        while (isRunning){
            try {
                Request request = serverManager.waitRequest();
                Response response = requestProcessing(request);
                serverManager.sendResponse(response);
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }
        }
    }

    /**
     * Метод для замершения исполнения
     */
    @Override
    public void exit() {
        fileManager.close();
        if(serverManager.getIsConnected()){
            serverManager.closeConnection();
        }
        isRunning = false;
        System.exit(0);
    }

    private Response requestProcessing(Request request){
        RequestType requestType = request.getRequestType();
        Response response = null;
        if(requestType.equals(RequestType.INPUT_LANGUAGE)){
            messenger = request.getMessenger();
            commandReceiver.setMessenger(messenger);
            response = responseFactory.getResponse(ResponseType.INPUT_LANGUAGE, messenger.getInputLanguageIsSuccessful());
        }
        if(requestType.equals(RequestType.INPUT_ELEMENT)){
            Command command;
            try {
                command = clientCommandManager.convertToCommand(request.getCommandName());
            } catch (NoSuchCommandException e) {
                response = responseFactory.getResponse(ResponseType.INPUT_FIELDS, false);
                return response;
            }

            if(command instanceof CommandWithElement){
                response = responseFactory.getResponse(ResponseType.INPUT_FIELDS, true);
            }
            else {
                response = responseFactory.getResponse(ResponseType.INPUT_FIELDS, false);
            }
        }
        if(requestType.equals(RequestType.EXECUTE_COMMAND)){
            try {
                Command command = clientCommandManager.convertToCommandFromRequest(request,
                        new SpaceMarineFactoryImpl());
                response = responseFactory.getResponse(clientCommandManager.getResponseTypeOfCommandExecution(command),
                        commandInvoker.invokeCommand(command));
            } catch (NoSuchCommandException e) {
                response = responseFactory.getResponse(ResponseType.COMMAND_EXECUTION,
                        messenger.getExceptionMessage("NoSuchCommand"));
            } catch (NoArgumentException e) {
                response = responseFactory.getResponse(ResponseType.COMMAND_EXECUTION,
                        messenger.getExceptionMessage("NoArgument"));
            } catch (UncorrectedFieldException e) {
                response = responseFactory.getResponse(ResponseType.COMMAND_EXECUTION,
                        messenger.getExceptionMessage("UncorrectedField"));
            }
        }
        if(requestType.equals(RequestType.END_OF_FILE)){
            commandReceiver.clearLastScripts();
            response = responseFactory.getResponse(ResponseType.SCRIPT_FINISHED,
                    messenger.getCommandIsExecutedSuccessfully("execute_script"));
        }
        return response;
    }

}
