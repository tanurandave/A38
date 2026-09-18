package Operators_pgm;

public class TwoNumLastDigitIsSame {
    public static void main(String[] args) {
        int num1 = 10;
        int num2=20;
        boolean res = (num1%10==num2%10)?true:false;
        System.out.println(res);
    }
}
