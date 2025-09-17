// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> triangle = new ArrayList<>();

//         for (int i = 0; i < numRows; i++) {
//             List<Integer> row = new ArrayList<>();

//             for (int j = 0; j <= i; j++) {
//                 if (j == 0 || j == i) {
//                     row.add(1); 
//                 } else {
//                     int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
//                     row.add(val);
//                 }
//             }

//             triangle.add(row);
//         }

//         return triangle;
//     }
// }
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int arr[][] = new int[numRows][numRows];

        arr[0][0] = 1;
        if (numRows > 1) {
            arr[1][0] = 1;
            arr[1][1] = 1;
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        // Only include first (i+1) elements of each row
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(arr[i][j]);
            }
            list.add(row);
        }

        return list;
    }
}
