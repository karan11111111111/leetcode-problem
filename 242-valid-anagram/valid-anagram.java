class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length() ;
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        Arrays.sort(tarr);
        Arrays.sort(sarr);
        for (int k=0; k < n; k++) {
            if (sarr[k]!=tarr[k]) {
                return false;
            }
        }

        return true;

    }
}