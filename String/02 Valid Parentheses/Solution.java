class Solution {
    public boolean isValid(String s) {
        /* Questions
        One parameter? (Yes, string)
        */
        
        /* Approach
        if statement checks length is odd
            return false
        stack stores characters
        for loop iterates through string characters
            if statement checks left bracket
                add left bracket to stack
            if statement checks right bracket & top of stack is correct left bracket
                pop stack
        return stack is empty
        */
        
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                brackets.push(s.charAt(i));
            }
            // Write && statements in order (Check empty first before peek)
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
        
        /* Tests
        s = "()"
        2 % 2 == 0
        i = 0 >> brackets = [(] >> i = 1 >> brackets = [] >> return true
        
        s = "()[]{}"
        6 % 2 == 0
        i = 0 >> brackets = ['('] >> i = 1 >> brackets = [] >> i = 2 >> brackets = ['['] >> i = 3 >> brackets = []
        i = 4 >> brackets = ['{'] >> i = 5 >> brackets = [] >> return true
        
        s = "(]"
        2 % 2 == 0
        i = 0 >> brackets = ['('] >> i = 1 >> brackets = ['('] >> return false
        
        s = "([}}])"
        6 % 2 == 0
        i = 0 >> brackets = ['('] >> i = 1 >> brackets = ['(','[']
        i = 2 >> '}' && peek != '{' >> return false
        */
        
        /* Optimize
        O(n) runtime, iterates through single for loop
        O(n) space, created stack based on given string size
        */
    }
}