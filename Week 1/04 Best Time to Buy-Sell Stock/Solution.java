class Solution {
    public int maxProfit(int[] prices) {
        /* Clarify
        Given int array of stock prices, where index represents days
        Maximize profit by choosing a day to buy stock & a future day to sell
        Return the max profit possible given the array values
        If no profit is possible, return 0
        */

        /* Example
        Input: prices = [7,1,5,6,4]
        Buy on day 2 (i = 1), when price = 1
        Sell on day 5 (i = 4), when price = 6
        6 - 1 = 5
        Output: return 5

        Input: prices = [7,6,4]
        Output: return 0
        */

        /* Approach
        Nested Loop: O(n^2) runtime, O(1) space
        int stores max profit
        for loop iterates through every int in prices
            for loop iterates through every next int in prices
                if statement checks second price - first price > max profit
                    set max profit = second price - first price
        return max profit

        Single Loop: O(n) runtime, O(1) space
        int stores max profit
        int stores min price
        for loop iterates through every int in prices
            if statement checks current int < min price
                set min price to current int
                continue through loop
            if statement checks current int - min price > max profit
                set max profit to current int - min price
        return max profit
        */

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;

        /* Test
        Input: prices = [7,1,5,6,4]
        i = 0 >> minPrice = 7
        i = 1 >> minPrice = 1
        i = 2 >> 5 - 1 = 4 >> maxProfit = 4
        i = 3 >> 6 - 1 = 5 >> maxProfit = 5
        i = 4 >> 4 - 1 = 3
        Output: return 5

        Input: prices = [7,6,4]
        i = 0 >> minPrice = 7
        i = 1 >> minPrice = 6
        i = 2 >> minPrice = 4
        Output: return 0
        */
    }
}