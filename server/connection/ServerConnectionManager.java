package server.connection;

import another.connection.request.Request;
import another.connection.response.Response;

import java.io.IOException;

public interface ServerConnectionManager {
    Request waitRequest() throws IOException, ClassNotFoundException;
    void sendResponse(Response response) throws IOException, ClassNotFoundException;
    void updateConnection();
    void closeConnection();
}
