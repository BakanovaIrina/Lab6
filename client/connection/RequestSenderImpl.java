package client.connection;

import another.Serializer;
import another.connection.request.Request;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class RequestSenderImpl implements RequestSender{

    Serializer serializer;

    public RequestSenderImpl() {
        serializer = new RequestSerializer();
    }

    @Override
    public void sendRequest(Request request, SocketChannel socketChannel) throws IOException {
        byte[] bytes = serializer.serialize(request);
        ByteBuffer buffer = ByteBuffer.allocate(1000000);
        buffer.put(bytes);
        buffer.flip();
        socketChannel.write(buffer);
    }
}
