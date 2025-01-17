// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if (s.length() != t.length()) return false;

    
//         int[] mapST = new int[256];
//         int[] mapTS = new int[256];

    
//         for (int i = 0; i < s.length(); i++) {
//             char charS = s.charAt(i);
//             char charT = t.charAt(i);

           
//             if (mapST[charS] == 0 && mapTS[charT] == 0) {
               
//                 mapST[charS] = charT;
//                 mapTS[charT] = charS;
//             } else if (mapST[charS] != charT || mapTS[charT] != charS) {
//                 return false; 
//             }
//         }

//         return true;
//     }
// }

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

     
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

           
            if (sMap.containsKey(charS)) {
                if (sMap.get(charS) != charT) {
                    return false; 
                }
            } else {
                sMap.put(charS, charT);
            }

            
            if (tMap.containsKey(charT)) {
                if (tMap.get(charT) != charS) {
                    return false;  
                }
            } else {
                tMap.put(charT, charS);
            }
        }

       
        return true;
    }
}
