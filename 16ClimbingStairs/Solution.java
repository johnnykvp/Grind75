class Solution {
    /* Clarify
    given int n representing total steps in stairs
    can climb 1 or 2 steps at a time
    determine how many possible ways to climb to the top
    notice how each step's possible ways are the sum of the previous two step's possible ways (fibonacci sequence)
    */

    /* Approach
    recursively iterate through n steps based on fibonacci sequence (previous 2 steps sum up to current step)
    int[] array memoization stores the possible ways to climb to step n (starting at 0 and ending at n - 1)
    
    helper method takes parameters int current step, int[] possible ways
    base case if statement checks step 1
        set int[0] to 1 possible way
    base case if statement checks step 2
        set int[1] to 2 possible ways
    if statement checks current step does not have a value assigned already for possible ways (== 0)
        set current step int[n - 1] to recursive call on helper(n - 1) + helper(n - 2) applying fibonacci formula
    return int[n - 1] possible ways
    */
    public int climbStairs(int n) {
        int[] possibleWays = new int[n];
        // Step 1 is at index 0, Step n is at index n - 1
        return climbStairs(n - 1, possibleWays);
    }

    private int climbStairs(int n, int[] possibleWays) {
        if (n == 0) {
            possibleWays[0] = 1;
        }
        if (n == 1) {
            possibleWays[1] = 2;
        }
        if (possibleWays[n] == 0) {
            possibleWays[n] = climbStairs(n - 1, possibleWays) + climbStairs(n - 2, possibleWays);
        }
        return possibleWays[n];
    }
    /* Test
    Input: n = 3
    possibleWays[0,0,0] >> climbStairs(3 - 1)
    possibleWays[2] == 0 >> climbStairs(1) + climbStairs(0)
    possibleWays[1] = 2 >> possibleWays[0] = 1 >> possibleWays[2] = 2 + 1 = 3
    Output: 3

    Input: n = 5
    possibleWays[0,0,0,0,0] >> climbStairs(5 - 1)
    possibleWays[4] == 0 >> climbStairs(3) + climbStairs(2)
    possibleWays[3] == 0 >> climbStairs(2) + climbStairs(1)
    possibleWays[2] == 0 >> climbStairs(1) + climbStairs(0)
    possibleWays[1] = 2 >> possibleWays[0] = 1 >> possibleWays[2] = 2 + 1 = 3
    possibleWays[3] = 3 + 2 = 5 >> possibleWays[4] = 5 + 3 = 8
    Output: 8
    */

    /* Optimize
    O(n) runtime, iterates through n steps without repeating any calculations
    O(n) space, created array with size based on given n steps
    possible without any additional data structures
    */

    /* Re-approach
    base case if statement checks step 1
        return 1
    base case if statement checks step 2
        return 2
    int stores previous possible ways, set to 1
    int stores current possible ways, set to 2
    for loop iterates through all steps starting at step 3
        int temp stores value of current
        set current to previous + current (fibonacci sum of last two values)
        set previous to temp
    return current possible ways
    */

    /*
    public int climbStairs(int n) {
        // If zero is in constraints, we could do base case return 0
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int prev = 1;
        int curr = 2;
        for (int i = 3; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
    */

    /* Re-Test
    Input: n = 3
    3 <= 3 >> temp = 2 >> curr = 1 + 2 = 3 >> prev = 2
    Output: 3

    Input: n = 5
    3 <= 5 >> temp = 2 >> curr = 1 + 2 = 3 >> prev = 2
    4 <= 5 >> temp = 3 >> curr = 3 + 2 = 5 >> prev = 3
    5 <= 5 >> temp = 5 >> curr = 5 + 3 = 8 >> prev = 5
    Output: 8
    */
}