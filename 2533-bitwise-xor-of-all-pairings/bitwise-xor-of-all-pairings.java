class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

        

        int xor1 =0;
        int xor2 =0;

        int n= nums1.length;
        int m= nums2.length;

        if(n%2==0 && m%2==0){
            return 0;
        }

        for(int num : nums1){
          xor1 ^= num;
        }  

        for(int num: nums2){
         xor2 ^= num;
        }  

        if(n%2==0){
            return xor1;
        } 
        if(m%2==0){
            return xor2;
        }


        return xor1 ^xor2;   
    }
}