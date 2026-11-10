class Solution {
    public int[] findBuildings(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }

            stack.push(i);
        }
        
        return stack.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}