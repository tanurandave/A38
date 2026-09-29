import java.util.Arrays;

public class DescendingCharacters {
    public static void main(String[] args) {
        String text = "java";
        char[] ch = text.toCharArray();

        Arrays.sort(ch);

        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
}
