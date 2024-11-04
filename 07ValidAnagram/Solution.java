class Solution {
    /* Clarify
    given two strings
    determine if both strings are anagrams
    anagram: contains all the same chars in different order
    will we need to handle letter casing? (no, all lowercase)
    will we need to handle non-alphabetic chars? (no, just alphabet)
    if both strings are the same, is it an anagram? (yes)
    */

    /* Approach
    if statement checks both strings are different lengths
        return false
    HashMap stores key: chars in String s, value: count
    for loop iterates through String s and String t
        if statement checks String s char is already in map
            add 1 to char count
        else
            add letter to map with count 1
        if String t char is already in map
            subtract 1 to char count
        else
            add letter to map with count -1
    for loop iterates through map values
        if statement checks char count != 0
            return false
    return true
    */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> letterCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (letterCount.containsKey(s.charAt(i))) {
                int count = letterCount.get(s.charAt(i));
                // count++ (post-increment) will not work here
                letterCount.put(s.charAt(i), count + 1);
            }
            else {
                letterCount.put(s.charAt(i), 1);
            }
            if (letterCount.containsKey(t.charAt(i))) {
                int count = letterCount.get(t.charAt(i));
                letterCount.put(t.charAt(i), count - 1);
            }
            else {
                letterCount.put(t.charAt(i), -1);
            }
        }
        for (int x : letterCount.values()) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
    /* Test
    Input: s = "anag", t = "naga"
    i = 0 >> letterCount = [(a,1),(n,-1)]
    i = 1 >> letterCount = [(a,0),(n,0)]
    i = 2 >> letterCount = [(a,1),(n,0),(g,-1)]
    i = 3 >> letterCount = [(a,0),(n,0),(g,0)]
    Output: true

    Input: s = "rat", t = "car"
    i = 0 >> letterCount = []
    letterCount = [(r,1),(a,1),(t,1)]
    letterCount !contain 'c'
    Output: false

    Input: s = "cart", t = "car"
    letterCount = [(c,1),(a,1),(r,1),(t,1)]
    letterCount = [(c,0),(a,0),(r,0),(t,1)]
    Output: false
    */

    /* Optimize
    O(n) runtime, separate for loops based on given string length
    O(n) space, create HashMap based on given string length
    */
}