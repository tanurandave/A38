
// 31)WAP to print only consonants index in a given String
public class ConsonantCharIndex {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        printConsonantCharIndex(s);
    }
    public static void printConsonantCharIndex(String s){
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if((ch>='a'&& ch<='z')||(ch>='A'&& ch<='Z')){
                if(ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'&&ch!='A'&&ch!='E'&&ch!='I'&&ch!='O'&&ch!='U'){
                    System.out.println("ch: "+ ch+" index: "+i);
                }
            }
        }
    }
}

