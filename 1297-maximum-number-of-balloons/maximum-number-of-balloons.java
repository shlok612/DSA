class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] balloon={'b','a','l','l','o','o','n'};
        HashMap<Character, Integer> txt=new HashMap<>();
        for(char ch:text.toCharArray()){
            txt.put(ch,txt.getOrDefault(ch,0)+1);
        }
        int ans=0;
        boolean pos=possible(txt,balloon);
        while(pos){
            ans++;
            pos=possible(txt,balloon);
        }
        return ans;
    }
    public boolean possible(HashMap<Character,Integer> text, char[] arr ){
        boolean flag=true;
        for(char ch:arr){
            if(text.containsKey(ch) && text.get(ch)!=0){
                text.put(ch,text.get(ch)-1);
            }
            else{
                flag=false;
            }
        }
        return flag;

    }
}