// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//        int n = nums.length;

//        int b[] =new  int[2];
//        for(int i=0; i<n; i++){
//         for(int j=i+1; j<n; j++){
//             if(nums[i]+nums[j]==target){
//               b[0] = i;
//               b[1] = j;  
//               return b;
//             }
//         }
//        }

//     return null;
//     }
// }

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//          for(int i = 1;i<nums.length;i++)
//          {
//             for(int j=i;j<nums.length;j++)
//             {
//                 if(nums[j]+nums[j-i]==target)
//                 {
//                     return new int[] {j,j-i};
//                 }
//             }
//          }
//          return null;
//     }
// }


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Find the complement

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                // Return the indices of the complement and the current number
                return new int[] { map.get(complement), i };
            }

            // Add the current number and its index to the map
            map.put(nums[i], i);
        }

        // Return null if no solution is found
        return null;
    }
}
