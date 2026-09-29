public class CountWords {
    public static void main(String[] args) {
        String text = "Hello World Welcome to Java";
        System.out.println(countWords(text));
    }

    public static int countWords(String text) {
        text = text + " ";
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }

        return count;
    }
}
