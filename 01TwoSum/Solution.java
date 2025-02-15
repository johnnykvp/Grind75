class Solution {
    /* Clarify
    given int[] and single int
    return index of two nums that add to target as int[]
    can there be more than one solution? (no, just one solution)
    can the same element be used twice? (no, element can only be used once)
    can there be duplicate nums in array? (yes, may have duplicate nums)
    */

    /* Approach
    HashMap stores key: num, value: index (index is the value because we want it as output later)
    iterate through nums[] using single for loop
        if statement checks target - current index value = num is already in the map
            return new int[] with the num already in map, and current index value
        else
            add mapping num and index
    return null if no solution is found
    */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return null;
    }
    /* Test
    Input: nums = [2,7,11,15], target = 9
    i = 0 >> 9 - 2 = 7 >> numToIndex !contains 7 >> numToIndex = [(2,0)]
    i = 1 >> 9 - 7 = 2 >> numToIndex contains 2
    Output: [0,1]

    Input: nums = [6,3,3], target = 6
    i = 0 >> 6 - 6 = 0 >> numToIndex !contains 0 >> numToIndex = [(6,0)]
    i = 1 >> 6 - 3 = 3 >> numToIndex !contains 3 >> numToIndex = [(6,0),(3,1)]
    i = 2 >> 6 - 3 = 3 >> numToIndex contains 3
    Output: [1,2]
    */

    /* Optimize
    O(n) runtime, iterates through for loop based on given array length
    O(n) space, create HashMap data structure based on given array length
    */
}