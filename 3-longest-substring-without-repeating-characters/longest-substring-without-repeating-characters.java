class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength =0;
        int start =0;

        Set<Character> set = new HashSet<>();

        for(int end =0; end <n; end++){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
        set.add(s.charAt(end));
        maxLength = Math.max(maxLength, end-start +1);
        }

    return maxLength;
    }
}