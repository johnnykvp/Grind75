class Solution {
    public int maxProfit(int[] prices) {
        /* Clarify.
        given int array that stores stock prices, where index represents day
        goal is to get max profit by choosing a single day to buy stock, and another day to sell in the future
        return int max profit amount
        if no profit is possible, return 0
        */

        /* Example
        Input: prices = [7,1,6,4]
        buy when price is 1, sell when price is 6
        Output: 5

        Input: prices = [2,4,1] (lowest price at end)
        buy when price is 2, sell when price is 4
        Output: 2

        Input: prices = [7,6,4]
        prices only decrease
        Output: 0
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

        /* Test
        Input: prices = [7,1,6,4]
        7 - int max !> 0 >> minPrice = 7
        1 - 7 !> 0 >> minPrice = 1
        6 - 1 > 0 >> maxProfit = 5 >> 6 !< 1
        4 - 1 !> 5 >> 4 !< 1 >> return 5

        Input: prices = [2,4,1]
        2 - int max !> 0 >> minPrice = 2
        4 - 2 > 0 >> maxProfit = 2 >> 4 !< 2
        1 - 2 !> 2 >> 1 < 2 >> minPrice = 1 >> return 2

        Input: prices = [7,6,4]
        7 - int max !> 0 >> minPrice = 7
        6 - 7 !> 0 >> minPrice = 6
        4 - 6 !> 0 >> minPrice = 4 >> return 0
        */

        /* Optimize
        O(n) runtime, iterates through single for loop based on given array length
        O(1) space, no additional data structures created
        */
    }
}
