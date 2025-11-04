/*
Problem: Two Sum
Link: https://leetcode.com/problems/two-sum/

Approach:
- Used a HashMap named 'map' to store numbers and their indices while iterating through 'nums'.
- For each number, calculate its complement as 'remainder = target - nums[i]'.
- Check if 'remainder' exists in 'map':
    - If yes, return indices [map.get(remainder), i].
    - If no, store the current number and its index in 'map'.
- If no pair is found after the loop, return an empty array.

Why this is optimal:
- Time Complexity: O(n), we traverse the array once.
- Space Complexity: O(n), storing at most n elements in the HashMap.
- HashMap allows constant-time lookup of the complement, which makes this approach efficient.
*/

package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();

            for(int i=0; i<nums.length; i++){
                int remainder = target - nums[i];

                if(map.containsKey(remainder)){
                    return new int[] {map.get(remainder),i};
                }

                map.put(nums[i],i);
            }

            return new int[]{};
        }
}
