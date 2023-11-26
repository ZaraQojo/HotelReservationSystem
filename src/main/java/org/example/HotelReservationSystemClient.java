package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class HotelReservationSystemClient {

    private Socket clientSocket;

    public HotelReservationSystemClient() {
    }

    public void connectToServer() throws IOException {
        this.clientSocket = new Socket("127.0.0.1", 8000);
    }

    public void handleViewRequest(String viewName, Map<String, Object> parameters) throws IOException {
        String jsonData = prepareJSONData(viewName, parameters);
        sendJSONToServer(jsonData);
    }

    private String prepareJSONData(String viewName, Map<String, Object> parameters) {
        StringBuilder jsonDataBuilder = new StringBuilder();
        jsonDataBuilder.append("{");
        jsonDataBuilder.append("\"viewName\": \"").append(viewName).append("\",");
        jsonDataBuilder.append("\"parameters\": {");

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            jsonDataBuilder.append("\"");
            jsonDataBuilder.append(entry.getKey());
            jsonDataBuilder.append("\": ");

            if (entry.getValue() instanceof String) {
                jsonDataBuilder.append("\"");
                jsonDataBuilder.append(entry.getValue());
                jsonDataBuilder.append("\"");
            } else {
                jsonDataBuilder.append(entry.getValue());
            }

            jsonDataBuilder.append(",");
        }

        jsonDataBuilder.append("}");
        jsonDataBuilder.append("}");

        return jsonDataBuilder.toString();
    }

    private void sendJSONToServer(String jsonData) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        byte[] jsonDataBytes = jsonData.getBytes();
        outputStream.write(jsonDataBytes);
    }
}
