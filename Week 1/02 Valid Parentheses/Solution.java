class Solution {
    public boolean isValid(String s) {
        /* Clarify
        Given string containing various parentheses types
        Determine if the input string is valid
            Open brackets must be closed by same type of bracket
            Open brackets must be closed in correct order
        Contains any other chars? No, only parentheses
        Odd string lengths will always be invalid
        */

        /* Example
        Input: s = "(){}"
        Output: return true

        Input: s = "({})"
        Output: return true

        Input: s = "(}"
        Output: return false

        Input: "(}})"
        Output: return false
        */

        /* Approach
        Stack: O(n) runtime, O(n) space
        if statement checks string length odd
            return false
        Stack stores open brackets
        for loop iterates through every string char
            if statement checks char is open bracket (,{,[
                add char to stack
            if statement checks close bracket ),},] & stack peek is matching open bracket (,{,[
                remove char from stack
            else not matching
                return false
        return empty stack flag
        */

        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                brackets.push(s.charAt(i));
            }
            // Check stack is not empty to prevent null pointer when close bracket is given first
            else if (s.charAt(i) == ')' && !brackets.isEmpty() && brackets.peek() == '(') {
                 brackets.pop();
            }
            else if (s.charAt(i) == '}' && !brackets.isEmpty() && brackets.peek() == '{') {
                brackets.pop();
            }
            else if (s.charAt(i) == ']' && !brackets.isEmpty() && brackets.peek() == '[') {
                brackets.pop();
            }
            else {
                return false;
            }
        }
        return brackets.isEmpty();

        /* Test
        Input: s = "(){}"
        i = 0; 0 < 4
            brackets = ['(']
        i = 1; 1 < 4
            ')' & peek = '('
            brackets = []
        i = 2; 2 < 4
            brackets = ['{']
        i = 3; 3 < 4
            '}' & peek = '{'
            brackets = []
        Output: return true

        Input: s = "({})"
        i = 0; 0 < 4
            brackets = ['(']
        i = 1; 1 < 4
            brackets = ['(','{']
        i = 2; 2 < 4
            '}' & peek = '{'
            brackets = ['(']
        i = 3; 3 < 4
            ')' & peek = '('
            brackets = []
        Output: return true

        Input: s = "(}"
        i = 0; 0 < 2
            brackets = ['(']
        i = 1; 1 < 2
            '}' & peek != '{'
        Output: return false

        Input: "(}})"
        i = 0; 0 < 4
            brackets = ['(']
        i = 1; 1 < 4
            '}' & peek != '{'
        Output: return false
        */
    }
}