
// 39)WAP to print ASCII value of only Alphabets in a given String

public class ASCIIValueAlphabets {
    public static void main(String[] args) {
        String s = new String("java");
        printASCIIValueAlphabets(s);
    }
    public static void printASCIIValueAlphabets(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if((ch>='a'&& ch<='z') || (ch>='A'&& ch<='Z')){
                int ascii = (int)ch;
                System.out.println("ch: "+ ch+" ASCII value: "+ascii);
            }
        }
    }
}
