import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Sort the array
        Arrays.sort(nums);

        // First loop to fix the first number
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second loop to fix the second number
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Use two pointers to find the other two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Add the quadruplet to the result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third number
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Skip duplicates for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Move both pointers inward
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Increase the sum
                    } else {
                        right--; // Decrease the sum
                    }
                }
            }
        }

        return result;
    }
}


// import java.util.*;

// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
//         Set<List<Integer>> result = new HashSet<>();

//         // Try all quadruplets using 4 nested loops
//         for (int i = 0; i < n - 3; i++) {
//             for (int j = i + 1; j < n - 2; j++) {
//                 for (int k = j + 1; k < n - 1; k++) {
//                     for (int l = k + 1; l < n; l++) {
//                         long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; // Use long to prevent overflow
//                         if (sum == target) {
//                             List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                             Collections.sort(quad); // sort to avoid duplicates
//                             result.add(quad);       // add to set to filter duplicates
//                         }
//                     }
//                 }
//             }
//         }

//         return new ArrayList<>(result);
//     }
// }
