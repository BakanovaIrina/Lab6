package server.connection;

import another.connection.response.Response;
import another.connection.response.ResponseType;

public interface ResponseFactory {

    Response getResponse(ResponseType responseType);

    Response getResponse(ResponseType responseType, boolean isInputNecessary);

    Response getResponse(ResponseType responseType, String message);
}
