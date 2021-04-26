package server.connection;

import another.connection.response.Response;
import another.connection.response.ResponseImpl;
import another.connection.response.ResponseType;

public class ResponseFactoryImpl implements ResponseFactory{

    @Override
    public Response getResponse(ResponseType responseType){
        return new ResponseImpl(responseType);
    }

    @Override
    public Response getResponse(ResponseType responseType, boolean isInputNecessary){
        return new ResponseImpl(responseType, isInputNecessary);
    }

    @Override
    public Response getResponse(ResponseType responseType, String message){
        return new ResponseImpl(responseType, message);
    }
}
