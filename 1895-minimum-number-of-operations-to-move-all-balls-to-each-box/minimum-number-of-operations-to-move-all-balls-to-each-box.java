class Solution {
    public int[] minOperations(String boxes) {

       
        int n = boxes.length();
        int result[] = new int[n];

        int count=0; int ops=0;

        for(int i=0; i<n; i++){
           result[i] += ops;
           count += boxes.charAt(i) -'0';
           ops += count;
            
        }


        count =0;
        ops =0;
        for(int i=n-1; i>=0; i--){
            result[i] += ops;
            count+= boxes.charAt(i) -'0';
            ops+=count;
        }

        return result;
        
    }
}

// class Solution {
//     public int[] minOperations(String boxes) {
//         int n = boxes.length();
//         int[] result = new int[n];

//         for (int i = 0; i < n; i++) {
//             int count = 0;
//             for (int j = 0; j < n; j++) {
//                 if (boxes.charAt(j) == '1') {
//                     count += Math.abs(j - i); // Add the distance between box `i` and box `j`.
//                 }
//             }
//             result[i] = count;
//         }

//         return result;
//     }
// }
