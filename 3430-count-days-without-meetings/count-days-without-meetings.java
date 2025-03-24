class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings based on start day
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int occupiedDays = 0;
        int prevStart = -1, prevEnd = -1;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > prevEnd) {
                // Non-overlapping, add previous interval to occupied days
                if (prevEnd != -1) {
                    occupiedDays += (prevEnd - prevStart + 1);
                }
                prevStart = start;
                prevEnd = end;
            } else {
                // Overlapping, merge intervals
                prevEnd = Math.max(prevEnd, end);
            }
        }

        // Add last merged interval
        if (prevEnd != -1) {
            occupiedDays += (prevEnd - prevStart + 1);
        }

        // Calculate available days
        return days - occupiedDays;
    }
}
