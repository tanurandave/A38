public class ValidParenthesisStack {
   
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                top++;
                stack[top] = ch;
            }

            // Closing brackets
            else {

                // No opening bracket available
                if (top == -1) {
                    return false;
                }

                char open = stack[top];
                top--;

                if (ch == ')' && open != '(') {
                    return false;
                }

                if (ch == '}' && open != '{') {
                    return false;
                }

                if (ch == ']' && open != '[') {
                    return false;
                }
            }
        }

        // Stack should be empty
        return top == -1;
    }
}