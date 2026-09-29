public class ReverseEachWord {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        reverseEachWord(text);
    }

    public static void reverseEachWord(String text) {
        String word = "";
        text = text + " ";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                for (int j = word.length() - 1; j >= 0; j--) {
                    System.out.print(word.charAt(j));
                }

                System.out.print(" ");
                word = "";
            }
        }
    }
}
