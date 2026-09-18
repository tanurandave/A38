
// 18)WAP to iterate String from last to first and print 
public class StringIterator {
    public static void main(String[] args) {
        String s = new String("Java is easy");
        printString(s);
    }
    public static void printString(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
