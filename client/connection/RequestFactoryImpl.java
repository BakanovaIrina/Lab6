package client.connection;

import another.connection.request.Request;
import another.connection.request.RequestImpl;
import another.connection.request.RequestType;
import another.messenger.Messenger;

public class RequestFactoryImpl implements RequestFactory {
    @Override
    public Request getRequest(RequestType requestType, Messenger messenger){
        return new RequestImpl(requestType, messenger);
    }

    @Override
    public Request getRequest(RequestType requestType, String commandName){
        return new RequestImpl(requestType, commandName);
    }

    @Override
    public Request getRequest(RequestType requestType) {
        return new RequestImpl(requestType);
    }
}
