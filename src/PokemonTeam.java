import java.util.Scanner;

public class PokemonTeam {
    // Properties
    private Pokemon[] teamMembers;
    // Getters/Setters
    public Pokemon[] TeamMembers() { return teamMembers; }
    // Constructors
    public PokemonTeam() {
        teamMembers = new Pokemon[6];
    }
    // Methods
    public void displayPokemon() {
        System.out.println("Your team currently consists of: ");
        for (Pokemon slot : teamMembers) {
            if (slot != null) { System.out.println("\t#" + slot.Number() + " - " + slot.Name()); }
        }
    }
    public void addPokemon() {
        boolean addPoke = true;
        do {
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read input
            System.out.print("Which pokemon would you like to add to your team? (Number or name) ");
            String input = scanner.nextLine();
            teamMembers[0] = new Pokemon(input);

            if (teamMembers.length < 5) {
                System.out.print("Add another Pokemon? Y/N");
                if (scanner.nextLine() == "N") { addPoke = false; }
            }
        }
        while (teamMembers.length < 6 && addPoke);
    }
}
