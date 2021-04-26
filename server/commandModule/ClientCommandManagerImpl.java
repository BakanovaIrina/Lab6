package server.commandModule;

import another.baseClass.SpaceMarine;
import another.connection.request.Request;
import another.connection.response.ResponseType;
import another.exceptions.NoArgumentException;
import another.exceptions.NoSuchCommandException;
import another.exceptions.UncorrectedFieldException;
import server.commandModule.commands.Command;
import server.commandModule.commands.clientCommands.ExecuteScript;
import server.commandModule.commands.clientCommands.*;
import server.commandModule.commands.commandInterfaces.CommandWithElement;
import server.commandModule.commands.commandInterfaces.CommandWithInputCommands;
import server.commandModule.commands.commandInterfaces.CommandWithInputValue;
import server.commandModule.commands.commandInterfaces.ExitCommand;
import server.collection.spaceMarineCreation.SpaceMarineFactory;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Класс для работы с командами
 */
public class ClientCommandManagerImpl implements ClientCommandManager{

    /**
     * HashMap, содержащее в себе имена и соответствующие команды
     */
    private HashMap<String, Command> commands;

    /**
     * Конструктор
     * @param commands - команды
     */
    public ClientCommandManagerImpl(HashMap<String, Command> commands){
        this.commands = commands;
    }

    /**
     * Конструктор
     * @param commandReceiver - необходим для инициализации
     */
    public ClientCommandManagerImpl(CommandReceiver commandReceiver) {
        commands = new HashMap<>();
        initCommands(commandReceiver);
    }

    @Override
    public void initCommands(CommandReceiver commandReceiver) {
        commands.put("exit", new ClientExit());
        commands.put("clear", new Clear(commandReceiver));
        commands.put("average_of_health", new AverageOfHealth(commandReceiver));
        commands.put("info", new Info(commandReceiver));
        commands.put("help", new Help(commandReceiver));
        commands.put("reorder", new Reorder(commandReceiver));
        commands.put("show", new Show(commandReceiver));
        commands.put("sum_of_health", new SumOfHealth(commandReceiver));
        commands.put("remove_by_id", new RemoveById(commandReceiver));
        commands.put("update", new UpdateId(commandReceiver));
        commands.put("add", new Add(commandReceiver));
        commands.put("add_if_min", new AddIfMin(commandReceiver));
        commands.put("insert_at", new InsertAt(commandReceiver));
        commands.put("execute_script", new ExecuteScript(commandReceiver));
        commands.put("group_counting_by_chapter", new GroupCountingByChapter(commandReceiver));
    }

    @Override
    public Stream getStreamOfCommands() {
        return commands.values().stream();
    }

    @Override
    public Command convertToCommand(String commandName) throws NoSuchCommandException {
        Command command;
        if (commands.containsKey(commandName)) {
            command = commands.get(commandName);
        }
        else {
            throw new NoSuchCommandException();
        }
        return command;
    }

    @Override
    public Command convertToCommandFromRequest(Request request, SpaceMarineFactory spaceMarineFactory) throws
            NoSuchCommandException, NoArgumentException, UncorrectedFieldException {
        Command command;
        String commandName = request.getCommandName();
        String value = request.getValue();
        if (commands.containsKey(commandName)) {
            command = commands.get(commandName);
            if(command instanceof CommandWithInputValue){
                if(value == null || value == ""){
                    throw new NoArgumentException();
                }
                else {
                    ((CommandWithInputValue) command).setValue(value);
                }
            }
            if(command instanceof CommandWithElement){
                SpaceMarine spaceMarine = spaceMarineFactory.createSpaceMarine(request.getInputFields());
                ((CommandWithElement) command).setElement(spaceMarine);
            }
        }
        else {
            throw new NoSuchCommandException();
        }
        return command;
    }

    @Override
    public ResponseType getResponseTypeOfCommandExecution(Command command) {
        ResponseType responseType;
        if(command instanceof ExitCommand){
            responseType = ResponseType.CLIENT_EXIT;
        }
        else if (command instanceof CommandWithInputCommands){
            responseType = ResponseType.EXECUTE_SCRIPT;
        }
        else {
            responseType = ResponseType.COMMAND_EXECUTION;
        }
        return responseType;
    }

}
