
// 30)WAP to print only vowels index in a given String

public class VowelCharIndex {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printVowelCharIndex(s);
    }
    public static void printVowelCharIndex(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                System.out.println("ch: "+ ch+" index: "+i);
            }
        }
    }
    
}
