import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.simple.*;

public class Main {
    public static void main(String[] args) {
        PokemonTeam team1 = new PokemonTeam();
        team1.addPokemon();
        team1.displayPokemon();
    }
}