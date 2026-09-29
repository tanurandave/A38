public class WordLength {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        printWordLength(text);
    }

    public static void printWordLength(String text) {
        text = text + " ";
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                count++;
            } else {
                System.out.println(count);
                count = 0;
            }
        }
    }
}
