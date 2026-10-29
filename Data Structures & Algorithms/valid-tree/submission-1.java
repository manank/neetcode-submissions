class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>(n);
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

         for (int i = 0; i < n; i++) {
            adjList.add(new LinkedList<>());
            parent[i] = -1;
            visited[i] = false;
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                components++;
                if (components > 1) {
                    return false;
                }

                if (hasCycle(v, visited, parent, adjList)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int v, boolean[] visited, int[] parent,
        List<List<Integer>> adjList) {
        visited[v] = true;
        
        for (int w : adjList.get(v)) {
            if (!visited[w]) {
                parent[w] = v;
                if (hasCycle(w, visited, parent, adjList)) {
                    return true;
                }
            } else if (parent[v] != w) {
                return true;
            }
        }

        return false;
    }
}
