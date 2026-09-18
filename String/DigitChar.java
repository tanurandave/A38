// 5)WAP to print only Digits character in a given String
//   Input:- e12as3y5
// Output:- 1 2 3 5   

public class DigitChar {
    public static void main(String[] args) {
        String s = new String("e12as3y5");
        printDigitChar(s);
    }
    public static void printDigitChar(String s){
        for(int i = 0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch>='0'&& ch<='9'){
                System.out.print(ch+" ");
            }
        }
    }
}
