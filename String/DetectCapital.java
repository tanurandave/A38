public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int upper =0;
        for(int i =0; i< word.length();i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                upper++;
            }
        }
        if(upper == word.length()){
            return true;
        }
        if(upper == 0){
            return true; 
        }
        if(upper ==1 && (word.charAt(0)>='A'&&word.charAt(0)<='Z')){
            return true;
        }
        return false;
    }
}