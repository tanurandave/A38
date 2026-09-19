public class StringPalindrom{
    public static void main(String[] args){
        String [] words = {"abc", "aba", "abccba", "abcba", "abca", "A man","madam"};
        for(int i = 0; i < words.length; i++){
           if(checkPalindrom(words[i])){
            System.out.println(words[i] + " is a palindrome");
           }

        }
         System.out.println("not palindrome");   
    }

    public static boolean checkPalindrom(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}