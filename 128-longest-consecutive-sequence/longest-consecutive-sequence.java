class Solution {
    public int longestConsecutive(int[] nums) {

       if(nums.length == 0){
               return 0;
            }


        Arrays.sort(nums);
        int longeststraak =1;
        int currentstreak =1;
         
        for(int i=1; i<nums.length; i++){
         

            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    currentstreak++;
                }else{
                 longeststraak = Math.max(longeststraak, currentstreak);
                 currentstreak =1;
                }

            }
        }

        return Math.max(longeststraak,currentstreak);
    }
}