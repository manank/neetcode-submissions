class Solution {
    public String simplifyPath(String path) {

        String[] tokens = path.split("/");

        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {

            switch (token) {
                case ".", "" -> {
                    // do nothing
                }
                case ".." -> {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                default -> {
                    stack.push(token);
                }
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append('/').append(stack.removeLast());
        }

        return sb.toString();
    }
}