
// 28)WAP to print only lowercase character index in a given String
public class LowerCaseCharIndex {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printLowerCaseCharIndex(s);
    }
    public static void printLowerCaseCharIndex(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch>='a'&& ch<='z'){
                System.out.println("ch: "+ ch+" index: "+i);
            }
        }
    }
}
