class Solution {
    public boolean isAnagram(String s, String t) {
        /* Questions
        Given 2 parameters? (Yes, 2 strings)
        Anagram meaning? (word with same letters in different order)
        Whitespaces included? (Yes, whitespaces may be used in both phrases)
        */
        
        /* Approach
        if statement checks string lengths are not equal
            return false
        map stores letter, count for string1
        map stores letter, count for string2
        for loop iterates through string1 & string2
            if statement checks map contains letter
                increment count
            else
                add letter to map with count 1
        return maps are equal boolean
        */
        
        /*
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sLetters = new HashMap<>();
        Map<Character, Integer> tLetters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sLetters.containsKey(s.charAt(i))) {
                int count = sLetters.get(s.charAt(i));
                sLetters.put(s.charAt(i), count + 1);
            }
            else {
                sLetters.put(s.charAt(i), 1);
            }
            if (tLetters.containsKey(t.charAt(i))) {
                int count = tLetters.get(t.charAt(i));
                tLetters.put(t.charAt(i), count + 1);
            }
            else {
                tLetters.put(t.charAt(i), 1);
            }
        }
        return sLetters.equals(tLetters);
        */
        
        /* Tests
        s = "anagram", t = "nagaram"
        i = 0 >> sLetters = [(a,1)], tLetters = [(n,1)] >> i = 1 >> sLetters = [(a,1),(n,1)], tLetters = [(n,1),(a,1)] >>
        i = 2 >> sLetters = [(a,2),(n,1)], tLetters = [(n,1),(a,1),(g,1)] ... >>
        sLetters = [(a,3),(n,1),(g,1),(r,1),(m,1)], tLetters = [(n,1),(a,3),(g,1),(r,1),(m,1)] >> return true
        */
        
        /* Optimize
        O(n) runtime, iterates through a single for loop
        O(n) space, created 2 additional data structures based on given string lengths
        
       This solution already accounts for follow-up: unicode chars (handling more than 26 chars lowercase alphabet) 
        
        Can also sort chars in both given strings and compare, but takes O(nlogn) runtime
        We can slightly optimize runtime & space to use one map instead by subtracting from count
        
        if statement checks string lengths are not equal
            return false
        map stores letter, count
        for loop iterates through string1 & string2
            if statement checks map contains letter in string1
                increment count
            else
                add letter to map with count 1
            if statement checks map contains letter in string2
                decrement count
            else 
                add letter to map with count -1
        for loop iterates through map chars
            if statement checks char count does not equal 0
                return false
        return true
        */
        
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> occurances = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (occurances.containsKey(s.charAt(i))) {
                int count = occurances.get(s.charAt(i));
                occurances.put(s.charAt(i), count + 1);
            }
            else {
                occurances.put(s.charAt(i), 1);
            }
            if (occurances.containsKey(t.charAt(i))) {
                int count = occurances.get(t.charAt(i));
                occurances.put(t.charAt(i), count - 1);
            }
            else {
                occurances.put(t.charAt(i), -1);
            }
        }
        for (char c : occurances.keySet()) {
            if (occurances.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}