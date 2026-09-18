
//7)WAP to print only consonants in a given String
public class Demo7 {
    public static void main(String[] args) {
        String s = new String("Java is easy");
        printConsonants(s);
    }
    public static void printConsonants(String s){
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'&&ch!=' '){
                System.out.print(ch+" ");
            }
        }
    }
}
