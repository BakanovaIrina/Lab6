package server.connection;

import another.Deserializer;
import another.connection.request.Request;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RequestDeserializer implements Deserializer<Request> {
    @Override
    public Request deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Request request = (Request) inputStream.readObject();
        return request;
    }
}
