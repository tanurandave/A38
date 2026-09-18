
// 38)WAP to print ASCII value of only Digits in a given String
public class ASCIIDigit {
    public static void main(String[] args) {
        String s = new String("java123");
        printASCIIDigit(s);
    }
    public static void printASCIIDigit(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch>='0'&& ch<='9'){
                int ascii = (int)ch;
                System.out.println("ch: "+ ch+" ASCII value: "+ascii);
            }
        }
    }
    
}
