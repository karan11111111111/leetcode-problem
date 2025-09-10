class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start =0;
        int half =s.length()-1;

        while(start < half){

            if(s.charAt(start) != s.charAt(half)){
                return false;
            }

            start++;
            half--;
        }

        return true;
        
    }
}