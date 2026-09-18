
// 17)WAP to count only special character in a given String

public class SpecialCharCount {
    public static void main(String[] args) {
        String s = "Java@123";
        
        System.out.println(countSpecialCharacters(s));
    }

    public static int countSpecialCharacters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(Character.isLetter(ch) || Character.isDigit(ch))) {
                count++;
            }
        }
        return count;
    }
}
