
// 29)WAP to print only Digits character  index in a given String
public class DigitCharIndex {
    public static void main(String[] args) {
        String s = new String("e12as3y5");
        printDigitCharIndex(s);
    }
    public static void printDigitCharIndex(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch>='0'&& ch<='9'){
                System.out.println("ch: "+ ch+" index: "+i);
            }
        }
    }
    
}
