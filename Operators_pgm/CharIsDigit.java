package Operators_pgm;

public class CharIsDigit {
    public static void main(String[] args) {
        char ch ='9';
        String res = (ch>='0'&&ch<='9')?"Digit":"Not a Digit";
        System.out.println(res);
    }
}
