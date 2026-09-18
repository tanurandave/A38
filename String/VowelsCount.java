
// 14)WAP to count only vowels in a given String
public class VowelsCount {
    public static void main(String[] args) {
        String s = new String("Java is easy");
        VowelsCount vc = new VowelsCount();
        int res = vc.countVowels(s);
        System.out.println(res);
    }
    public int countVowels(String s){
        int count =0;
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        return count;
    }
    
}
