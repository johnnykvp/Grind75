class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* Clarify
        Given int array, int target
        Return indicies int array, that sums up to target
        Can there be no solution? No, assume there is exactly one solution
        Can there be more than one solution? No
        Cannot use the same index value twice
        Duplicate values allowed? Yes, can have duplicate values that sum up to target
        */

        /* Example
        Input: nums = [2,7,11], target = 9
        2 + 7 = 11 >> indicies 0, 1
        Output: return [0,1]

        Input: nums = [3,1,3], target = 6
        3 + 3 = 6 >> indicies 0, 2
        Output: return [0,2]
        */

        /* Approach
        Nested For Loop: O(n^2) runtime, O(1) space
        for loop iterates through every int in array nums
            for loop iterates through every next int in array nums
                if statement checks first int + second int = sum
                    return first index, second index
        return null
        */

        /* Optimize
        Hash Map: O(n) runtime, O(n) space
        HashMap stores nums as keys, indicies as values (store indicies as values since we are returning it)
        for loop iterates through every int in array nums
            if statement checks target - current num is already in the map
                return first index, current index
            add num, index to map
        return null
        */

        HashMap<Integer, Integer> indicies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indicies.containsKey(target - nums[i])) {
                return new int[] {indicies.get(target - nums[i]), i};
            }
            indicies.put(nums[i], i);
        }
        return null;

        /* Test
        Input: nums = [2,7,11], target = 9
        i = 0; 0 < 3 
            9 - 2 = 7 !contains 7
            indicies = [(2,0)]
        i = 1; 1 < 3
            9 - 7 = 2 contains 2
        Output: return [0,1]

        Input: nums = [3,1,3], target = 6
        i = 0; 0 < 3
            6 - 3 = 3 !contains 3
            indicies = [(3,0)]
        i = 1; 1 < 3
            6 - 1 = 5 !contains 5
            indicies = [(3,0),(1,1)]
        i = 2; 2 < 3
            6 - 3 = 3 contains 3
        Output: return [0,2]
        */
    }
}