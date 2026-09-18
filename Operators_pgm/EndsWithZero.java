package Operators_pgm;

public class EndsWithZero {
    public static void main(String[] args) {
        int num = 10;
        String res = (num %10==0)?"Yes":"NO";
        System.out.println(res);
    }
}
