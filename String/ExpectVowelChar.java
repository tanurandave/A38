
// 22)WAP to print Except vowels in a given String

public class ExpectVowelChar {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printExceptVowelChar(s);
    }
    public static void printExceptVowelChar(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(!(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')){
                System.out.print(ch+" ");
            }
        }
    }
    
}
