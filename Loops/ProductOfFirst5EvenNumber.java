package Loops;

public class ProductOfFirst5EvenNumber {
    public static void main(String[] args) {
        int product = 1;
        for(int i = 1; i<=10;i++){
            if(i/2*2==i){
                product*=i;
            }
        }
        System.out.println(product);
    }
}
