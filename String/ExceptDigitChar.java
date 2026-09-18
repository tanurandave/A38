
// 21)WAP to print Except Digits character in a given String
public class ExceptDigitChar {
    public static void main(String[] args) {
        String s = new String("e12as3y5");
        printExceptDigitChar(s);
    }
    public static void printExceptDigitChar(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(!(ch>='0'&& ch<='9')){
                System.out.print(ch+" ");
            }
        }
    }
}