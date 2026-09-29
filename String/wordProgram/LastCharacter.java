public class LastCharacter {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        printLastCharacter(text);
    }

    public static void printLastCharacter(String text) {
        text = text + " ";

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != ' ' && text.charAt(i + 1) == ' ') {
                System.out.println(text.charAt(i));
            }
        }
    }
}
