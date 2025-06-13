// class Solution {
//     public int reversePairs(int[] nums) {
//         int count = 0;
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = i + 1; j < nums.length; j++) {
//                 if(nums[i] > 2L * nums[j]) { // Use 2L to avoid overflow
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }


class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) j++;
            count += j - (mid + 1);
        }

        merge(nums, left, mid, right);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp.add(nums[i++]);
            else temp.add(nums[j++]);
        }

        while (i <= mid) temp.add(nums[i++]);
        while (j <= right) temp.add(nums[j++]);

        for (int k = left; k <= right; k++) {
            nums[k] = temp.get(k - left);
        }
    }
}
