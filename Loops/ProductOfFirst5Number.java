package Loops;

public class ProductOfFirst5Number {
    public static void main(String[] args) {
        int product = 1;
        for(int i = 1; i<=5;i++){
            product*=i;
        }
        System.out.println(product);
    }
}
