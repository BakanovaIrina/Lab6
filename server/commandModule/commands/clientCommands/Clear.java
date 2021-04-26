package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда clear - очищает коллекцию
 */
public class Clear extends Command {

    /**
     * Исполнитель команды
     */
    CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Clear(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("clear");
    }

    @Override
    public String execute() {
        return commandReceiver.clear();
    }
}
