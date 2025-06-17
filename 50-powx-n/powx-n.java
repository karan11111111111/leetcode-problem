// class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0) return 1;

//         if (n < 0) {
//             return 1 / (x * myPow(x, -(n + 1)));

//         }

//         return x * myPow(x, n - 1);
//     }
// }

// class Solution {
//     public double myPow(double x, int n) {
//         double pow = 1;
//         long N = n;  // use long to handle Integer.MIN_VALUE

//         if (N < 0) {
//             x = 1 / x;
//             N = -N;
//         }

//         for (int i = 0; i < N; i++) {
//             pow *= x;
//         }

//         return pow;
//     }
// }

class Solution {
    public double myPow(double x, int n) {
        long N = n;  

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return pow(x, N);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;

        double half = pow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
