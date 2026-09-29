public class LongestWord {
    public static void main(String[] args) {
        String text = "Java programming language";
        System.out.println(findLongest(text));
    }

    public static String findLongest(String text) {
        String word = "";
        String longest = "";

        text = text + " ";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                if (word.length() > longest.length()) {
                    longest = word;
                }
                word = "";
            }
        }

        return longest;
    }
}
