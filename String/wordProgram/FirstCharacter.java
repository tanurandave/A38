public class FirstCharacter {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        printFirstCharacter(text);
    }

    public static void printFirstCharacter(String text) {
        text = " " + text + " ";

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != ' ' && text.charAt(i - 1) == ' ') {
                System.out.println(text.charAt(i));
            }
        }
    }
}
