class Solution {
    /* Clarify
    palindrome: the same word forwards and backwards
    given a string
    return true if palindrome or false if not
    convert all uppercase letters to lowercase
    remove all non-alphanumeric chars
    */

    /* Approach
    String stores lowercase, alphanumeric value
    for loop iterates through given string
        if statement checks char is letter or digit
            add char to String as lowercase
    Stack stores backwards spelling of String
    for loop iterates through formatted string
        add char to Stack
    for loop iterates through formatted string and Stack
        if statement checks current char != Stack peek
            return false
        remove from Stack
    return true
    */
    
    /*
    public boolean isPalindrome(String s) {
        String format = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                format = format + s.charAt(i);
            }
        }
        format = format.toLowerCase();
        Stack<Character> backwards = new Stack<>();
        for (int i = 0; i < format.length(); i++) {
            backwards.push(format.charAt(i));
        }
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) != backwards.peek()) {
                return false;
            }
            backwards.pop();
        }
        return true;
        */

    /* Test
    Input: s = "Pop"
    format = "pop" >> backwards = "pop"
    i = 0 >> "p" == "p" >> backwards = "op"
    i = 1 >> "o" == "o" >> backwards = "p"
    i = 2 >> "p" == "p" >> backwards = ""
    Output: true
        
    Input: s = "Race a Car"
    format = "raceacar" >> backwards = "racaecar"
    ... "e" != "a"
    Output: false

    Input: s = " "
    format = "" >> backwards = ""
    Output: false
    */

    /* Optimize
    O(n) runtime, iterates through separate for loops based on given String length
    O(n) space, create Stack data structure bassed on given String length
    can be done without creating a data structure for O(1) space
    */

    /* Re-approach
    String stores lowercase, alphanumeric value
    for loop iterates through given string
        if statement checks is letter or digit
            add char to formatted string
    int stores right-hand pointer
    for loop iterates through two pointers in given String
        if statement checks char at left-hand pointer != char at right-hand pointer
            return false
        subtract -1 from right-hand pointer
    return true
    */
    public boolean isPalindrome(String s) {
        String format = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                format = format + s.charAt(i);
            }
        }
        format = format.toLowerCase();
        int right = format.length() - 1;
        for (int left = 0; left <= right; left++) {
            if (format.charAt(left) != format.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }
    /* Re-test
    Input: s = "Pop"
    format = "pop" >> right = 2
    left = 0 >> "p" == "p" >> right = 1
    left = 1 >> "o" == "o" >> right = 0
    Output: true

    Input: s = "Race a Car"
    format = "raceacar" >> right = 7
    left = 0 >> "r" == "r" >> right = 6
    left = 1 >> "a" == "a" >> right = 5
    left = 2 >> "c" == "c" >> right = 4
    left = 3 >> "e" != "a"
    Output: false

    Input: s = " "
    format = "" >> right = -1
    Output: true
    */
}
