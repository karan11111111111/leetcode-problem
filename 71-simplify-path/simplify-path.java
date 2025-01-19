class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        // Split the input path by "/"
        String[] components = path.split("/");

        for (String component : components) {
            // If component is empty or ".", skip it
            if (component.equals("") || component.equals(".")) {
                continue;
            }
            // If it's "..", pop from stack if not empty
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Otherwise, push the component onto the stack
                stack.push(component);
            }
        }

        // If stack is empty, return root directory
        if (stack.isEmpty()) {
            return "/";
        }

        // Join the components of the stack into a single path
        StringBuilder simplifiedPath = new StringBuilder();
        while (!stack.isEmpty()) {
            simplifiedPath.insert(0, "/" + stack.pop());
        }

        return simplifiedPath.toString();
    }
}
