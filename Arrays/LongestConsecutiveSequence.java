/*
Problem: Longest Consecutive Sequence
Link: https://leetcode.com/problems/longest-consecutive-sequence/

Approach:
- We insert all numbers from the input array into a HashSet for constant-time lookups.
- Then, we iterate through each number in the HashSet and check if it can be the start of a sequence.
    1. A number `num` is considered the start only if `num - 1` does NOT exist in the set.
    2. This ensures that we only build sequences from true starting points.
- For each valid starting point, we continuously check `num + 1`, `num + 2`, etc. while they exist in the set and count the length of the consecutive chain.
- Keep track of the maximum sequence length found.

Why this is optimal:
- We only explore each number once through the HashSet, avoiding repeated scanning.
- We do not sort the array (sorting would cost O(n log n), violating constraints).
- Each consecutive element is checked once due to set-based membership checks.

Time Complexity:
- O(n), because each number is processed only once and lookups in HashSet are O(1).

Space Complexity:
- O(n), due to storing unique elements inside the HashSet.
*/

package arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0){
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        for(int num:numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            else{
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }

                longestSub = Math.max(longestSub, currentSub);
            }
        }
        return longestSub;
    }
}
