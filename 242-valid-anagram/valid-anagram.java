// class Solution {
//     public boolean isAnagram(String s, String t) {

//         if (s.length() != t.length()) {
//             return false;
//         }

//         int n = s.length() ;
//         char[] sarr = s.toCharArray();
//         char[] tarr = t.toCharArray();

//         Arrays.sort(tarr);
//         Arrays.sort(sarr);
//         for (int k=0; k < n; k++) {
//             if (sarr[k]!=tarr[k]) {
//                 return false;
//             }
//         }

//         return true;

//     }
// }


import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Count frequency for s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease frequency using t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                return false; // character not found in s
            }
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }
}
