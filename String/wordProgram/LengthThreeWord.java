public class LengthThreeWord {
    public static void main(String[] args) {
        String text = "Java is one of the best";
        printLengthThreeWord(text);
    }

    public static void printLengthThreeWord(String text) {
        String word = "";
        text = text + " ";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                if (word.length() == 3) {
                    System.out.println(word);
                }
                word = "";
            }
        }
    }
}
