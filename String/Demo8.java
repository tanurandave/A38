
// 8)WAP to print only Alphabets in a given String
public class Demo8 {
    public static void main(String[] args) {
        String s = new String("Java80 is 9easy");
        printAlphabets(s);
    }
    public static void printAlphabets(String s){
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                System.out.print(ch+" ");
            }
        }
    }
}
