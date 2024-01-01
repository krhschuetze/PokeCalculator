import java.util.List;

public class TitleCase {
    public static String toTitleCase(String lowercase) {
        return lowercase.substring(0,1).toUpperCase() + lowercase.substring(1);
    }
    public static String toTitleCase(List<String> lowercaseList) {
        String titleStringList = "";
        for (String item : lowercaseList) {
            String temp = toTitleCase(item);
            titleStringList += (temp + " ");
        }
        return titleStringList;
    }
}
