import java.util.HashSet;

class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        HashSet<String> set = new HashSet<>();
        char[] tileArray = tiles.toCharArray();
        backtrack(tileArray, "", used, set);
        return set.size();
    }

    private void backtrack(char[] tiles, String current, boolean[] used, HashSet<String> set) {
        if (!current.isEmpty()) {
            set.add(current);
        }

        for (int i = 0; i < tiles.length; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(tiles, current + tiles[i], used, set);
                used[i] = false;
            }
        }
    }
}
