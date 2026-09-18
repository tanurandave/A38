package Operators_pgm;

public class EvenOrDivisibleBy5 {
    public static void main(String[] args) {
        int num = 18;
        String res = ((num%2==0)||(num%5==0))?"YES":"NO";
        System.out.println(res);
    }
}
