// Print each world line by line
public class PrintEachWorld {
    public static void main(String[] args) {
        String text = "Hello World! Welcome to the world of Java programming.";
       printEachWord(text);
    }
    public static void printEachWord(String text) {
        text = text + " "; // Add a space at the end to ensure the last word is printed
        char ch[] = text.toCharArray();
        
        for (int i = 0; i < text.length(); i++) {
            if (ch[i] != ' ') {
                System.out.print(ch[i]);
            } else {
            System.out.println();
        }
    }
}
}