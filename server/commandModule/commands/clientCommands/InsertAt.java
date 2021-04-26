package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.baseClass.SpaceMarine;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;
import server.commandModule.commands.commandInterfaces.CommandWithElement;
import server.commandModule.commands.commandInterfaces.CommandWithInputValue;

/**
 * Команда insert_at
 */
public class InsertAt extends Command implements CommandWithInputValue, CommandWithElement {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    private SpaceMarine spaceMarine;

    /**
     * Значение индекса
     */
    int value;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public InsertAt(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("insert_at");
    }

    @Override
    public String execute() {
        return commandReceiver.insertAt(value, spaceMarine);
    }


    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = Integer.parseInt(value);
    }

    @Override
    public void setElement(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }
}
