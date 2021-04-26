package client.application;

import another.connection.request.Request;
import another.console.*;
import another.exceptions.UncorrectedFileException;
import another.exceptions.UncorrectedNullException;
import client.*;
import client.connection.RequestFactory;
import client.connection.RequestFactoryImpl;
import another.connection.request.RequestType;
import another.connection.response.Response;
import another.connection.response.ResponseType;
import server.file.FileReaderImpl;
import another.messenger.EnglishMessenger;
import another.messenger.Messenger;
import another.messenger.RussianMessenger;
import client.connection.RequestManager;
import client.connection.RequestManagerImpl;
import client.inputOutput.clientFile.FileManager;
import client.inputOutput.clientFile.FileManagerImpl;
import client.inputOutput.output.*;
import client.inputOutput.script.ScriptManager;
import client.inputOutput.script.ScriptManagerImpl;
import client.inputOutput.script.ScriptReaderImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class ClientApplicationImpl implements ClientApplication {

    private InputManager inputManager;

    private DateConverter dateConverter;

    private OutputManager outputManager;

    private RequestManager requestManager;

    private RequestFactory requestFactory;

    private boolean isRunning;

    public ClientApplicationImpl(InetSocketAddress inetSocketAddress) {
        requestFactory = new RequestFactoryImpl();
        requestManager = new RequestManagerImpl(inetSocketAddress);
        dateConverter = new DateConverterImpl(new SimpleDateFormat("yyyy-mm-dd"));
    }

    /**
     * Исполнение команд в обычном режиме
     */
    @Override
    public void run() {
        isRunning = true;

        inputManager = new ConsoleInputManagerImpl(new InputCommandConverterImpl(), new ConsoleReader());

        Messenger messenger = inputLanguage();
        outputManager = new OutputManagerImpl(messenger, new ConsolePrinter());

        requestManager.updateConnection();
        Response response = null;
        try {
            requestManager.sendRequest(requestFactory.getRequest(RequestType.INPUT_LANGUAGE, messenger));
            response = requestManager.waitResponse();
        } catch (IOException | ClassNotFoundException e) {
            outputManager.printException("ConnectionException");
            exit();
        }

        outputManager.print(response.getMessage());

        while (isRunning){
            String[] command = inputManager.readCommand();
            mainProcess(command, inputManager, false);

        }
    }

    /**
     * Метод для ввода языка
     */
    @Override
    public Messenger inputLanguage() {
        System.out.println("What language do you want to continue in? (Русский, English)");
        String language = null;
        Messenger messenger;
        if (inputManager instanceof ConsoleInputManager){
            language = ((ConsoleInputManager) inputManager).readLanguage();
        }
        if (language == "english"){
            messenger = new EnglishMessenger(dateConverter);
        }
        else {
            if (language.equals("русский")) {
                messenger = new RussianMessenger(dateConverter);
            } else {
                messenger = new EnglishMessenger(dateConverter);
            }
        }
        return  messenger;
    }

    @Override
    public void runFromFile(String fileName) {
        FileManager fileManager = new FileManagerImpl(new FileReaderImpl());
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = fileManager.getInputStreamForScript(fileName);
        } catch (FileNotFoundException | UncorrectedNullException | UncorrectedFileException e) {
            outputManager.printException("UncorrectedFile");
        }

        ScriptManager scriptManager = new ScriptManagerImpl(new ScriptReaderImpl(inputStreamReader),
                new InputCommandConverterImpl());

        while (scriptManager.isReady()){
            mainProcess(scriptManager.readCommand(), scriptManager, true);
        }

        Request requestOfEnd = requestFactory.getRequest(RequestType.END_OF_FILE);
        Response response = null;
        try {
            requestManager.sendRequest(requestOfEnd);
            response = requestManager.waitResponse();
        } catch (IOException | ClassNotFoundException e) {
            outputManager.printException("ConnectionException");
        }
        outputManager.print(response.getMessage());
    }

    private void mainProcess(String[] command, InputManager inputManager, boolean isFromFile){
        Request requestOfInputElement = requestFactory.getRequest(RequestType.INPUT_ELEMENT, command[0]);
        Request requestOfExecuteCommand = requestFactory.getRequest(RequestType.EXECUTE_COMMAND, command[0]);
        Response response = null;
        try {
            requestManager.sendRequest(requestOfInputElement);
            response = requestManager.waitResponse();
        } catch (IOException | ClassNotFoundException e) {
            outputManager.printException("ConnectionException");
        }

        if(response.getResponseType().equals(ResponseType.INPUT_FIELDS) && response.getIsInputNecessary() == true){
            HashMap<String, String> fields = inputManager.readSpaceMarine(outputManager);
            requestOfExecuteCommand.setInputFields(fields);
        }

        if(command.length == 2){
            requestOfExecuteCommand.setValue(command[1]);
        }

        try {
            requestManager.sendRequest(requestOfExecuteCommand);
            response = requestManager.waitResponse();
        } catch (IOException | ClassNotFoundException e) {
            outputManager.printException("ConnectionException");
        }


        ResponseType responseType = response.getResponseType();
        if(responseType.equals(ResponseType.CLIENT_EXIT)){
            exit();
        }

        if(responseType.equals(ResponseType.EXECUTE_SCRIPT) && response.getMessage() != null){
            runFromFile(response.getMessage());
        }

        if(responseType.equals(ResponseType.COMMAND_EXECUTION)){
            if(isFromFile){
                outputManager.print("> " + command[0]);
                outputManager.print(response.getMessage());
            }
            else {
                outputManager.print(response.getMessage());
            }
        }
    }

    /**
     * Метод для замершения исполнения
     */
    @Override
    public void exit() {
        isRunning = false;
    }
}
