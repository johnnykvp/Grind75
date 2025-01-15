class Solution {
    /* Clarify
    given two strings: ransomNote and magazine
    if ransomNote can be constructed by using letters from magazine, return true
    otherwise, ransomNote cannot be constructed from magazine, return false
    are there any non-alphabet chars? (No, will be all alphabet)
    do we need to handle uppercase chars? (No, will be all lowercase)
    */

    /* Approach
    HashMap stores letters, count
    for loop iterates through magazine chars
        if statement checks char is already in map
            add char and increment count
        else
            add char to map with count 1
    for loop iterates through ransomNote chars
        if statement checks current ransomNote char is not found in map
            return false
        if statement checks current ransomNote char is found in map && char count == 0
            return false
        else
            subtract char count - 1
    return true
    */
    /*
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> letterCounts = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (letterCounts.containsKey(magazine.charAt(i))) {
                int count = letterCounts.get(magazine.charAt(i));
                letterCounts.put(magazine.charAt(i), count + 1);
            }
            else {
                letterCounts.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!letterCounts.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            if (letterCounts.containsKey(ransomNote.charAt(i)) && letterCounts.get(ransomNote.charAt(i)) == 0) {
                return false;
            }
            else {
                int count = letterCounts.get(ransomNote.charAt(i));
                letterCounts.put(ransomNote.charAt(i), count - 1);
            }
        }
        return true;
    }
    */
    /* Test
    Input: ransomNote = "a", magazine = "b"
    letterCounts = [(b,1)]
    letterCounts !contain 'a'
    Output: false

    Input: ransomNote = "aa", magazine = "ab"
    letterCounts = [(a,1),(b,1)]
    letterCounts contain 'a' && count = 1 >> letterCounts = [(a,0),(b,1)]
    letterCounts contain 'a' && count = 0
    Output: false

    Input: ransomNote = "aa", magazine = "aab"
    letterCounts = [(a,2),(b,1)]
    letterCounts contain 'a' && count = 2 >> letterCounts = [(a,1),(b,1)]
    letterCounts contain 'a' && count = 1 >> letterCounts = [(a,0),(b,1)]
    Output: true
    */

    /* Optimize
    O(n) runtime, iterates through for loop based on given String size
    O(n) space, create HashMap based on given String size
    We could reduce to O(1) space by creating int[] array with fixed alphabet size 26
    But need to find the index for each letter, using ASCII values (current char - 'a')
    */

    /* Re-approach
    int[] array stores 26 slots for the alphabet
    for loop iterates through each char in magazine
        set index current char - 'a' = current index value + 1
    for loop iterates through each char in ransomNote
        if statement checks index of current char - 'a' == 0
            return false
        decrement value at current char index by 1
    return true
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int current = magazine.charAt(i) - 'a';
            letterCount[current] = letterCount[current] + 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int current = ransomNote.charAt(i) - 'a';
            if (letterCount[current] == 0) {
                return false;
            }
            letterCount[current] = letterCount[current] - 1;
        }
        return true;
    }
    /* Re-test
    Input: ransomNote = "a", magazine = "b"
    (magazine) current = 'b' - 'a' = 1 >> letterCount[1] = 1
    (ransomNote) current = 'a' - 'a' = 0 >> letterCount[0] == 0
    Output: false

    Input: ransomNote = "aa", magazine = "ab"
    (magazine) current = 'a' - 'a' = 0 >> letterCount[0] = 1
    current = 'b' - 'a' = 1 >> letterCount[1] = 1 >> letterCount[1,1,0...]
    (ransomNote) current = 'a' - 'a' = 0 >> letterCount[0] = 1 - 1 = 0
    current = 'a' - 'a' = 0 >> letterCount[0] == 0
    Output: false

    Input: ransomNote = "aa", magazine = "aab"
    (magazine) current = 'a' - 'a' = 0 >> letterCount[0] = 1
    current = 'a' - 'a' = 0 >> letterCount[0] = 1 + 1 = 2
    current = 'b' - 'a' = 1 >> letterCount[1] = 1
    (ransomNote) current = 'a' - 'a' = 0 >> letterCount[0] = 2 - 1 = 1
    current = 'a' - 'a' = 0 >> letterCount[0] = 1 - 1 = 0
    Output = true 
    */
}