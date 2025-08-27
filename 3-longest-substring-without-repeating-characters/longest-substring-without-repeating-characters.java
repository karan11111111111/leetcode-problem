// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;

       
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 if (allUnique(s, i, j)) {
//                     maxLength = Math.max(maxLength, j - i + 1);
//                 }
//             }
//         }

//         return maxLength;
//     }

//     private boolean allUnique(String s, int start, int end) {
//         HashSet<Character> set = new HashSet<>();
//         for (int k = start; k <= end; k++) {
//             char c = s.charAt(k);
//             if (set.contains(c)) {
//                 return false; 
//             }
//             set.add(c);
//         }
//         return true;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);

            
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
