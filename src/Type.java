import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private String name;
    private List<String> doubleFrom;
    private List<String> doubleTo;
    private List<String> noneFrom;
    private List<String> noneTo;
    // Getter/Setter
    public String Name() { return name; }
    public List<String> DoubleFrom() { return doubleFrom; }
    public List<String> DoubleTo() { return doubleTo; }
    public List<String> NoneFrom() { return noneFrom; }
    public List<String> NoneTo() { return noneTo; }
    // Constructor
    public Type(String typeName) {
        JSONObject typeJsonObjectDecode= Pokemon.getFromPokeAPI("type/" + typeName);
        name = TitleCase.toTitleCase((String)typeJsonObjectDecode.get("name"));
        JSONObject damageRelations = (JSONObject) typeJsonObjectDecode.get("damage_relations");

        JSONArray jsonDoubleFrom = (JSONArray) damageRelations.get("double_damage_from");
        doubleFrom = getTypesFromJSONArray(jsonDoubleFrom);
        JSONArray jsonDoubleTo = (JSONArray) damageRelations.get("double_damage_to");
        doubleTo = getTypesFromJSONArray(jsonDoubleTo);
        JSONArray jsonNoneFrom = (JSONArray) damageRelations.get("no_damage_from");
        noneFrom = getTypesFromJSONArray(jsonNoneFrom);
        JSONArray jsonNoneTo = (JSONArray) damageRelations.get("no_damage_to");
        noneTo = getTypesFromJSONArray(jsonNoneTo);
    }
    // Methods
    public List<String> getTypesFromJSONArray(JSONArray inputArray) {
        List<String> typesFromArray = new ArrayList<String>(){};
        for (Object type : inputArray) {
            String typeString = (String) ((JSONObject) type).get("name"); // Get type name from JSONarray
            typesFromArray.add(typeString); // Add type to list
        }
        return typesFromArray;
    }
}
