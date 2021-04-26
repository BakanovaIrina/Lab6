package client;

import client.application.ClientApplication;
import client.application.ClientApplicationImpl;

import java.net.InetSocketAddress;

public class MainClient {
    public static void main(String[] args) {
        ClientApplication clientApplication = new ClientApplicationImpl(
                new InetSocketAddress("localhost", 2021));
        clientApplication.run();
    }
}
