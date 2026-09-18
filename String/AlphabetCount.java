
// 16)WAP to count only Alphabets in a given String
public class AlphabetCount {
    public static void main(String[] args) {
        String s = new String("Java80 is 9easy");
        AlphabetCount ac = new AlphabetCount();
        int res = ac.countAlphabets(s);
        System.out.println(res);
    }
    public int countAlphabets(String s){
        int count =0;
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
                count++;
            }
        }
        return count;
    }
}
