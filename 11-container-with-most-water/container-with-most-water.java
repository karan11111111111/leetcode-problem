class Solution {
    public int maxArea(int[] height) {

        int n = height.length;

        int start = 0;
        int end = n-1;

        int maxArea =0;


        while(start <end){
            int width = end-start;
           
           int area = Math.min(height[start] , height[end]) * width;

               maxArea = Math.max(maxArea, area);
 
         if(height[start] < height[end]){
            start++;
         }else{
            end--;
         }
            
        }

        return maxArea;
        
    }
}