import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            
            if (!map.containsKey(digitSum)) {
                map.put(digitSum, new int[]{num, -1});
            } else {
                int first = map.get(digitSum)[0];
                int second = map.get(digitSum)[1];

                // Update first and second largest numbers
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num > second) {
                    second = num;
                }
                
                map.put(digitSum, new int[]{first, second});

                // If a second largest exists, update maxSum
                if (second != -1) {
                    maxSum = Math.max(maxSum, first + second);
                }
            }
        }
        return maxSum;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
