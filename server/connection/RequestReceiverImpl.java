package server.connection;

import another.Deserializer;
import another.connection.request.Request;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class RequestReceiverImpl implements RequestReceiver {

    private Deserializer<Request> deserializer;

    public RequestReceiverImpl() {
        this.deserializer = new RequestDeserializer();
    }

    @Override
    public Request receiveRequest(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        byte[] b = new byte[1000000];
        ByteBuffer buffer = ByteBuffer.wrap(b);
        buffer.clear();
        socketChannel.read(buffer);
        Request request = deserializer.deserialize(b);
        return request;
    }
}