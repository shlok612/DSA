class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        if(strs.length==1){
            return strs[0];
        }
        Arrays.sort(strs);
        String a=strs[0];
        String b=strs[strs.length-1];
        int k=0;
        while(k<a.length()){
            if(a.charAt(k)!=b.charAt(k)){
                return sb.toString();
            }
            sb.append(a.charAt(k));
            k++;
        }
        return sb.toString();
    }
}