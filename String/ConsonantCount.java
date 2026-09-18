
// 15)WAP to count only consonants in a given String
public class ConsonantCount {
    public static void main(String[] args) {
        String s = "Java is Easy";
        ConsonantCount cc = new ConsonantCount();
        int res = cc.countConsonants(s);
        System.out.println(res);
    }

    public int countConsonants(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
                    ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') {
                    count++;
                }
            }
        }
        return count;
    }
}
