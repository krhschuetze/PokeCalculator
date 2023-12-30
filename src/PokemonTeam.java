import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonTeam {
    // Properties
    private List<Pokemon> teamMembers; // Create ArrayList to store Pokemon
    // Getters/Setters
    public List<Pokemon> TeamMembers() { return teamMembers; }
    // Constructors
    public PokemonTeam() {
        teamMembers = new ArrayList<Pokemon>(){};;
    }
    // Methods
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read input
        System.out.println("Menu:" +
                "\n\t1. Display current Pokemon" +
                "\n\t2. Add new Pokemon" +
                "\n\t3. Remove existing Pokemon" +
                "\n\t4. Display type chart" +
                "\n\t5. Exit"
        );
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                displayPokemon();
                break;
            }
            case 2: {
                addPokemon();
                break;
            }
            case 3: { break; }
            case 4: { break; }
            case 5: { break; }
        }
    }
    public void displayPokemon() {
        System.out.println("Your team currently consists of: ");
        for (Pokemon slot : teamMembers) {
            if (slot.Name() != null) { System.out.println("\t#" + slot.Number() + " - " + slot.Name()); }
        }
    }
    public void addPokemon() {
        if (teamMembers.size() > 5) {
           System.out.println("You already have the maximum number of Pokemon on your team.");
           return;
        }
        boolean addPoke = true;
        do {
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read input
            System.out.print("Which pokemon would you like to add to your team? (Number or name) ");
            String input = scanner.nextLine();
            teamMembers.add(new Pokemon(input));
            if (teamMembers.size() < 6) {
                System.out.print("Add another Pokemon? (Y/N) ");
                if (scanner.nextLine().equals("N")) {
                    addPoke = false;
                }
            }
            else { addPoke = false; } // If the list size hits 6, quit
        }
        while (addPoke);
        displayPokemon();
    }
}
