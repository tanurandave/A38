//  6)WAP to print only vowels in a given String
public class VowelsDemo {
    public static void main(String[] args) {
        String s = new String("Java is easy");
        printVowels(s);
    }
    public static void printVowels(String s){
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                System.out.println(ch);
            }
        }
    }
}
