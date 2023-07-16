class Solution {
    public boolean isPalindrome(String s) {
        /* Clarify
        Palindrome: string reads the same forwards & backwards
        Convert uppercase letters into lowercase
        Remove all alphanumeric chars
        Given string
        Return true if palidrone, false otherwise
        */

        /* Example
        Input: s = "Race Car"
        Output: return true

        Input: s = "Race a Car"
        Output: return false

        Input: s = ""
        Output: true
        */

        /* Approach
        Stack + Queue: O(n) runtime, O(n) space
        convert string to all lowercase
        remove non-alphanumeric chars
        stack stores given string chars
        queue stores given string chars
        for loop iterates through string chars
            add chars to stack
            add chars to queue
        for loop iterates through stack & queue
            if statement checks stack pop != queue pop
                return false
        return true

        Two Pointers: O(n) runtime, O(1) space
        convert string to all lowercase
        remove non-alphanumeric chars
        int stores right-hand pointer
        for loop iterates through string chars
            if statement checks left-hand pointer != right-hand pointer
                return false
        return true
        */

        s = s.toLowerCase();
        String reformat = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                reformat = reformat + s.charAt(i);
            }
        }
        int r = reformat.length() - 1;
        for (int l = 0; l < reformat.length(); l++) {
            // No need to check values twice
            if (l >= r) {
                break;
            }
            if (reformat.charAt(l) != reformat.charAt(r)) {
                return false;
            }
            r--;
        }
        return true;

        /* Test
        Input: s = "Race Car"
        s = "race car"" >> ... i = 4 >> " " != LetterOrDigit >> s = "race" >> i = 5 >> s = "racec" >> ... s = "racecar"
        r = 7 - 1 = 6
        l = 0, r = 6 >> r == r >> l = 1, r = 5 >> a == a >> ... l = 3, r = 3 >> break loop
        Output: return true

        Input: s = "Race a Car"
        s = "race a car" >> s = "raceacar"
        r = 8 = 1 = 7
        l = 0, r = 7 >> r == r >> ... l = 3, r = 4 >> e != a
        Output: return false

        Input: s = ""
        r = 0 - 1 = -1
        l = 0, r = -1
        Output: return true
        */
    }
}