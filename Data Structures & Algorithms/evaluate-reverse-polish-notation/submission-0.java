class Solution {

    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            switch (token) {
                case "+", "-", "*", "/" -> {
                    // eval and push result to stack
                    Integer operand2 = stack.pop();
                    Integer operand1 = stack.pop();
                    stack.push(eval(token.charAt(0), operand1, operand2));
                }

                default -> {
                    stack.push(Integer.valueOf(token));
                }
            }
        }

        return stack.pop();
    }

    private int eval (char op, int op1, int op2) {

        return switch (op) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> op1 / op2;
            default -> 0;
        };
    }
}
