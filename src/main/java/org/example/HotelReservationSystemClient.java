package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HotelReservationSystemClient {

    private Socket clientSocket; // TODO: Check if we can make this Final

    public HotelReservationSystemClient() throws IOException {
        try {
            clientSocket = new Socket("localhost", 9000);
        } catch (IOException e) {
            System.out.println("The server is off: " + e.getMessage());
            System.out.println("Please start the server and try again.");
            System.exit(1);
        }
    }

    public void sendRequest(String requestMessage) throws IOException {
        byte[] requestBytes = requestMessage.getBytes();
        clientSocket.getOutputStream().write(requestBytes);
    }

    public String receiveResponse() throws IOException {
        byte[] responseBytes = new byte[1024];
        int bytesRead = clientSocket.getInputStream().read(responseBytes);

        return new String(responseBytes, 0, bytesRead);
    }

    public void close() throws IOException {
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        HotelReservationSystemClient client = new HotelReservationSystemClient();

        String requestMessage = "dummy request";
        client.sendRequest(requestMessage);

        String responseMessage = client.receiveResponse();         // Receive the response from the server.

        // TODO: Parse the response message and display the response information to the user.

        client.close();
    }
}
