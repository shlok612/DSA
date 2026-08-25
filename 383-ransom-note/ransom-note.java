class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> mag=new HashMap<>();

        
        for(char ch:magazine.toCharArray()){
            mag.put(ch, mag.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            if(mag.getOrDefault(c,0)==0){
                return false;
            }
            mag.put(c,mag.get(c)-1);
        }
        return true;
    }
}