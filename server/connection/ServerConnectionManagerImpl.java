package server.connection;

import another.connection.request.Request;
import another.connection.response.Response;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerConnectionManagerImpl implements ServerConnectionManager {
    private RequestReceiver requestReceiver;

    private ResponseSender responseSender;

    private final SocketAddress address;

    private ServerSocketChannel serverSocketChannel;

    private SocketChannel socketChannel;

    private boolean isConnected;

    public ServerConnectionManagerImpl(RequestReceiver requestReceiver, ResponseSender responseSender,
                               SocketAddress address) {
        this.requestReceiver = requestReceiver;
        this.responseSender = responseSender;
        this.address = address;
        isConnected = false;
    }

    @Override
    public Request waitRequest() throws IOException, ClassNotFoundException {
        return requestReceiver.receiveRequest(socketChannel);
    }

    @Override
    public void sendResponse(Response response) throws IOException, ClassNotFoundException {
        responseSender.sendResponse(response, socketChannel);
    }

    @Override
    public void updateConnection(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            //serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(address);
            socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            isConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            serverSocketChannel.close();
            socketChannel.close();
            isConnected = false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){}
    }

    @Override
    public boolean getIsConnected() {
        return isConnected;
    }


}
