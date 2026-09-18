
// 20)WAP to print Except lowercase character in a given String
public class ExceptLowerCaseChar {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printExceptLowerCaseChar(s);
    }
    public static void printExceptLowerCaseChar(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(!(ch>='a'&& ch<='z')){
                System.out.print(ch+" ");
            }
        }
    }
}
