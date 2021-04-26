package client.connection;

import another.connection.request.Request;
import another.connection.request.RequestType;
import another.messenger.Messenger;

public interface RequestFactory {
    Request getRequest(RequestType requestType, Messenger messenger);

    Request getRequest(RequestType requestType, String commandName);

    Request getRequest(RequestType requestType);
}
