package Operators_pgm;
import java.util.Scanner;
public class AlphabetCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Character: ");
        char ch = sc.next().charAt(0);
        String res = (ch>=65&&ch<=90||ch>=97&&ch<=122)?"Alphabet":"Not A Alphabet";
        System.out.println(res);
    }
}
