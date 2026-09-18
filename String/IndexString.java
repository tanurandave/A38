
// 26)WAP to print every character index  line by line
public class IndexString {
    
    public static void main(String[] args) {
        String s = new String("java");
        printCharIndex(s);
    }
    private static void printCharIndex(String s) {
      for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
       
        System.out.println("ch: "+ ch+" index: "+i);
      }
    }
}
