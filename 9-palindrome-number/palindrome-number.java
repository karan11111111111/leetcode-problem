class Solution {
    public boolean isPalindrome(int x) {

        int m =0;
        int o =x;

        while(x > 0){
            int r = x%10;
            x=x/10;
            m = m*10 +r;

        }

        if(o != m){
            return false;
        }

        return true;
    }
}