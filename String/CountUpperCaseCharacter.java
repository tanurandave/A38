// 11)WAP to count only upper case character in  a given String
public class CountUpperCaseCharacter {
    public static void main(String[] args) {
        String s = new String("Java is Easy");
        CountUpperCaseCharacter cu = new CountUpperCaseCharacter();
        int res = cu.countUpperCase(s);
        System.out.println(res);
    }
    public int countUpperCase(String s){
        int count =0;
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch>='A'&& ch<='Z'){
                count++;
            }
        }
        return count;
    }
}