// class Solution {
//     public void sortColors(int[] nums) {
//         // Arrays.sort(nums);

//     int n = nums.length;

//     for(int i=0; i<n; i++){
//         for(int j=0; j<n-i-1; j++){
//            if(nums[j]>nums[j+1]){
//             int temp = nums[j];
//             nums[j] = nums[j+1];
//             nums[j+1] = temp;
//            }
//         }
//     }

//     }
// }

class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);  // Recursively sort elements before pivot
            quickSort(nums, pivotIndex + 1, high); // Recursively sort elements after pivot
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; // Choosing the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high); // Place the pivot in its correct position
        return i + 1; // Return the pivot index
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
