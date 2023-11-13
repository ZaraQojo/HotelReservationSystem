package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HotelReservationSystemServer {

    private ServerSocket serverSocket;

    public HotelReservationSystemServer() throws IOException {
        serverSocket = new ServerSocket(9000);
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(() -> {
                try {
                    handleClient(clientSocket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    private void handleClient(Socket clientSocket) throws IOException {
        // Read the client's request message.
        byte[] requestBytes = new byte[1024];
        int bytesRead = clientSocket.getInputStream().read(requestBytes);
        String requestMessage = new String(requestBytes, 0, bytesRead);


        // TODO: convert the request message and perform the requested operation on the system.
        // TODO: send a response message to the client.


        byte[] responseBytes = "response message".getBytes();
        clientSocket.getOutputStream().write(responseBytes);
    }

    public static void main(String[] args) throws IOException {
        HotelReservationSystemServer server = new HotelReservationSystemServer();
        server.start();
    }
}
