package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда average_of_health, выводящая среднее значение поля health всех элементов коллекции
 */
public class AverageOfHealth extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public AverageOfHealth(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("average_of_health");
    }

    @Override
    public String execute() {
        return commandReceiver.averageOfHealth();
    }
}
