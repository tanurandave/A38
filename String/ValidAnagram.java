class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int [] isPresent = new int [26];
        for(int i =0; i< s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            isPresent[ch1-'a']++;
            isPresent[ch2-'a']--;
        }
        for(int i =0; i<isPresent.length;i++){
            if(isPresent[i]!=0){
                return false;
            }

        }
        return true;
    }
}