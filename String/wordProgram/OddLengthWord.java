public class OddLengthWord {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        printOddLengthWord(text);
    }

    public static void printOddLengthWord(String text) {
        String word = "";
        text = text + " ";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                if (word.length() % 2 != 0) {
                    System.out.println(word);
                }
                word = "";
            }
        }
    }
}
