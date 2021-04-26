package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда show - вывести все элементы коллекции
 */
public class Show extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Show(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("show");
    }

    @Override
    public String execute() {
        return commandReceiver.show();
    }
}
