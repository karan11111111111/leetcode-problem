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

// class Solution {
//     public void sortColors(int[] nums) {
//         quickSort(nums, 0, nums.length - 1);
//     }

//     private void quickSort(int[] nums, int low, int high) {
//         if (low < high) {
//             int pivotIndex = partition(nums, low, high);
//             quickSort(nums, low, pivotIndex - 1);  
//             quickSort(nums, pivotIndex + 1, high); 
//         }
//     }

//     private int partition(int[] nums, int low, int high) {
//         int pivot = nums[high];
//         int i = low - 1;

//         for (int j = low; j < high; j++) {
//             if (nums[j] <= pivot) {
//                 i++;
//                 swap(nums, i, j);
//             }
//         }

//         swap(nums, i + 1, high); 
//         return i + 1; 
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }

class Solution {
    public void sortColors(int[] nums) {
        int count_0 = 0 , count_1 = 0 , count_2 = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == 0)
            count_0++;
            if(nums[i] == 1)
            count_1++;
            if(nums[i] == 2)
            count_2++;
        }
        for(int i = 0 ; i<count_0 ; i++)
        nums[i] = 0;
         for(int i = count_0 ; i<(count_0+count_1) ; i++)
        nums[i] = 1;
         for(int i = count_0+count_1 ; i<(count_0+count_1+count_2) ; i++)
        nums[i] = 2;
    }
}