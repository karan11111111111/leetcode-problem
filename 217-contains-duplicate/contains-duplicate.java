class Solution {
    // public boolean containsDuplicate(int[] nums) {
        
    //     for(int i=0; i<nums.length; i++){
    //         for(int j=i+1; j<nums.length; j++){
    //             if(nums[i] == nums[j]){
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
        
    // }
    // public boolean containsDuplicate(int[] nums) {
        
    //   Map<Integer, Boolean> mp = new HashMap<>();

    //   for(int num: nums){
       
    //    if(mp.containsKey(num)){
    //     return true;
    //    }
    //    mp.put(num,true);

    //   }
    //     return false;
        
    // }



    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        
     

     for(int i=0; i<nums.length-1; i++){
        if(nums[i] == nums[i+1]){
            return true;
        }
     }
       
      
        return false;
        
    }
    // public boolean containsDuplicate(int[] nums) {
        
    //   Set<Integer> st = new HashSet<>();

    //   for(int num: nums){
       
    //    if(!st.add(num)){
    //     return true;
    //    }
      

    //   }
    //     return false;
        
    // }
}