class Solution {
    public int minimizeXor(int num1, int num2) {

        int bits2 = Integer.bitCount(num2);
        int result =0;

        for(int i=31; i>=0 && bits2> 0; i--){
            if((num1&(1<<i))!=0){
                result |= (1<<i);
                bits2--;
            }
        }
        for(int i=0; i<32 && bits2>0; i++){
            if((result &(1<<i)) ==0){
                result |=(1<<i);
                bits2--;
            }
        }
        return result;
    }
}