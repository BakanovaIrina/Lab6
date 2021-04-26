package server.commandModule;

import another.exceptions.NoArgumentException;
import another.exceptions.NoSuchCommandException;
import server.commandModule.commands.Command;

/**
 * Интерфейс CommandInvoker
 */
public interface CommandInvoker {

    /**
     * Метод, заставляющий команду исполняться
     * @throws NoSuchCommandException - бросается, если такой команды не существует
     * @throws NoArgumentException - бросается, если команда не была введена
     */
    String invokeCommand(Command command) throws NoSuchCommandException,
            NoArgumentException;

    String invokeSpecialServerCommand(Command command) throws NoSuchCommandException;
}
