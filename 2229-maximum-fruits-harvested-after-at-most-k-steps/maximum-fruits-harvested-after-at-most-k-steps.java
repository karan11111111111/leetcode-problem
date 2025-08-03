class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0;
        int n = fruits.length;
        
     
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += fruits[right][1];

        
            while (left <= right && minSteps(fruits, left, right, startPos) > k) {
                sum -= fruits[left][1];
                left++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }


    private int minSteps(int[][] fruits, int i, int j, int startPos) {
        int leftPos = fruits[i][0];
        int rightPos = fruits[j][0];
        

        int leftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);

        int rightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        
        return Math.min(leftFirst, rightFirst);
    }
}
