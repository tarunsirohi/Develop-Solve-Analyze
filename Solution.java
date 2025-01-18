import java.util.*;

public class Solution {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Triplet implements Comparable<Triplet> {
        int cost, x, y;
        Triplet(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Triplet other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>(); // cost, row, col
        minHeap.add(new Triplet(0, 0, 0));
        int[] dx = {0, 0, 1, -1}; // Right, Left, Down, Up
        int[] dy = {1, -1, 0, 0};

        while (!minHeap.isEmpty()) {
            Triplet curr = minHeap.poll();
            int cost = curr.cost;
            int x = curr.x;
            int y = curr.y;

            if (visited[x][y]) // Already processed
                continue;

            if (x == m - 1 && y == n - 1) // Reached destination
                return cost;

            visited[x][y] = true;

            for (int i = 0; i < 4; ++i) { // Right, Left, Down, Up
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isValid(newX, newY, m, n) && !visited[newX][newY]) {
                    int newCost = cost;
                    newCost += (i + 1) == grid[x][y] ? 0 : 1;
                    minHeap.add(new Triplet(newCost, newX, newY));
                }
            }
        }
        return 0;
    }
}
