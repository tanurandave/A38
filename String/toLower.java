class Solution {
    public String toLowerCase(String s) {
        char[] originalData= s.toCharArray();
        char[] modifiedData= new char[originalData.length];
        for(int i =0; i<originalData.length; i++){
            if(originalData[i]>='A'&&originalData[i]<='Z'){
                modifiedData[i]= (char)(originalData[i]+32);
            }
            else{
                modifiedData[i]= originalData[i];
            }
        }
        return new String(modifiedData);
    }
}