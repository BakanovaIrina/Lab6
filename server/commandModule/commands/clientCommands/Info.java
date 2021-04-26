package server.commandModule.commands.clientCommands;


import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда info - выводит информацию о коллекции
 */
public class Info extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Info(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("info");
    }

    @Override
    public String execute() {
        return commandReceiver.info();
    }
}
