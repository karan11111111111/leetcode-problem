class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than high element, the min is in the right part
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // If mid element is less than or equal to high, the min is in the left part including mid
            else {
                high = mid;
            }
        }

        // After the loop, low will be the index of the smallest element
        return nums[low];
    }
}