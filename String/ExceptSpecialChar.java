
// 25)WAP to print Except special character in a given String
public class ExceptSpecialChar {
    public static void main(String[] args) {
        String s = new String("Java@# is easy$%");
        printExceptSpecialChar(s);
    }
    public static void printExceptSpecialChar(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if((ch>='a'&& ch<='z')||(ch>='A'&& ch<='Z')||(ch>='0'&& ch<='9')||ch==' '){
                System.out.print(ch+" ");
            }
        }
    }
    
}
