public class Pangram {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";

        text = text.toLowerCase();

        boolean[] alphabet = new boolean[26];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                alphabet[ch - 'a'] = true;
            }
        }

        boolean pangram = true;

        for (int i = 0; i < alphabet.length; i++) {
            if (!alphabet[i]) {
                pangram = false;
                break;
            }
        }

        if (pangram) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }
}
