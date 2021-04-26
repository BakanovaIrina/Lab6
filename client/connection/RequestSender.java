package client.connection;

import another.connection.request.Request;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public interface RequestSender {
    void sendRequest(Request request, SocketChannel socketChannel) throws IOException;
}
