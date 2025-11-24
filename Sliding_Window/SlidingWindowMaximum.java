/*
Problem: Sliding Window Maximum
Link: https://leetcode.com/problems/sliding-window-maximum/

Approach:
- Used a Deque (double-ended queue) to maintain indices of useful elements in the current window.
- The deque always stores indices in decreasing order of their values in nums[]:
    - The front of the deque always holds the index of the maximum element for the current window.
- For each index i:
    1. Remove indices from the front that are outside the current window (i - k + 1).
    2. Remove indices from the back whose corresponding values are smaller than nums[i] because they cannot be part of the maximum for future windows.
    3. Add the current index i to the deque.
    4. Once we've formed the first full window (i >= k - 1), record the maximum value (nums[deque.peek()]) into the result array.

Why this is optimal:
- Each element is pushed and popped from the deque at most once.
- The deque always contains potential elements for the maximum, eliminating unnecessary comparisons.
- Avoids the brute-force O(n * k) approach of checking every window individually.
- This monotonic deque technique ensures linear time complexity.

Time Complexity: O(n)
- Each index is processed at most twice (added once, removed once).

Space Complexity: O(k)
- The deque holds at most k elements — the size of one window.
*/

package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offer(i);

            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}
