class Solution {
    public int maxProfit(int[] prices) {
        /* Questions
        Given 1 parameter? (Yes, array)
        Given array sorted? (No, stocks will be varying prices)
        Max difference in whole array? (No, future value differences only)
        */
        
        /* Approach
        int stores max profit
        for loop iterates through array prices
            for loop iterates through next prices
                if statement checks current difference greater than max profit stored
                    set max profit to current difference
        return max profit
        */
        
        /*
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
        */
        
        /* Tests
        prices = [7,1,5,3,6,4]
        i = 0 >> j = 1, 1 - 7 = -6 >> j = 2, 5 - 7 = -2 >> etc.
        i = 1 >> j = 2, 5 - 1 = 4, maxProfit = 4 >> j = 3, 3 - 1 = 2 >> j = 4, 6 - 1 = 5, maxProfit = 5, j = 5, 4 - 1 = 3
        i = 2 >> etc. ... >> return 5
        */
        
        /* Optimize
        O(n^2) runtime, iterates through nested for loops
        O(1) space, no additional data structures created
        
        int stores max profit
        int stores lowest price so far
        for loop iterates through array prices
            if statement checks current price is lower than lowest price
                set lowest price to current price
            if statement checks current price - lowest price > max profit
                set max profit to current price - lowest price
        return max profit
        
        O(n) runtime, iterates through single for loop
        O(1) space, no additional data structures created
        */
        
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            if (prices[i] - lowest > maxProfit) {
                maxProfit = prices[i] - lowest;
            }
        }
        return maxProfit;
        
        /* Tests
        prices = [7,1,5,3,6,4]
        i = 0 >> lowest = 7, 7 - 7 = 0, maxProfit = 0 >> i = 1 >> lowest = 1, 1 - 1 = 0, maxProfit = 0
        i = 2 >> lowest = 1, 5 - 1 = 4, maxProfit = 4 >> i = 3 >> lowest = 1, 3 - 1 = 2
        i = 4 >> lowest = 1, 6 - 1 = 5, maxProfit = 5 >> i = 5 >> lowest = 1, 4 - 1 = 3 >> return 5
        
        prices = [7,6,4,3,1]
        i = 0 >> lowest = 7, maxProfit = 0 >> i = 1 >> lowest = 6, maxProfit = 0
        i = 2 >> lowest = 4, maxProfit = 0 >> i = 3 >> lowest = 3, maxProfit = 0
        i = 4 >> lowest = 1, maxProfit = 0 >> return 0
        */
    }
}
