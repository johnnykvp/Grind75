class Solution {
    /* Clarify
    given sorted int array and int target
    search for the int target inside the int array
    return the found target index, -1 if not found
    binary search: start with the mid num, continuously divide array in half
    */

    /* Approach
    int stores left, right pointers
    while loop iterates through when left <= right
        int stores halfway distance = (right - left) / 2
        int stores mid pointer = left + halfway distance
        if statement checks mid value = target
            return mid index
        if statement checks mid < target
            set left pointer to mid + 1
        if statement checks mid > target
            set right pointer to mid - 1
    return - 1
    */
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int halfway = (rightIndex - leftIndex) / 2;
            int midIndex = leftIndex + halfway;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            if (nums[midIndex] < target) {
                leftIndex = midIndex + 1;
            }
            if (nums[midIndex] > target) {
                rightIndex = midIndex - 1;
            }
        }
        return -1;
    }
    /* Test
    Input: nums = [-1,0,3,5,9,12], target = 9
    rightIndex = 5 >> leftIndex 0 < rightIndex 5
    halfway = 5 / 2 = 2 >> midIndex = 2 >> midVal = 3 < target 9
    leftIndex = 3 >> leftIndex 3 < rightIndex 5
    halfway = 2 / 2 = 1 >> midIndex = 4 >> midVal = 9 == target 9
    Output: 4

    Input: nums = [-1,0,3,5,9,12], target = 2
    rightIndex = 5 >> leftIndex 0 < rightIndex 5
    halfway = 5 / 2 = 2 >> midIndex = 2 >> midVal 3 > target 2
    rightIndex = 1 >> leftIndex 0 < rightIndex 1
    halfway = 1 / 2 = 0 >> midIndex = 0 >> midVal -1 < target 2
    leftIndex = 1 >> leftIndex 1 == rightIndex 1
    Output: -1
    */

    /* Optimize
    O(logn) runtime, binary search continuously cuts the given array length range in half
    O(1) space, no additional data structures created
    */
}