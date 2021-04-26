package client.connection;

import another.connection.request.Request;
import another.connection.response.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class RequestManagerImpl implements RequestManager{

    private RequestSender requestSender;

    private ResponseReceiver responseReceiver;

    private final InetSocketAddress inetAddress;

    private SocketChannel socketChannel;

    public RequestManagerImpl(InetSocketAddress inetAddress) {
        this.inetAddress = inetAddress;
        requestSender = new RequestSenderImpl();
        responseReceiver = new ResponseReceiverImpl();
    }

    @Override
    public void sendRequest(Request request) throws IOException {
        requestSender.sendRequest(request, socketChannel);
    }

    @Override
    public Response waitResponse() throws IOException, ClassNotFoundException {
        return responseReceiver.receiveResponse(socketChannel);
    }

    @Override
    public void updateConnection() {
        try {
            socketChannel = SocketChannel.open(inetAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
