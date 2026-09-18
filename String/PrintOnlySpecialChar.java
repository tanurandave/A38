
// 33)WAP to print only special character index in a given String

public class PrintOnlySpecialChar {
    public static void main(String[] args) {
        String s = new String("Java@is#Easy$");
        printOnlySpecialCharIndex(s);
    }
    public static void printOnlySpecialCharIndex(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(!(ch>='a'&& ch<='z') && !(ch>='A'&& ch<='Z') && !(ch>='0'&& ch<='9')){
                System.out.println("ch: "+ ch+" index: "+i);
            }
        }
    }
}
