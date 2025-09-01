import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = gain(a[0], a[1]);
            double gainB = gain(b[0], b[1]);
            return Double.compare(gainB, gainA); // max-heap
        });

        for (int[] c : classes) pq.offer(c);

        while (extraStudents-- > 0) {
            int[] cur = pq.poll();
            cur[0]++;  // add one student passes
            cur[1]++;  // total increases
            pq.offer(cur);
        }

        double sum = 0.0;
        for (int[] c : pq) {
            sum += (double) c[0] / c[1];
        }

        return sum / classes.length;
    }

    private double gain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
