
// 32)WAP to print only Alphabets index in a given String
public class PrintOnlyAlphabetCharIndex {
    public static void main(String[] args) {
        String s = new String("Java80 is 9easy");
        printOnlyAlphabetCharIndex(s);
    }
    public static void printOnlyAlphabetCharIndex(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if((ch>='a'&& ch<='z') || (ch>='A'&& ch<='Z')){
                System.out.println("ch: "+ ch+" index: "+i);
            }
        }
    }
}
