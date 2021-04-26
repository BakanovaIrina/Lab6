package client.connection;

import another.connection.request.Request;
import another.connection.response.Response;

import java.io.IOException;

public interface RequestManager {

    void sendRequest(Request request) throws IOException;

    Response waitResponse() throws IOException, ClassNotFoundException;

    void updateConnection();
}
