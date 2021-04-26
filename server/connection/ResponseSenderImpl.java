package server.connection;

import another.Serializer;
import another.connection.response.Response;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ResponseSenderImpl implements ResponseSender{

    private Serializer<Response> serializer;

    public ResponseSenderImpl() {
        this.serializer = new ResponseSerializer();
    }

    @Override
    public void sendResponse(Response response, SocketChannel socketChannel) throws IOException{
        byte[] bytes = serializer.serialize(response);
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        buffer.put(bytes);
        buffer.flip();
        socketChannel.write(buffer);
    }
}
