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
        int choice = 0;
        do {
            System.out.println("Menu:" +
                    "\n\t1. Display current Pokemon" +
                    "\n\t2. Add new Pokemon" +
                    "\n\t3. Remove existing Pokemon" +
                    "\n\t4. Display advantages/disadvantages" +
                    "\n\t5. Exit"
            );
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    displayPokemon();
                    break;
                }
                case 2: {
                    addPokemon();
                    break;
                }
                case 3: {
                    removePokemon();
                    break;
                }
                case 4: {
                    printTeamTypes();
                    break;
                }
                case 5: {
                    System.out.println("Goodbye.");
                    break;
                }
                default: {
                    System.out.println("Please enter a number 1-5.");
                    break;
                }
            }
        } while (choice != 5);
    }
    public void displayPokemon() {
        if (!teamMembers.isEmpty()) {
            System.out.println("Your team currently consists of: ");
            for (Pokemon slot : teamMembers) {
                System.out.println("\t#" + slot.Number() + " - " + slot.Name() + " " + slot.TypeList().toString());
            }
        }
        else {
            System.out.println("You don't have any Pokemon on your team.");
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
            teamMembers.add(new Pokemon(input, true));
            if (teamMembers.size() < 6) {
                System.out.print("Add another Pokemon? (Y/N) ");
                if (scanner.nextLine().equalsIgnoreCase("n")) {
                    addPoke = false;
                }
            }
            else { addPoke = false; } // If the list size hits 6, quit
        }
        while (addPoke);
        displayPokemon();
    }
    public void removePokemon() {
        if (teamMembers.size() == 0) {
            System.out.println("You don't have any Pokemon on your team.");
            return;
        }
        boolean removePoke = true;
        do {
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read input
            System.out.print("Which pokemon would you like to remove from your team? (Number or name) ");
            String input = scanner.nextLine();
            teamMembers.removeIf(slot -> slot.compare(slot, new Pokemon(input, false)) == 0); // Remove if Pokemon are same
            if (!teamMembers.isEmpty()) {
                System.out.print("Remove another Pokemon? (Y/N) ");
                if (scanner.nextLine().equalsIgnoreCase("n")) {
                    removePoke = false;
                }
            }
            else { removePoke = false; } // If the list size hits 0, quit
        }
        while (removePoke);
        displayPokemon();
    }
    public void printTeamTypes() {
        List<String> teamTypes = new ArrayList<String>(){};
        for (Pokemon slot : teamMembers) { // Iterate through full team
            teamTypes.addAll(slot.TypeList()); // Add all types from each Pokemon
        }
        System.out.println(TitleCase.toTitleCase(teamTypes));
        return;
    }
}
