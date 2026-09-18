// 12)WAP to count only lowercase character in a given String

public class CountLowerCaseCharacter {
    public static void main(String[] args) {
        String s = "Java is Easy";
        CountLowerCaseCharacter clc = new CountLowerCaseCharacter();
        int res = clc.countLowerCase(s);
        System.out.println(res);
    }

    public int countLowerCase(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count++;
            }
        }
        return count;
    }
}
