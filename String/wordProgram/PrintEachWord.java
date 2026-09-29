public class PrintEachWord {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        printEachWord(text);
    }

    public static void printEachWord(String text) {
        text = text + " ";
        char[] ch = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            if (ch[i] != ' ') {
                System.out.print(ch[i]);
            } else {
                System.out.println();
            }
        }
    }
}
