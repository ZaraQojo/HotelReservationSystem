package org.example;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class HotelReservationSystemServer {

    private static final int SERVER_PORT = 8000;
    private final ExecutorService threadPool;

    public HotelReservationSystemServer() {
        this.threadPool = Executors.newFixedThreadPool(20);
    }

    public void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Hotel Reservation System Server started on port " + SERVER_PORT);

            do {
                Socket clientSocket = serverSocket.accept();
                HotelReservationSystemRequestHandler requestHandler = new HotelReservationSystemRequestHandler(clientSocket);
                threadPool.submit(requestHandler);
            } while (true);
        }
    }

    public static class HotelReservationSystemRequestHandler implements Runnable {

        private Socket clientSocket;

        public HotelReservationSystemRequestHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                byte[] jsonDataBytes = new byte[1024];
                int bytesRead = inputStream.read(jsonDataBytes);
                String jsonData = new String(jsonDataBytes, 0, bytesRead);

                String viewName = extractViewNameFromJSON(jsonData);
                Map<String, Object> parameters = extractParametersFromJSON(jsonData);

                processRequest(viewName, parameters);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void processRequest(String viewName, Map<String, Object> parameters) {
            switch (viewName) {
                case "HotelRoomAvailability":
                    // TODO: Process request for hotel room availability
                    break;
                case "MakeReservation":
                    // TODO: Process request to make a reservation
                    break;
                case "CancelReservation":
                    // TODO: Process request to cancel a reservation
                    break;
                default:
                    // TODO: Handle invalid viewName
                    System.err.println("Invalid viewName: " + viewName);
                    break;
            }
            // TODO: Prepare response data
            // TODO: Convert response data to JSON format
            // TODO: Send JSON response back to client
        }

        private String extractViewNameFromJSON(String jsonData) {
            int startIndex = jsonData.indexOf("\"viewName\": \"") + 15;
            int endIndex = jsonData.indexOf("\",");
            String viewName = jsonData.substring(startIndex, endIndex);
            return viewName;
        }

        private Map<String, Object> extractParametersFromJSON(String jsonData) {
            Map<String, Object> parameters = new HashMap<>();
            int startIndex = jsonData.indexOf("{") + 1;
            int endIndex = jsonData.lastIndexOf("}");
            String parametersString = jsonData.substring(startIndex, endIndex);

            String[] parameterPairs = parametersString.split(",");
            for (String parameterPair : parameterPairs) {
                String[] keyValue = parameterPair.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                if (value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                } else {
                    try {
                        int intValue = Integer.parseInt(value);
                        value = String.valueOf(intValue);
                    } catch (NumberFormatException e) {
                        // Do nothing if the value is not a number
                    }
                }

                parameters.put(key, value);
            }

            return parameters;
        }
    }

}
