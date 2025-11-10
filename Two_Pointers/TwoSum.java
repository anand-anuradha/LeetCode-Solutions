/*
Problem: Two Sum II - Input Array Is Sorted
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Approach:
- Used a two-pointer technique:
   - Initialized 'left' pointer at the start of the array.
   - Initialized 'right' pointer at the end of the array.
- While left < right:
   - Calculate the sum of numbers[left] + numbers[right].
   - If sum > target, decrement the 'right' pointer to reduce the sum.
   - If sum < target, increment the 'left' pointer to increase the sum.
   - If sum == target, return the 1-indexed positions [left+1, right+1].
- Since exactly one solution exists, the loop will always find the answer.

Why this is optimal:
- Leverages the sorted property of the array.
- Uses two pointers to find the solution in a single pass.
- No extra space is needed, meets the O(1) space requirement.

Time Complexity: O(n)
- Each element is visited at most once by the two pointers.

Space Complexity: O(1)
- Only pointer variables are used; no additional data structures.
*/

package twoPointers;

public class TwoSum {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right= numbers.length - 1;

            while(left < right){
                if(numbers[left] + numbers[right] > target){
                    right = right - 1;
                }
                else if(numbers[left] + numbers[right] < target){
                    left = left+1;
                }
                else{
                    return new int[]{left+1, right+1};
                }
            }

            return null;
        }
}
