// //BFS: Queue
// //TC = O(m*n), SC=O(m*n)
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         if(image==null || image.length == 0) return image;
//         int m = image.length;
//         int n = image[0].length;
//         int initColor = image[sr][sc];
//         if (image[sr][sc]==color) return image;
//         int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
//         Queue<Integer> q = new LinkedList<>();
//         q.add(sr);
//         q.add(sc);
//         image[sr][sc] = color;
//         while(!q.isEmpty()){
//             int cr = q.poll(); //current row index
//             int cc = q.poll(); //current col index
//             for (int [] dir: dirs){
//                 int nr = dir[0]+cr; //neighboring row index
//                 int nc = dir[1]+cc; //neighboring col index
//                 if (nr >=0 && nc >= 0 && nr<m && nc<n && image[nr][nc]==initColor){
//                     q.add(nr);
//                     q.add(nc);
//                     image[nr][nc] = color;
//                 }
//             }
//         }
//         return image;
//     }
// }

//DFS: recursion
//TC = O(m*n), SC=O(m*n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        int initColor = image[sr][sc];
        if (image[sr][sc]==color) return image;
        int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        dfs(image, sr, sc, color, initColor, dirs);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int initColor, int[][] dirs){
        //base
        if(sr<0 || sc<0 || sr == image.length || sc == image[0].length || image[sr][sc] != initColor) return;
        //logic
        image[sr][sc] =color;
        for(int [] dir:dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, initColor, dirs);
        }
    }
}