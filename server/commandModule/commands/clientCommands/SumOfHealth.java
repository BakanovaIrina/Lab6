package server.commandModule.commands.clientCommands;


import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;

/**
 * Команда sum_of_health - выводит сумму здоровья всех элементов
 */
public class SumOfHealth extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public SumOfHealth(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("sum_of_health");
    }

    @Override
    public String execute() {
        return commandReceiver.sumOfHealth();
    }
}
