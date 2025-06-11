// class Solution {
//     public int subarraySum(int[] nums, int k) {

        // int count =0;
        // int sum =0;
        // Map<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);       

        // for(int i=0; i<nums.length; i++){
        //     sum = sum+ nums[i];

        //     if(map.containsKey(sum-k)){
        //         count += map.get(sum-k);
        //     }


        //     map.put(sum,map.getOrDefault(sum,0)+1);
        // }

        // return count;

        
//     }
// }
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);  // for subarrays that start from index 0

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
