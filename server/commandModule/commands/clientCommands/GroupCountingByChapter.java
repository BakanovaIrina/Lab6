package server.commandModule.commands.clientCommands;


import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда group_counting_by_chapter - группирует элементы по главам
 */
public class GroupCountingByChapter extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public GroupCountingByChapter(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("group_counting_by_chapter");
    }

    @Override
    public String execute() {
        return commandReceiver.groupCountingByChapter();
    }
}
