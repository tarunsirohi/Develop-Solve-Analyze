class Solution {
    public int minOperations(int[] nums, int k) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        for (int num : nums) {
            minheap.add((long) num); // Add all elements to the heap
        }

        int count = 0; // Counter for the number of operations
        while (!minheap.isEmpty()) {
            long min1 = minheap.poll(); // Get the smallest element
            if (min1 >= k) {
                break; // If the smallest element is >= k, stop
            }
            long min2 = minheap.poll(); // Get the second smallest element
            // Push the new element into the heap
            minheap.add(2 * Math.min(min1, min2) + Math.max(min1, min2));
            count++; // Increment the operation count
        }
        return count;
    }
}