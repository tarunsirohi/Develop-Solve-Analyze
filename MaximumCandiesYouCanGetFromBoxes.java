class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        
        Queue<Integer> q = new LinkedList<>();
        for (int start : initialBoxes) {
            q.offer(start);
        }
        
        Set<Integer> closed = new HashSet<>();
        int total = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (status[curr] == 0) {
                closed.add(curr);
                continue;
            }
            
            for (int open : keys[curr]) {
                status[open] = 1;
                if (closed.contains(open)) {
                    q.offer(open);
                    closed.remove(open);
                }
            }
            
            total += candies[curr];
            for (int nbr : containedBoxes[curr]) {
                q.offer(nbr);
            }
        }
        
        return total;
    }
}