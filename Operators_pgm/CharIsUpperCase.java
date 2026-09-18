package Operators_pgm;

public class CharIsUpperCase {
    public static void main(String[] args) {
        char ch = 'a';
        String res = ch>='A'&&ch<'Z' ? "UPPER CASE": "NOT UPPER CASE";
        System.out.println(res);
    }
}
