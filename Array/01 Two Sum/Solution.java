class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* Questions
        Two parameters? (Yes, int array & int)
        Return array? (Yes, the 2 indicies, not num values)
        Duplicate values present? (Yes, may include)
        Given a sorted array? (No, may be in any order)
        Multiple solutions? (No, one solution)
        Can we use same element twice? (No, only once)
        */
        
        /* Approach
        for loop iterates through array nums
            for loop iterates through next array nums
                if statement checks num1 + num2 = target
                    return num1, num2
        */
        
        /*
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
        */
        
        /* Tests
        nums = [2,7,11,15], target = 9
        i = 0 >>  nums[0] = 2, nums[1] = 7 >> 2 + 7 == 9 >> return [0,1]
        */
            
        /* Optimize
        O(n^2) runtime, iterating through nested for loops
        O(1) space, no additional data structures created
        
        map stores num value, index
        for loop iterates through array nums
            add num value, index to map
        for loop iterates through array nums
            if statement checks target - current num exists in map
                return current num index, target - current num index
                
        O(n) runtime, iterates through separate for loops
        O(n) space, created map based on given array size
        */
        
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            values.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // Prevent use of same element
            if (values.containsKey(target - nums[i]) && values.get(target - nums[i]) != i) {
                return new int[] {i, values.get(target - nums[i])};
            }
        }
        return null;
            
        /* Tests
        nums = [2,7,11,15], target = 9
        all num values added to map >> [(2,0),(7,1),(11,2),(15,3)]
        i = 0 >> 9 - 2 = 7, map contains 7 >> return [0,1]
        
        nums = [3,2,4], target = 6
        all num values added to map >> [(3,0),(2,1),(4,2)]
        i = 0 >> 6 - 3 = 3, map contains 3, 0 == 0
        i = 1 >> 6 - 2 = 4, map contains 4, 1 != 2 >> return [1,2]
        
        Input: nums = [3,3], target = 6
        all num values added to map >> [(3,1)] duplicate overriden
        i = 0 >> 6 - 3 = 3, map contains 3, 0 != 1 >> return [0,1]
        */
    }
}
