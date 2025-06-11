class Solution {
    public void setZeroes(int[][] matrix) {
      

        int n = matrix.length;
        int m = matrix[0].length;
       int[][] temp = new int[n][m] ;

       for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            temp[i][j] = matrix[i][j];
        }
       }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(temp[i][j] == 0){
                    for(int k=0; k<m; k++){
                        matrix[i][k] =0;
                    }
                    for(int k=0; k<n; k++){
                        matrix[k][j] =0;
                    }
                }
            }
        }
    }
}
