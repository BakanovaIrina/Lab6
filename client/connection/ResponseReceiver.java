package client.connection;

import another.connection.response.Response;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public interface ResponseReceiver {

    Response receiveResponse(SocketChannel socketChannel) throws IOException, ClassNotFoundException;
}
