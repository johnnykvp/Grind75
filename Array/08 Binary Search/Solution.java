class Solution {
    public int search(int[] nums, int target) {
        /* Questions
        Given 2 parameters? (Yes, int array & int)
        Given array sorted? (Yes, ascending order)
        */

        /* Approach
        int 2 pointers iterate through array nums
        while loop iterates until left index > right index
            if statement checks left or right equals target
                return left or right
        return -1
        */

        /*
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
        }
        return -1;
        */

        /* Optimize
        O(n) runtime, iterates through single while loop
        O(1) space, no additional data structures created

        More efficient than a single pointer loop through one by one, but still very slow... Not taking advantage of sorted
        Need to use binary search to search in halves to reach O(logn)

        int 2 pointers iterate through array nums
        int stores mid index
        while loop iterates until low index >= high index
            set mid to (low + high) / 2
            if statement checks mid = target
                return mid index
            if statement checks mid < target
                increase low num to mid + 1
            if statement checks mid > target
                decrease high num to mid - 1
        return -1
        */

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        // When equal, it will loop over & over
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;

        /* Tests
        nums = [1,2,3,4], target = 3
        low = 0, high = 3 >> low 0 < high 3 >> mid = 3 / 2 = 1 >> mid[1] = 2 < target 3 >> low = 2 >>
        low 2 < high 3 >> mid = 2 + 3 = 5 / 2 = 2 >> mid[2] = 3 == target 3 >> return 2
        */
    }
}
