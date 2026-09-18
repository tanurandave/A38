
// 36)WAP to print ASCII value of only vowels in a given String
public class ASCIIValueVowels {
    public static void main(String[] args) {
        String s = new String("java");
        printASCIIValueVowels(s);
    }
    public static void printASCIIValueVowels(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                int ascii = (int)ch;
                System.out.println("ch: "+ ch+" ASCII value: "+ascii);
            }
        }
    }
}
