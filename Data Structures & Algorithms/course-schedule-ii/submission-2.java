class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            adjList.computeIfAbsent(
                prerequisite[1], k -> new LinkedList<>())
                .add(prerequisite[0]);
        } 

        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int c = 0; c < numCourses; c++) {
            if (!dfs (c, visiting, visited, adjList, result)) {
                return new int[0];
            }
        }        

        return result.reversed().stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int s, boolean[] visiting, boolean[] visited, Map<Integer,
        List<Integer>> adjList, List<Integer> result) {
        
        visiting[s] = true;
        visited[s] = true;

        for (int w : adjList.getOrDefault(s, Collections.emptyList())) {
            if (visiting[w]) {
                return false;
            } else if (!visited[w]) {
                if (!dfs(w, visiting, visited, adjList, result)) {
                    return false;
                }
            }
        }

        visiting[s] = false;
        result.add(s);
        return true;
    }

    public int[] findOrderKahn(int numCourses, int[][] prerequisites) {

        int[] inDegrees = new int[numCourses];

        List<List<Integer>> adjList = new ArrayList<>(numCourses);

        for (int c = 0; c < numCourses; c++) {
            adjList.add(new LinkedList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }

        boolean[] visited = new boolean[numCourses];
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int c = 0; c < numCourses; c++) {
            if (inDegrees[c] == 0) {
                visited[c] = true;
                q.add(c);
            }
        }

        List<Integer> result = new ArrayList<>(numCourses);
        
        while (!q.isEmpty()) {

            int c = q.remove();
            result.add(c);

            for (int w : adjList.get(c)) {
                inDegrees[w]--;
                if (inDegrees[w] == 0) {
                    visited[w] = true;
                    q.add(w);
                }
            }
        }

        if (result.size() == numCourses) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
    }
}
