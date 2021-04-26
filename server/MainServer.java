package server;

import server.application.ServerApplication;
import server.application.ServerApplicationImpl;

import java.net.InetSocketAddress;

public class MainServer {
    public static void main(String[] args) {
        ServerApplication application = new ServerApplicationImpl(new InetSocketAddress(2021));
        application.run();
    }
}
