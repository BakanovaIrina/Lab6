package server.commandModule.commands.clientCommands;


import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда help - вывести справку по доступным командам
 */
public class Help extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Help(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("help");
    }

    @Override
    public String execute() {
        return commandReceiver.help();
    }
}
