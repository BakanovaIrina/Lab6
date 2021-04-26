package client.application;

import another.Application;
import another.messenger.Messenger;

public interface ClientApplication extends Application {

    /**
     * Метод для ввода языка
     */
    Messenger inputLanguage();

    void runFromFile(String fileName);
}
