package another.connection.request;

import another.messenger.Messenger;

import java.util.ArrayList;
import java.util.HashMap;

public interface Request{

    HashMap<String, String> getInputFields();

    String getCommandName();

    String getValue();

    RequestType getRequestType();

    Messenger getMessenger();

    void setInputFields(HashMap<String, String> inputFields);

    void setValue(String value);
}
