class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentchildren =0;
        int cookieIndex=0;
        

       while (cookieIndex < s.length && contentchildren <g.length){
        if(s[cookieIndex]>= g[contentchildren]){
            contentchildren++;
        }
        cookieIndex++;
       }

        return contentchildren++;
    }
}