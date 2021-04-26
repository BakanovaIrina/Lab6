package server.commandModule;

import another.exceptions.NoSuchCommandException;
import server.commandModule.commands.Command;

import java.util.stream.Stream;

/**
 * Интерфейс класса, отвечающего за хранение всех команд
 */
public interface CommandManager {

    /**
     * Метод для инициализации всех команд
     * @param commandReceiverActions - исполнитель команд
     */
    void initCommands(CommandReceiver commandReceiverActions);

    /**
     * Метод для получения списка всех команд
     * @return поток всех возможных команд
     */
    Stream<Command> getStreamOfCommands();

    /**
     * Метод, конвертирующий строку в команду
     * @param commandName - имя команды
     * @return саму команду
     * @throws NoSuchCommandException - кидается, если такой команды не существует
     */
    Command convertToCommand(String commandName) throws NoSuchCommandException;
}
