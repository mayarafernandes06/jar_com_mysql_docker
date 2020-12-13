/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.system.monitor.api;


import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.net.URI;

/**
 *
 * @author Aluno
 */
public class Slack {
    
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";
    
    public static void sendMessage(JSONObject content) throws IOException, InterruptedException{
        
        HttpRequest request;
        request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/jason")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
