package server.connection;

import another.connection.response.Response;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public interface ResponseSender {
    void sendResponse(Response response, SocketChannel socketChannel) throws IOException, ClassNotFoundException;
}
