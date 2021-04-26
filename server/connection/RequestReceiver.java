package server.connection;

import another.connection.request.Request;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public interface RequestReceiver {
    Request receiveRequest(SocketChannel socketChannel) throws IOException, ClassNotFoundException;

}
