package server.commandModule.commands.clientCommands;

import server.commandModule.commands.Command;
import another.baseClass.SpaceMarine;
import another.messenger.Messenger;
import server.commandModule.CommandReceiver;
import server.commandModule.commands.commandInterfaces.CommandWithElement;

/**
 * Команда Add
 */
public class Add extends Command implements CommandWithElement {

    /**
     * Исполнитель команды
     */
    private CommandReceiver commandReceiver;

    private SpaceMarine spaceMarine;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Add(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("add");
    }
    @Override
    public String execute() {
        return commandReceiver.add(spaceMarine);
    }

    @Override
    public void setElement(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }
}
