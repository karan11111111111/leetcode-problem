class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>(); 
        
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int target = -nums[i];
            int left =i+1;
            int right = n-1;
        
       
        while(left <right){
            int targetsum = nums[left] + nums[right];

            if(targetsum ==target){
                list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                while(left<right && nums[left] == nums[left+1]){
                    left++;
                }

                while(left<right && nums[right] == nums[right-1]){
                    right--;
                }

                left++;
                right--;

               
            }else if(targetsum <target){
                left++;
            }else{
                right--;
            }

        }  
        }
        return list;
    }
}


// Brute Force


// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
        
//         Set<List<Integer>> result = new HashSet<>(); 
        
//         List<Integer> list = new ArrayList<>();

//         int n = nums.length;

//         for(int i=0; i<n-2; i++){
//             for(int j=i+1; j<n-1; j++){
//                 for(int k = j+1; k<n; k++){
//                     if(nums[i]+nums[j]+nums[k] ==0){
//                         list = Arrays.asList(nums[i], nums[j] , nums[k]);
//                         Collections.sort(list);
//                         result.add(list);
//                     }
//                 }

//             }
//         }

//         return new ArrayList<>(result);
//     }
// }