package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.baseClass.SpaceMarine;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;
import server.commandModule.commands.commandInterfaces.CommandWithElement;

/**
 * Команда add_if_min
 */
public class AddIfMin extends Command implements CommandWithElement {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    private SpaceMarine spaceMarine;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public AddIfMin(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("add_if_min");
    }
    @Override
    public String execute() {
        return commandReceiver.addIfMin(spaceMarine);
    }

    @Override
    public void setElement(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }
}
