
// 37)WAP to print ASCII value of only consonants in a given String 
public class ASCIIValueConsonant {
    public static void main(String[] args) {
        String s = new String("java");
        printASCIIValueConsonant(s);
    }
    public static void printASCIIValueConsonant(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'&&ch!=' '){
                int ascii = (int)ch;
                System.out.println("ch: "+ ch+" ASCII value: "+ascii);
            }
        }
    }
}
