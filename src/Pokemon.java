import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Pokemon {
    // Properties
    private String name;
    private Long number;
    // Getter/Setters
    public String Name() { return name; }
    public Long Number() { return number; }
    // Constructors
    public Pokemon() { name = "UNDEFINED"; }
    public Pokemon(String pokemon) {
        HttpClient client = HttpClient.newHttpClient(); // 1. Create a client
        String json = "";
        HttpRequest request = HttpRequest.newBuilder() // 2. Create request
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + pokemon))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // 3. Send request, receive response
            json = response.body(); // Return Pokemon JSON as string
        }
        catch (Exception e) { System.out.println(e.getMessage()); };
        // Parse JSON
        Object file = JSONValue.parse(json);
        JSONObject jsonObjectdecode = (JSONObject)file;
        String lowerName = (String)jsonObjectdecode.get("name"); // Get name
        name = lowerName.substring(0,1).toUpperCase() + lowerName.substring(1, lowerName.length()); // Set name
        number = (Long)jsonObjectdecode.get("order");
    }
}
