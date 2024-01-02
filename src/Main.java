public class Main {
    public static void main(String[] args) {
        System.out.print("Loading type     ");
        // Get all types
        Type[] typesArray = new Type[18];
        for (int i = 0; i < typesArray.length; i++) {
            int typeToGet = i + 1;
            typesArray[i] = new Type(String.valueOf(i + 1));
            if (i < 10) {
                System.out.print("\b\b\b\b" + typeToGet + "/18");
            }
            else { System.out.print("\b\b\b\b\b" + typeToGet + "/18"); }
        }
        System.out.println();

        PokemonTeam team1 = new PokemonTeam();
        team1.displayMenu();
    }
}