
// 9)WAP to print only special character in a given String

public class Demo9 {
    public static void main(String[] args) {
        String s = new String("Java@# is easy$%");
        printSpecialChar(s);
    }
    public static void printSpecialChar(String s){
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!(ch>='a'&&ch<='z')&&!(ch>='A'&&ch<='Z')&&!(ch>='0'&&ch<='9')&&ch!=' '){
                System.out.print(ch+" ");
            }
        }
    }
}
