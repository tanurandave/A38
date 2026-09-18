package Operators_pgm;
public class Swap {
    public static void main(String[] args) {
        int a = 80;
        int b = 120;
         System.out.println("a: "+ a);
         System.out.println("b: "+ b);
         a = a+b;
         b = a-b;
         a = a-b;
         System.out.println("a: "+ a);
         System.out.println("b: "+ b);
    }
}
