class Solution {
    public boolean isPalindrome(String s) {
        /* Questions
        Palindrome meaning? (Same word forwards & backwards)
        Case sensitive? (No, turn uppercase into lowercase)
        Given 1 parameter? (Yes, string)
        Including whitespace? (No, remove whitespaces)
        */
        
        /* Approach
        stack stores phrase chars (backwards)
        queue stores phrase chars (forwards)
        for loop iterates through string chars
            if statement checks non-alphanumeric
                skip
            convert to lowercase
            add char to stack
            add char to queue
        while loop iterates until stack is empty
            if statement checks current chars are not equal
                return false
        return true
        */
        
        /*
        Stack<Character> backwards = new Stack<>();
        Queue<Character> forwards = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                continue;
            }
            char letter = Character.toLowerCase(s.charAt(i));
            backwards.push(letter);
            forwards.add(letter);
        }
        while (!backwards.isEmpty()) {
            if (backwards.peek() != forwards.peek()) {
                return false;
            }
            backwards.pop();
            forwards.remove();
        }
        return true;
        */
        
        /* Tests
        s = "racecar"
        backwards = [r a c e c a r], forwards = [r a c e c a r]
        r == r, a == a, c == c, e === e, c == c, a == a, r == r >> return true
        
        s = "Race a Car"
        skips whitespaces
        converts uppercase to lowercase
        backwards = [r a c e a c a r], forwards = [r a c a e c a r]
        r == r, a == a, c == c, e != a >> return false
        */
        
        /* Optimize
        O(n) runtime, iterates through separate for loop & while loop
        O(n) space, created stack & queue based on given string size
        
        Follow-up: Possible without using additional data structures?
        
        convert string to lowercase
        ints store left pointer = 0, right pointer = length - 1
        while loop iterates until left > right
            if statement checks non-alphanumeric
                skip
            if statement checks left char != right char
                return false
            increment left
            decrement right
        return true
        
        O(n) runtime, iterates through single while loop
        O(n) space, no additional data structures created
        */
        
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
        /* Tests
        s = "racecar"
        left = 0, right = 6 >> r == r >> left = 1, right = 5 >> a == a >> left = 2, right = 4 >> c == c >>
        left = 3, right = 3 >> e == e >> left = 4, right = 3 >> return true
        
        s = "A man, a plan, a canal: Panama" >> s = "a man, a plan, a canal: panama"
        left = 0, right = 29 >> a == a >> left = 1 >> left = 2, right = 28 >> m == m >> left = 3, right = 27 >> a == a >>
        left = 4, right = 26 >> n == n >> left = 5 >> left = 6 >> left =  7, right = 25 >> a == a >> etc. >> return true
        
        s = " "
        >> return true
        */
    }
}