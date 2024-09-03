class Solution {
    public boolean isValid(String s) {
        /* Clarify
        given a string with brackets
        return boolean if string is valid
        valid if:
            brackets are closed by same type
            brackets are closed in correct order (open/close)
        odd input is invalid
        can be given non-bracket chars? (no, assume all brackets)
        */

        /* Example
        Input: s = "()[]"
        Output: true

        Input: s = "([])"
        Output: true

        Input: s = "(]"
        Output: false

        Input: s = ")("
        Output: false
        */

        /* Approach
        if statement checks string length is odd
            return false
        Stack stores open brackets
        for loop iterates through string
            if statement checks string char == ( || { || [
                add char to Stack
            else if statement checks string char == ) && Stack peek == (
                remove from Stack
            else if statement checks string char == } && Stack peek == {
                remove from Stack
            else if statement checks string char == ] && Stack peek == [
                remove from Stack
            else
                return false
        return if Stack is empty
        */

        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> opens = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                opens.push(s.charAt(i));
            }
            // check Stack is empty in case close bracket is given before open bracket
            else if (s.charAt(i) == ')' && !opens.isEmpty() && opens.peek() == '(') {
                opens.pop();
            }
            else if (s.charAt(i) == '}' && !opens.isEmpty() && opens.peek() == '{') {
                opens.pop();
            }
            else if (s.charAt(i) == ']' && !opens.isEmpty() && opens.peek() == '[') {
                opens.pop();
            }
            else {
                return false;
            }
        }
        return opens.isEmpty();

        /* Test
        Input: s = "()[]"
        i = 0 >> == ( >> opens = "("
        i = 1 >> == ) && peek == ( >> opens = ""
        i = 2 >> == [ >> opens = "["
        i = 3 >> == ] && peek == [ >> opens = "" >> return true

        Input: s = "([])"
        i = 0 >> == ( >> opens = "("
        i = 1 >> == [ >> opens = "(["
        i = 2 >> == ] >> peek == [ >> opens = "("
        i = 3 >> == ) >> peek == ( >> opens = "" >> return true

        Input: s = "(]"
        i = 0 >> == ( >> opens = "("
        i = 1 >> == ] >> peek != [ >> return false

        Input: s = ")("
        i = 0 >> == ) >> peek isEmpty >> return false
        */

        /* Optimize
        O(n) runtime, iterates through single for loop based on given string length
        O(n) space, create Stack data structure based on given string length
        */
    }
}