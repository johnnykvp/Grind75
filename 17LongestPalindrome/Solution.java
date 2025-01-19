class Solution {
    /* Clarify
    given a string which can have lowercase and uppercase letters
    determine the longest palindrome that can be made with the letters
    return int for the longest length
    palindrome: same chars forwards and backwards
    this function is case sensitive, "Aa" is not a palindrome
    odd counts of a single letter can contribute to a palindrome, "aaa"
    */

    /* Approach
    Set stores single occurances of a letter
    int stores result length
    for loop iterates through each char in given String
        if char is already in Set
            add 2 to result length
            remove char from Set
        else
            add char to Set
    if statement checks Set is not empty
        return result length + 1 for odd letter
    return result length
    */
    public int longestPalindrome(String s) {
        Set<Character> occurance = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (occurance.contains(s.charAt(i))) {
                longest = longest + 2;
                occurance.remove(s.charAt(i));
            }
            else {
                occurance.add(s.charAt(i));
            }
        }
        if (!occurance.isEmpty()) {
            return longest + 1;
        }
        return longest;
    }
    /* Test
    Input: s = "abccccdd"
    i = 0 >> occurance = [a] >> i = 1 >> occurance = [a,b]
    i = 2 >> occurance = [a,b,c] >> i = 3 >> longest = 2, occurance = [a,b]
    i = 4 >> occurance = [a,b,c] >> i = 5 >> longest = 4, occurance = [a,b]
    i = 6 >> occurance = [a,b,d] >> i = 7 >> longest = 6, occurance = [a,b]
    occurance !empty >> longest 6 + 1 = 7
    Output: 7

    Input: s = "Aa"
    i = 0 >> occurance = [A] >> i = 1 >> occurance = [A,a]
    occurance !empty >> longest 0 + 1 = 1
    Output: 1

    Input: "aaa"
    i = 0 >> occurance = [a] >> i = 1 >> longest = 2, occurance = []
    i = 2 >> occurance = [a]
    occurance !empty >> longest 2 + 1 = 3
    Output: 3
    */

    /* Optimize
    O(n) runtime, iterates through single for loop
    O(n) space, created Set data structure based on given String length
    */
}