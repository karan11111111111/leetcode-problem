class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int x = derived[0];
        for(int i=1; i<derived.length; i++){
            x^=derived[i];

        }
        return x==0;
    }
}