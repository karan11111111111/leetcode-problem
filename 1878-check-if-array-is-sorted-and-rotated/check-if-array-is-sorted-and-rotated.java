class Solution {
   public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }

}

// class Solution {
//     public boolean check(int[] nums) {

//         int n = nums.length;

//         int [] arr =new int[n];

//         int k =1;
//         for(int i=0; i<n; i++){
//             arr[i] = nums[i];
//         }

//         for(int i=1; i<n; i++){
//             if(nums[i] >=nums[i-1] ){
//                 k++;
//                 break;
//             }
//         }

//         Arrays.sort(nums);

//         rotate(nums, k);
//        for(int i=0; i<n; i++){
//         if(nums[i] != arr[i]){
//             return true;
//         }

//        }

//        return false;
        
//     }

//     public static void rotate(int [] arr, int k){
//         int n = arr.length;
//         k = k%n;

//         reverse(arr, 0, k-1);
//         reverse(arr, k, n-1);
//         reverse(arr, 0, n-1);

//     }

//     public static void reverse(int[] arr, int start, int end){

//         start = 0;
//         end = arr.length-1;

//         while(start < end){
//             int temp = arr[start];
//             arr[start] = arr[end];
//             arr[end] = temp;
//             start++;
//             end--;
//         }
//     }
// }