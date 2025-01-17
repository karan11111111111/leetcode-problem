// class Solution {
//     public boolean doesValidArrayExist(int[] derived) {
//         int x = derived[0];
//         for(int i=1; i<derived.length; i++){
//             x^=derived[i];

//         }
//         return x==0;
//     }
// }

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        // Define the helper function as a separate method
        return isValid(derived, n, 0) || isValid(derived, n, 1);
    }

    // Helper function to check if a valid array can exist with a given start
    private boolean isValid(int[] derived, int n, int start) {
        int[] original = new int[n];
        original[0] = start;

        // Compute the rest of the array
        for (int i = 1; i < n; i++) {
            original[i] = original[i - 1] ^ derived[i - 1];
        }

        // Check the circular condition
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
