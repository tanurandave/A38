package Operators_pgm;

public class CharIsLowerCase {
    public static void main(String[] args) {
        char ch = 'a';
        String res = ch>='a'&&ch<='z'?"LOWER CASE":"NOT A LOWER CASE";
        System.out.println(res);
    }
}
