class Solution {
    public boolean isAnagram(String s, String t) {
        /* Clarify
        Anagram: same chars but rearranged in a different order
        Given 2 strings
        Check if one string is an anagram of the other string
        Inputs consist of all lowercase letters
        */

        /* Example
        Input: s = "pot", t = "top"
        Output: return true

        Input: s = "pop", t = "top"
        Output: return false
        */

        /* Approach
        Hash Map: O(n) runtime, O(n) space
        if statement checks string lengths not equal
            return false
        HashMap stores char letter, int count
        for loop iterates through every char in string s
            if statement checks letter is in map
                increment letter count
            else
                add letter to map with count 1
        for loop iterates through every char in string t
            if statement checks letter is in map
                decrement letter count
            else
                return false
        for loop iterates through each letter in map keyset
            if statement checks letter count != 0
                return false
        return true
        */

        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (letters.containsKey(s.charAt(i))) {
                int count = letters.get(s.charAt(i));
                letters.put(s.charAt(i), count + 1);
            }
            else {
                letters.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (letters.containsKey(t.charAt(i))) {
                int count = letters.get(t.charAt(i));
                letters.put(t.charAt(i), count - 1);
            }
            else {
                return false;
            }
        }
        for (char c : letters.keySet()) {
            if (letters.get(c) != 0) {
                return false;
            }
        }
        return true;

        /* Test
        Input: s = "pot", t = "top"
        i = 0 >> letters = [('p',1)] >> ... >> i = 2 >> letters = [('p',1),('o',1),('t',1)]
        i = 0 >> letters = [('p',1),('o',1),('t',0)] >> ... >> i = 2 >> letters = [('p',0),('o',0),('t',0)]
        Output: return true

        Input: s = "pop", t = "top"
        i = 0 >> letters = [(p,1)] >> ... i = 2 >> letters = [(p,2),('o',1)]
        i = 0 >> letters !contain 't'
        Output: return false
        */
    }
}