class Solution {
    /* Clarify
    given int array that stores stock prices, where index represents day
    goal is to get max profit by choosing a single day to buy stock, and another day to sell in the future
    return int max profit amount
    if no profit is possible, return 0
    */

    /* Approach
    int stores max profit
    int stores min price
    for loop iterates through prices array
        if statement checks current price - min price > max profit
            set max profit = current price - min price
        if statement checks current price < min price
            min price = current price
    return max profit
    */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
    /* Test
    Input: prices = [7,1,6,4]
    7 - int max !> 0 >> minPrice = 7
    1 - 7 !> 0 >> minPrice = 1
    6 - 1 > 0 >> maxProfit = 5 >> 6 !< 1
    4 - 1 !> 5 >> 4 !< 1
    Output: 5

    Input: prices = [7,6,4]
    7 - int max !> 0 >> minPrice = 7
    6 - 7 !> 0 >> minPrice = 6
    4 - 6 !> 0 >> minPrice = 4
    Output: 0
        
    Input: prices = [2,4,1] (lowest price at end)
    2 - int max !> 0 >> minPrice = 2
    4 - 2 > 0 >> maxProfit = 2 >> 4 !< 2
    1 - 2 !> 2 >> 1 < 2 >> minPrice = 1
    Output: 2
    */

    /* Optimize
    O(n) runtime, iterates through for loop based on given array length
    O(1) space, no additional data structures created
    */
}