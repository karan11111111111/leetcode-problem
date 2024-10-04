import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through the string
        for (char c : s.toCharArray()) {
            // Push the corresponding closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If a closing bracket doesn't match the top of the stack, return false
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
