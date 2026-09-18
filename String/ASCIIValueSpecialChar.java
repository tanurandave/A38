
// 40)WAP to print ASCII value of only special character in a given String
public class ASCIIValueSpecialChar {
    public static void main(String[] args) {
        String s = new String("java@#123");
        ASCIIValueSpecialChar obj = new ASCIIValueSpecialChar();
       int resobj.printASCIIValueSpecialChar(s);
    }
    public  void printASCIIValueSpecialChar(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(!(ch>='a'&&ch<='z')&&!(ch>='A'&&ch<='Z')&&!(ch>='0'&&ch<='9')&&ch!=' '){
                int ascii = (int)ch;
                System.out.println("ch: "+ ch+" ASCII value: "+ascii);
            }
        }
    }
}