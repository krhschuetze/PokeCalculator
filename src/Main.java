import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.*;

public class Main {
    public static void main(String[] args) {
        PokemonTeam team1 = new PokemonTeam();
        team1.displayMenu();
    }
}