/*
Problem: Container With Most Water
Link: https://leetcode.com/problems/container-with-most-water/

Approach:
- Used the two-pointer technique starting with one pointer at the beginning (left) and one at the end (right) of the array.
- The area formed by the lines at these two pointers is determined by:
    area = (right - left) * min(height[left], height[right])
- Update the maximum area found so far.
- Move the pointer pointing to the shorter line inward, since moving the taller line cannot increase the area.
- Continue this process until both pointers meet.

Why this is optimal:
- Every possible container is effectively considered in one linear pass by intelligently moving the pointers.
- The two-pointer method avoids the O(n^2) brute-force comparison of all line pairs.

Time Complexity: O(n)
- Each pointer moves at most n steps, resulting in a single linear traversal.

Space Complexity: O(1)
- Only constant extra space is used for variables.
*/

package twoPointers;

public class ContainerWithMostWater {
        public int maxArea(int[] height) {
            int max = 0;
            int left = 0;
            int right = height.length - 1;

            while (left<right){

                int width = Math.min(height[left], height[right]);
                int length = right - left;

                max = Math.max(max, width*length);

                if(height[left] < height[right]){
                    left++;
                }
                else{
                    right--;
                }
            }

            return max;
        }
}
