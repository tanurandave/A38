package Operators_pgm;

public class IsLeapYear {
    public static void main(String[] args) {
        int year = 2020;
        if((year %4==0 && year % 100!=0)|| year %400==0){
            System.out.println(year+ " Leap Year");
        }
        else{
            System.out.println(year+ "Not a Leap Year");
        }
    }
}
