

// 27)WAP to print only upper case character index in given String
public class UpperCaseCharIndex {
    
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printUpperCaseCharIndex(s);
    }
    private static void printUpperCaseCharIndex(String s) {
      for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch>='A'&& ch<='Z'){
            System.out.println("ch: "+ ch+" index: "+i);
        }
      }
    }
}
