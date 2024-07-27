class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int [] arr = new int [n+1];
        for(int i=0; i<trust.length; i++){
            arr[trust[i][1]]++;
            arr[trust[i][0]]--;
        }
        int x = -1;

        for(int i=1; i<arr.length; i++){
            if(arr[i] == n-1){
                x=i;
            }
        }

        return x;
    }
}