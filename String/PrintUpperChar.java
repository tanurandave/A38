// 3)WAP to print only upper case character in given String


public class PrintUpperChar {
    public static void main(String[] args) {
        String s = new String("JaVa");
        printUpperChar(s);
    }
    public static void printUpperChar(String s){
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='A'&&ch<='Z'){
                System.out.println(ch);
            }
        }
    }
}
