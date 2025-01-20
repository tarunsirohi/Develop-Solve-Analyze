import java.util.*;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Step-1: Create a lookup for each value in the matrix
        Map<Integer, int[]> lookup = new HashMap<>(); // Stores x, y coordinates for each element
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lookup.put(mat[i][j], new int[]{i, j});
            }
        }

        // Step-2: Find the earliest row or column painted
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int[] coordinate = lookup.get(arr[i]);
            int x = coordinate[0];
            int y = coordinate[1];

            rowCount[x]++;
            colCount[y]++;
            if (rowCount[x] == n || colCount[y] == m) {
                return i;
            }
        }
        return 0;
    }
}