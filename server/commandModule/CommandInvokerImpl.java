package server.commandModule;

import server.commandModule.commands.Command;

/**
 * Класс CommandInvoker
 */
public class CommandInvokerImpl implements CommandInvoker {

    @Override
    public String invokeCommand(Command command) {
        return command.execute();

    }

    @Override
    public String invokeSpecialServerCommand(Command command) {
        String result = command.execute();
        return result;
    }

}
