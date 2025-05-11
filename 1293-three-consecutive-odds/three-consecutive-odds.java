class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        for (int i = 0; i + 2 < arr.length; i++) {
            // bitwise check for odd: x & 1 == 1
            if ((arr[i] & 1) == 1 &&
                (arr[i + 1] & 1) == 1 &&
                (arr[i + 2] & 1) == 1) {
                return true;
            }
        }
        return false;
    }
}
