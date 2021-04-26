package another.connection.response;

public interface Response{
    ResponseType getResponseType();
    String getMessage();
    boolean getIsInputNecessary();
}
