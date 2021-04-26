package server.connection;

import another.Serializer;
import another.connection.response.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ResponseSerializer implements Serializer<Response> {
    @Override
    public byte[] serialize(Response type) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(type);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }
}
