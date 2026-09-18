package Operators_pgm;

public class CenturyYear {
    public static void main(String[] args) {
        int year = 2024;

        if(year%100==0){
            System.out.println(year + " century year");
        }
        else{
            System.out.println(year+" Not a Century Year");
        }
    }
}
