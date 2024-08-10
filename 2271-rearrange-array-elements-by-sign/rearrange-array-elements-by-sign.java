class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] A = new int[nums.length];
        int[] B = new int[nums.length];
        
        int aIndex = 0;
        int bIndex = 0;

        // Separate positive and negative numbers into arrays A and B
        for (int num : nums) {
            if (num > 0) {
                A[aIndex++] = num;
            } else {
                B[bIndex++] = num;
            }
        }

        // Place numbers from arrays A and B alternately into nums
        int pIndex = 0;
        int nIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = A[pIndex++];
            } else {
                nums[i] = B[nIndex++];
            }
        }

        return nums;
    }
}
