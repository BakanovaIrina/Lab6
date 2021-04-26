package server.commandModule;

import another.exceptions.NoSuchCommandException;
import server.commandModule.commands.Command;
import server.commandModule.commands.serverCommands.Save;
import server.commandModule.commands.serverCommands.ServerExit;

import java.util.HashMap;
import java.util.stream.Stream;

public class ServerCommandManager implements CommandManager{

    /**
     * HashMap, содержащее в себе имена и соответствующие команды
     */
    private HashMap<String, Command> commands;

    /**
     * Конструктор
     * @param commands - команды
     */
    public ServerCommandManager(HashMap<String, Command> commands){
        this.commands = commands;
    }

    /**
     * Конструктор
     * @param commandReceiver - необходим для инициализации
     */
    public ServerCommandManager(CommandReceiver commandReceiver) {
        commands = new HashMap<>();
        initCommands(commandReceiver);
    }

    @Override
    public void initCommands(CommandReceiver commandReceiver) {
        commands.put("exit", new ServerExit(commandReceiver));
        //commands.put("execute_script", new ExecuteScript(commandReceiver));
        commands.put("save", new Save(commandReceiver));
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

}
