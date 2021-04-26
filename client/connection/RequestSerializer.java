package client.connection;

import another.Serializer;
import another.connection.request.Request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RequestSerializer implements Serializer<Request> {
    @Override
    public byte[] serialize(Request type) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(type);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }
}
