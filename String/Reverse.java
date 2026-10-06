public class Reverse {
    public static void main(String[] args) {
        String input = "  Hello   World  ";
        String reversed = reverseWords(input);
        System.out.println(reversed); // Output: "World Hello"
    }
    public static String reverseWords(String s) {
         String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    
}