/*
Problem: Best Time to Buy and Sell Stock
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Approach:
- Maintain a variable 'min' to store the lowest stock price seen so far.
- As we iterate through the array:
    - Update 'min' whenever a new lower price is found (best day to buy).
    - For each day, calculate the potential profit: prices[i] - min.
    - Update the maximum profit whenever a higher profit is found.
- This ensures we always buy before we sell, as 'min' only comes from earlier days.

Why this is optimal:
- Each price is processed exactly once in a single linear scan.
- There is no need for nested loops or additional arrays.
- Logic directly follows the rule:
    "To maximize profit, buy at the lowest value before the current day and sell at the highest value after."

Time Complexity: O(n)
- Only one pass through the array is required.

Space Complexity: O(1)
- Only constant extra variables are used.
*/


package slidingWindow;

public class BestTimeToBuyAndSellStock {
        public int maxProfit(int[] prices) {

            int min = prices[0];
            int profit = 0;

            for(int i=0; i<prices.length; i++){
                if(min > prices[i]){
                    min = prices[i];
                }
                profit = Math.max(profit, prices[i]-min);
            }

            return profit;
        }
}
