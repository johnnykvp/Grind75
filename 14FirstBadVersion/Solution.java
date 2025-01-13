/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /* Clarify
    all versions after a bad version are also bad
    given an API which returns whether given version is bad
    return the first bad version
    minimize the number of API calls
    Is the very first version 0 or 1? (First version is 1)
    */

    /* Approach
    binary search - divide in half until good version next to bad version
    int stores left and right pointers
    while loop iterates when left <= right
        int stores halfway distance = (right - left) / 2
        int stores mid value = left + halfway
        if statement checks mid is bad version (we don't know target val)
            set right = mid - 1 (closes gap on bad version side)
        else
            set left = mid + 1 (closes gap on good version side)
    return left (right will eventually be good version next to bad version)
    */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int halfway = (right - left) / 2;
            int mid = left + halfway;
            if (isBadVersion(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    /* Test
    Input: n = 5, bad = 4
    left = 1, right = 5
    1 <= 5 >> halfway = (5 - 1) / 2 = 2 >> mid = 1 + 2 = 3
    isBadVersion(3) = false >> left = 3 + 1 = 4, right = 5
    4 <= 5 >> halfway = (5 - 4) / 2 = 0 >> mid = 4 + 0 = 4
    isBadVersion(4) = true >> right = 5 - 1 = 4, left = 4
    4 <= 4 >> halfway = (4 - 4) / 2 = 0 >> mid = 4 + 0 = 4
    isBadVersion(4) = true >> right = 4 - 1 = 3, left = 4
    4 !<= 3
    Output: 4

    Input: n = 1, bad = 1
    left = 1, right = 1
    1 <= 1 >> halfway = (1 - 1) / 2 = 0 >> mid = 1 + 0 = 1
    isBadVersion(1) = true >> right = 1 - 1 = 0, left = 1
    1 !<= 0
    Output: 1
    */

    /* Optimize
    O(logn) runtime, iterates through while loop constantly divided in half
    O(1) space, no additional data structures created
    */
}