// 10)WAP to count only spaces in a given String


public class SpaceCountDemo{
    public static void main(String[] args){
        String s = " t h is is java";
        SpaceCountDemo scd= new SpaceCountDemo();
        int res = scd.spaceCount(s);
        System.out.println(res);
    }
    public  int spaceCount(String s){
        int count =0;
        for(int i =0; i<s.length();i++){
            char ch= s.charAt(i);
            if(ch == ' '){
                count++;
            }
        }
        return count;
    }
}