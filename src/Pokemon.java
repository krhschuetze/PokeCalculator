import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokemon implements Comparator<Pokemon> {
    // Properties
    private String name;
    private Long number;
    private List<String> typeList;
    // Getter/Setters
    public String Name() { return name; }
    public Long Number() { return number; }
    public List<String> TypeList() { return typeList; }
    // Constructors
    public Pokemon() { }
    public Pokemon(String pokemon, boolean calcTypes) {
        JSONObject pokeJsonObjectDecode = getFromPokeAPI("pokemon/" + pokemon);
        name = TitleCase.toTitleCase((String)pokeJsonObjectDecode.get("name"));
        number = (Long)pokeJsonObjectDecode.get("id"); // Set ID number
        if (calcTypes) {
            // Get Pokemon types
            typeList = new ArrayList<String>(){};
            JSONArray typesArray = (JSONArray) pokeJsonObjectDecode.get("types"); // Get JSONarray of types
            for (Object slot : typesArray) {
                JSONObject typeObject = (JSONObject) ((JSONObject) slot).get("type"); // Get type JSONobject
                String typeString = (String) typeObject.get("name"); // Get name string from type
                typeList.add(typeString); // Add type to list
                // Get double damage to
                // Get double damage from
            }
        }
    }
    // Methods
    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        if (o1.number > o2.number) { return -1; } // o1 is less than
        else if (o1.number.equals(o2.number)) { return 0; } // Equals
        else { return 1; } // o1 is greater than
    }
    // Statics
    public static JSONObject getFromPokeAPI(String requestedData) {
        // requestedData should look like either pokemon/{name OR number} or type/{type}
        HttpClient client = HttpClient.newHttpClient(); // 1. Create a client
        String json = "";
        HttpRequest request = HttpRequest.newBuilder() // 2. Create request
                .uri(URI.create("https://pokeapi.co/api/v2/" + requestedData))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // 3. Send request, receive response
            json = response.body(); // Return JSON as string
        }
        catch (Exception e) { System.out.println(e.getMessage()); };
        // Parse JSON
        Object file = JSONValue.parse(json);
        JSONObject jsonObjectDecode = (JSONObject)file;
        return jsonObjectDecode;
    }
}
