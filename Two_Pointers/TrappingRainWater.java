/*
Problem: Trapping Rain Water
Link: https://leetcode.com/problems/trapping-rain-water/

Approach:
- Used the optimal two-pointer technique with one pointer at the start (left) and another at the end (right) of the height array.
- Maintain two running values:
    leftMax  = maximum height seen so far from the left side
    rightMax = maximum height seen so far from the right side
- At each step:
    - Compare height[left] and height[right].
    - Move the pointer at the smaller height because the trapped water depends on the shorter boundary.
    - If current height is less than its respective max, water can be trapped:
        trapped += (leftMax - height[left])  OR  (rightMax - height[right])
    - Otherwise, update leftMax or rightMax.
- Continue until left and right pointers meet.

Why this is optimal:
- The two-pointer strategy ensures that each index is processed exactly once.
- Avoids the brute-force approach that compares each element with all others.
- Eliminates the need for precomputing leftMax[] and rightMax[] arrays used in O(n) space solutions.

Time Complexity: O(n)
- Both pointers move inward once per iteration, giving a single linear scan.

Space Complexity: O(1)
- Only constant extra variables are used, making it memory efficient.
*/

package twoPointers;

public class TrappingRainWater {
        public int trap(int[] height) {

            int left = 0;
            int right = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            int totalWater = 0;

            while (left < right) {
                if (height[left] < height[right]) {

                    if (height[left] >= leftMax) {

                        leftMax = height[left];

                    } else {
                        totalWater = totalWater + (leftMax - height[left]);
                    }
                    left++;

                } else {

                    if (height[right] >= rightMax) {

                        rightMax = height[right];

                    } else {
                        totalWater = totalWater + (rightMax - height[right]);
                    }
                    right--;
                }
            }
            return totalWater;

        }
}
