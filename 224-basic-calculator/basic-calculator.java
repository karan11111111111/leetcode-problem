class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        int sign = 1;  
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            
            
            if (ch == '+' || ch == '-' || ch == '(' || ch == ')' || i == s.length() - 1) {
                if (ch == '+' || ch == '-') {
                    result += sign * currentNumber;
                    currentNumber = 0;
                    sign = (ch == '+') ? 1 : -1;
                }
                
               
                if (ch == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                }
                
                
                if (ch == ')') {
                    result += sign * currentNumber;
                    currentNumber = 0;
                    result *= stack.pop(); 
                    result += stack.pop();  
                }
            }
        }
        
        result += sign * currentNumber;
        return result;
    }
}
