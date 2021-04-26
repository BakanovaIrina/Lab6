package another.connection.response;

import java.io.Serializable;

public class ResponseImpl implements Response, Serializable {
    private static final long serialVersionUID = 1L;
    private ResponseType responseType;
    private String message;
    private boolean isInputNecessary;

    public ResponseImpl(ResponseType responseType, String message) {
        this.responseType = responseType;
        this.message = message;
    }

    public ResponseImpl(ResponseType responseType, boolean isInputNecessary) {
        this.responseType = responseType;
        this.isInputNecessary = isInputNecessary;
    }

    public ResponseImpl(ResponseType responseType){
        this.responseType = responseType;
    }

    @Override
    public ResponseType getResponseType() {
        return responseType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean getIsInputNecessary() {
        return isInputNecessary;
    }
}
