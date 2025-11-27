/*
Problem: Binary Search
Link: https://leetcode.com/problems/binary-search/

Approach:
- Since the array is already sorted in ascending order, used the classic Binary Search technique.
- Maintain two pointers:
    - left  → start of the search range
    - right → end of the search range
- At each step:
    1. Compute mid = left + (right - left) / 2 to avoid integer overflow.
    2. If nums[mid] == target → return mid (target found).
    3. If nums[mid] < target → discard the left half by moving left to mid + 1.
    4. If nums[mid] > target → discard the right half by moving right to mid - 1.
- Continue until left exceeds right, which means the target is not present.

Why this is optimal:
- Binary Search divides the search space by half at each step.
- This ensures the required O(log n) runtime.
- No additional space or complex data structures are needed.

Time Complexity: O(log n)
- The search range is halved in every iteration.

Space Complexity: O(1)
- Only a few pointers are used irrespective of input size.
*/


package binarySearch;

public class BinarySearch {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }
}
