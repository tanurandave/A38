// 2)WAP to print every character line by line

public class PrintChar2 {
    public static void main(String[] args) {
        String s = new String("java");
        printChar1(s);
    }
    private static void printChar1(String s) {
      for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
       
        System.out.println("ch: "+ ch);
      }
    }

}
