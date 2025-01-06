class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Calculate the left products
        answer[0] = 1; // There is no element to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate the right products and multiply with the left products
        int rightProduct = 1; // Initially, there is no element to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct; // Multiply with the right product
            rightProduct *= nums[i]; // Update the right product
        }

        return answer;
    }
}
