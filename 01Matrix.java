//BFS by maintaining visited boolean matrix
// class Solution {
//     public int[][] updateMatrix(int[][] matrix) {
//         int m = matrix.length;
//         // edge case
//         if (matrix == null || m == 0) return matrix;
//         int n = matrix[0].length;
//         Queue<int[]> q = new LinkedList<>();
//         int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//         // Enqueue all 0s, mark 1s as unvisited with MAX_VALUE
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (matrix[i][j] == 0) {
//                     q.add(new int[]{i, j});
//                 } else {
//                     matrix[i][j] = Integer.MAX_VALUE;
//                 }
//             }
//         }
//         // BFS traversal
//         while (!q.isEmpty()) {
//             int[] curr = q.poll();
//             for (int[] dir : dirs) {
//                 int r = curr[0] + dir[0];
//                 int c = curr[1] + dir[1];
//                 // Only update if shorter distance found
//                 if (r >= 0 && r < m && c >= 0 && c < n &&
//                     matrix[r][c] > matrix[curr[0]][curr[1]] + 1) {
//                     matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
//                     q.add(new int[]{r, c});
//                 }
//             }
//         }
//         return matrix;
//     }
// }

//DFS
class Solution {
    private int m;
    private int n;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        // edge case
        if (matrix == null || m == 0) return matrix;
        n = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = dfs(matrix, result, i, j);
            }
        }      
        return result;
    }
    private int dfs(int[][] matrix, int[][] result, int i, int j) {
        // base case
        if (i < 0 || i >= m || j < 0 || j >= n) return 9999;
        if (matrix[i][j] == 0) return 0;
        if (i > 0 && matrix[i - 1][j] == 0) return 1;
        if (j > 0 && matrix[i][j - 1] == 0) return 1;
        if (i < m - 1 && matrix[i + 1][j] == 0) return 1;
        if (j < n - 1 && matrix[i][j + 1] == 0) return 1;
        // Don't have any neighboring zeros
        int top = 9999, left = 9999, right, bottom;
        if (i > 0 && result[i - 1][j] != 0) {
            top = result[i - 1][j];
        }
        if (j > 0 && result[i][j - 1] != 0) {
            left = result[i][j - 1];
        }
        bottom = dfs(matrix, result, i + 1, j);
        right = dfs(matrix, result, i, j + 1);
        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
    }
}