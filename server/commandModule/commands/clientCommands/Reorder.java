package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда reorder - отсортировывает колекцию в обратном порядке
 */
public class Reorder extends Command {

    /**
     * Исполнитель команды
     */
    CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Reorder(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("reorder");
    }

    @Override
    public String execute() {
        return commandReceiver.reorder();
    }
}
