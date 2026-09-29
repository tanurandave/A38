import java.util.Arrays;

public class AscendingCharacters {
    public static void main(String[] args) {
        String text = "java";
        char[] ch = text.toCharArray();

        Arrays.sort(ch);

        System.out.println(new String(ch));
    }
}
