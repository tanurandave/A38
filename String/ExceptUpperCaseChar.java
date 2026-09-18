
// 19)WAP to print except upper case character in given String
public class ExceptUpperCaseChar {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printExceptUpperCaseChar(s);
    }
    public static void printExceptUpperCaseChar(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(!(ch>='A'&& ch<='Z')){
                System.out.print(ch+" ");
            }
        }
    }
    
}
