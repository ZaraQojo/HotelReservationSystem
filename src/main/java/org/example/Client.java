package org.example;

import org.example.View.MainView;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final String host;
    private final int port;
    private Socket socket; // Maintain a persistent connection

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connectToServer() throws IOException {
        if (socket == null || !socket.isConnected()) {
            socket = new Socket(host, port);
        }
    }

    public void sendRequest(String request) {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            pw.println(request);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receiveResponse() {
        String response = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            response = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        Client client = new Client(host, port);

        try {
            client.connectToServer(); // Establish a persistent connection
            MainView view = new MainView();
            view.start();
            System.out.println("Enter room number:");
            int roomNumber = new Scanner(System.in).nextInt();

            client.sendRequest("BOOK_ROOM" + roomNumber);

            // Receive the response from the server
            String response = client.receiveResponse();
            System.out.println("Received response from server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
