class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1) {
            return rotations;
        } else {
            return check(bottoms[0], tops, bottoms);
        }
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotationTop = 0;
        int rotationBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // Cannot make all values equal to target
            } else if (tops[i] != target) {
                rotationTop++; // Need to rotate top to bring target up
            } else if (bottoms[i] != target) {
                rotationBottom++; // Need to rotate bottom to bring target up
            }
        }

        return Math.min(rotationTop, rotationBottom);
    }
}
