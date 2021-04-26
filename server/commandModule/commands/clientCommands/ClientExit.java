package server.commandModule.commands.clientCommands;

import another.messenger.Messenger;
import server.commandModule.commands.Command;
import server.commandModule.commands.commandInterfaces.ExitCommand;

public class ClientExit extends Command implements ExitCommand {
    /**
     * Метод, исполняющий команду
     */
    @Override
    public String execute() {
        return null;
    }

    /**
     * Метод, выводящий информацию о данной команде
     *
     * @param messenger
     */
    @Override
    public String writeInfo(Messenger messenger) {
        return messenger.getCommandDescription("exit");
    }
}
