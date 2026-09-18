
// 23)WAP to print Except consonants in a given String
public class EXceptConsonant {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printExceptConsonant(s);
    }
    public static void printExceptConsonant(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch==' '){
                System.out.print(ch+" ");
            }
        }
    }
}
