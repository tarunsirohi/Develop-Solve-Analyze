import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodeCount = graph.length;
        int[] inDegree = new int[nodeCount];
        List<List<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int node = 0; node < nodeCount; node++) {
            for (int neighbor : graph[node]) {
                reversedGraph.get(neighbor).add(node);
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < nodeCount; node++) {
            if (inDegree[node] == 0) {
                queue.add(node);
            }
        }

        boolean[] isSafe = new boolean[nodeCount];
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            isSafe[currentNode] = true;

            for (int neighbor : reversedGraph.get(currentNode)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int node = 0; node < nodeCount; node++) {
            if (isSafe[node]) {
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }
}

