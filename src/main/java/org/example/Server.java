package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final int port;
    private final ExecutorService executorService;

    public Server(int port) {
        this.port = port;
        this.executorService = Executors.newFixedThreadPool(100);
    }

    public static void main(String[] args) {
        int port = 12345;

        Server server = new Server(port);
        server.startServer();
    }

    private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started listening on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
