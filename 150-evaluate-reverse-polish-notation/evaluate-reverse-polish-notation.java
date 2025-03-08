class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, tokens[i]);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    public boolean isOperator(String token) {
        return token.equals("+")|| token.equals("-")|| token.equals("*")|| token.equals("/");
    }

    public int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return operand1 / operand2;
            default: return 0;
        }
    }
}