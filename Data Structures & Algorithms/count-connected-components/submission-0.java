class Solution {
    public int countComponents(int n, int[][] edges) {

        List<Integer>[] adjList = new List[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                components++;
                dfs(v, adjList, visited);                
            }
        }

        return components;
    }

    private void dfs(int v, List<Integer>[] adjList, boolean[] visited) {

        // visit
        visited[v] = true;
        for (int w : adjList[v]) {
            if (!visited[w]) {
                dfs(w, adjList, visited);
            }
        }
    }
}
