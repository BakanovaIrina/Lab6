package client.connection;

import another.Deserializer;
import another.connection.response.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ResponseDeserializer implements Deserializer<Response> {
    @Override
    public Response deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Response response = (Response) inputStream.readObject();
        return response;
    }
}
