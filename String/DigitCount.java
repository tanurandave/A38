
// 13)WAP to count only Digits character in a given String
public class DigitCount {
    public static void main(String[] args) {
        String s = new String("e12as3y5");
        DigitCount dc = new DigitCount();
        int res = dc.countDigit(s);
        System.out.println(res);
    }
    public int countDigit(String s){
        int count =0;
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch>='0'&& ch<='9'){
                count++;
            }
        }
        return count;
    }
    
}
