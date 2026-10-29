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

                if (hasCycleBfs(v, visited, parent, adjList)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycleBfs(int s, boolean[] visited, int[] parent, List<List<Integer>> adjList) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(s);
        visited[s] = true;

        while (!deque.isEmpty()) {

            int v = deque.pop();

            for (int w : adjList.get(v)) {

                if (!visited[w]) {
                    parent[w] = v;
                    visited[w] = true;
                    deque.add(w); 
                } else if (parent[v] != w) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycleDfs(int v, boolean[] visited, int[] parent, List<List<Integer>> adjList) {
        visited[v] = true;
        
        for (int w : adjList.get(v)) {
            if (!visited[w]) {
                parent[w] = v;
                if (hasCycleDfs(w, visited, parent, adjList)) {
                    return true;
                }
            } else if (parent[v] != w) {
                return true;
            }
        }

        return false;
    }
}
