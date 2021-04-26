package server.commandModule.commands.clientCommands;

import another.messenger.Messenger;
import server.commandModule.CommandReceiver;
import server.commandModule.commands.Command;
import server.commandModule.commands.commandInterfaces.CommandWithInputCommands;
import server.commandModule.commands.commandInterfaces.CommandWithInputValue;

public class ExecuteScript extends Command implements CommandWithInputValue, CommandWithInputCommands {

    private CommandReceiver commandReceiver;

    private String value;

    public ExecuteScript(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    /**
     * Метод, исполняющий команду
     */
    @Override
    public String execute() {
        //Сделать
        return commandReceiver.executeScript(value);
    }

    /**
     * Метод, выводящий информацию о данной команде
     *
     * @param messenger
     */
    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("execute_script");
    }

    /**
     * Сеттер для значения
     *
     * @param value - значение
     * @throws NumberFormatException - возникает, если пользователь ввел несоответствующее для данной команды
     *                               значение
     */
    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = value;
    }
}
