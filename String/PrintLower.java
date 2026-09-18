// 4)WAP to print only lowercase character in a given String

public class PrintLower {
    public static void main(String[] args) {
        String s = new String("Hello");
        printLowerChar(s);
    }
    public static void printLowerChar(String s){
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a'&&ch<='z'){
                System.out.println(ch);
            }
        }
    }
}
