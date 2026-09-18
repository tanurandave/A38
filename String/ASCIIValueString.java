
// 35)WAP to print ASCII value of every character in a given String
public class ASCIIValueString {
    public static void main(String[] args) {
        String s = new String("java");
        printASCIIValue(s);
    }
    public static void printASCIIValue(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            int ascii = (int)ch;
            System.out.println("ch: "+ ch+" ASCII value: "+ascii);
        }
    }
    
}

