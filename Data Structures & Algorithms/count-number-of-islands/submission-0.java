class Solution {
    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    numIslands++;
                    dfs(r, c, visited, grid);
                }
            }
        }
        return numIslands;
    }
    private void dfs(int r, int c, boolean[][] visited, char[][] grid) {
        // visit the node
        visited[r][c] = true;
        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[nr].length && grid[nr][nc] == '1'
                && !visited[nr][nc]) {
                dfs(nr, nc, visited, grid);
            }
        }
    }
}