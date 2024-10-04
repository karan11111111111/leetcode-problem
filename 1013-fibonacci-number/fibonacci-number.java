// class Solution {
//     public int fib(int n) {
//         if(n == 0){
//             return 0;
//         }
//         if( n==1){
//             return 1;
//         }

//         return fib(n-1) +fib(n-2);

//     }
// }

class Solution {
    public int fib(int n) {
        if(n==0) 
        return 0;
        if(n==1) 
        return 1;
        return calFib(0,1,2,n);
    }
    public static int calFib(int st1,int st2,int i,int n)
    {
        if(i==n) 
        return st1+st2;
        
        int temp=st2+st1;
        st1=st2;
        st2=temp;
        int res=calFib(st1,st2,++i,n);
        return res;
    }
}