// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         Stack<Integer> stack = new Stack<>();
//         int maxArea = 0;
        
//         for (int i = 0; i <= n; i++) {
//             int currHeight = (i == n) ? 0 : heights[i];
            
//             while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
//                 int height = heights[stack.pop()];
//                 int width;
                
//                 if (stack.isEmpty()) {
//                     width = i;
//                 } else {
//                     width = i - stack.peek() - 1;
//                 }
                
//                 int area = height * width;
//                 maxArea = Math.max(maxArea, area);
//             }
//             stack.push(i);
//         }
        
//         return maxArea;
//     }
// }


// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//          int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             int minHeight = Integer.MAX_VALUE;
//             for (int j = i; j < n; j++) {
//                 minHeight = Math.min(minHeight, heights[j]);
//                 maxArea = Math.max(maxArea, minHeight * (j - i + 1));
//             }
//         }
//         return maxArea;
//     }
// }


class Solution {
   static int largestRectangleArea(int histo[]) {
        Stack < Integer > st = new Stack < > ();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}
