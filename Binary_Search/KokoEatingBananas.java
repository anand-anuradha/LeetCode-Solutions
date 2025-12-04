/*
Problem: Koko Eating Bananas
Link: https://leetcode.com/problems/koko-eating-bananas/

Approach:
- The key insight is that the answer (minimum eating speed k) lies within a monotonic range:
  if Koko can finish at speed k, she can also finish at any speed > k.
- This allows binary search on the speed range [1, max(piles)].
- For each trial speed, we compute how many hours Koko needs to finish all piles.
- Using the formula ceil(pile / k) ensures we account for partial hours correctly.
- If the total hours are within h, the speed is feasible - so try a smaller speed.
- If not, increase the speed.
- The first feasible speed found through binary search is the minimum valid k.

Why this is optimal:
- Instead of checking all speeds one by one, binary search reduces the search to logarithmic steps.
- Each feasibility check is linear over the piles.
- This matches the optimal time complexity for monotonic search problems.

Time Complexity: O(n * log(maxPile))
- n from checking all piles.
- log(maxPile) from binary searching k.

Space Complexity: O(1)
- No extra data structures used.
*/

package binarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1;
            int high = Arrays.stream(piles).max().getAsInt();  // max bananas in any pile

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (canFinish(piles, h, mid)) {
                    // Koko can finish at this speed, try slower
                    high = mid;
                } else {
                    // Can't finish, need faster speed
                    low = mid + 1;
                }
            }
            return low;  // minimum speed to finish in h hours
        }

        // Helper method to check if Koko can finish all piles at speed k within h hours
        private static boolean canFinish(int[] piles, int h, int k) {
            int hoursNeeded = 0;
            for (int pile : piles) {
                // hours needed for this pile = ceil(pile / k)
                hoursNeeded = hoursNeeded + (pile + k - 1) / k;  // integer division ceiling trick
                if (hoursNeeded > h) {
                    return false;  // already exceeded, no need to continue
                }
            }
            return true;
        }
}
