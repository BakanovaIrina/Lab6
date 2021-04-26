package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;
import server.commandModule.commands.commandInterfaces.CommandWithInputValue;

/**
 * Команда remove_by_id - удалить элемент коллекции по его id
 */
public class RemoveById extends Command implements CommandWithInputValue {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    /**
     * Значение id элемента, который надо удалить
     */
    int value;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public RemoveById(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("remove_by_id");
    }

    @Override
    public String execute() {
        return commandReceiver.removeById(value);
    }

    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = Integer.parseInt(value);
    }
}
