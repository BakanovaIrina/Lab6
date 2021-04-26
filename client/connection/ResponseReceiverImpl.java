package client.connection;

import another.Deserializer;
import another.connection.response.Response;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ResponseReceiverImpl implements ResponseReceiver{

    private Deserializer<Response> deserializer;

    public ResponseReceiverImpl() {
        deserializer = new ResponseDeserializer();
    }

    @Override
    public Response receiveResponse(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        socketChannel.read(buffer);
        buffer.flip();
        return deserializer.deserialize(buffer.array());
    }
}
