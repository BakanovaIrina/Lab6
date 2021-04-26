package another.messenger;

import another.messenger.*;

import java.io.Serializable;

/**
 * Интерфейс всех Messengers
 */
public interface Messenger extends ExceptionMessages, AnotherMessenger, CommandsMessages,
        CollectionMessenger, InputMessenger, ConnectionMessages, Serializable {}
