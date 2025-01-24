import java.util.*;

class MedianFinder {
    
    private PriorityQueue<Integer> maxHeap; // To store the smaller half
    private PriorityQueue<Integer> minHeap; // To store the larger half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-Heap (inverted)
        minHeap = new PriorityQueue<>(); // Min-Heap
    }
    
    public void addNum(int num) {
        // Add to max-heap (for the smaller half)
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        // Balance the heaps if necessary
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */