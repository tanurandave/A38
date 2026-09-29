public class SmallestWord {
    public static void main(String[] args) {
        String text = "Java is a programming language";
        System.out.println(findSmallest(text));
    }

    public static String findSmallest(String text) {
        String word = "";
        String smallest = null;

        text = text + " ";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                if (smallest == null || word.length() < smallest.length()) {
                    smallest = word;
                }
                word = "";
            }
        }

        return smallest;
    }
}
