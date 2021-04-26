package another.connection.request;

import another.messenger.Messenger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class RequestImpl implements Request, Serializable {

    private static final long serialVersionUID = 1L;

    private RequestType requestType;

    private String commandName;

    private Messenger messenger;

    private HashMap<String, String> inputFields;

    private String value;

    public RequestImpl(RequestType requestType, Messenger messenger) {
        this.requestType = requestType;
        this.messenger = messenger;
    }

    public RequestImpl(RequestType requestType, String commandName) {
        this.commandName = commandName;
        this.requestType = requestType;
    }

    public RequestImpl(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public HashMap<String, String> getInputFields() {
        return inputFields;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public Messenger getMessenger() {
        return messenger;
    }

    @Override
    public void setInputFields(HashMap<String, String> inputFields) {
        this.inputFields = inputFields;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
