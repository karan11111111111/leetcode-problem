class Solution {
    public int majorityElement(int[] nums) {
        // int n = nums.length;
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<n; i++){
        //     if(map.containsKey(nums[i])){
        //         map.put(nums[i], map.get(nums[i])+1);
        //     }else{
        //         map.put(nums[i], 1);
        //     }
        // }
        // for (Map.Entry<Integer, Integer>entry:map.entrySet()){
        //     if(entry.getValue() > n/2){
        //         return entry.getKey();
        //     }
        // }
        // return -1;


        // if (nums.length == 0) {
        //     return -1; // Return an invalid value since there is no majority element.
        // }

        Arrays.sort(nums);
        return nums[nums.length / 2]; // The majority element is guaranteed to be at the middle after sorting.
       
       
    
    }

}

