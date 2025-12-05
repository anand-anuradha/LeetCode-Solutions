/*
Problem: Find Minimum in Rotated Sorted Array
Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Approach:
- The array is originally sorted but rotated, meaning one part is sorted and the other contains the rotation point.
- The minimum always lies in the unsorted portion or at the boundary.
- Use binary search to progressively eliminate fully sorted halves:
    - If nums[left] < nums[right], the entire segment is sorted → the leftmost element is the minimum.
    - Otherwise, compute mid and update the minimum candidate.
    - If left half is sorted, discard it and search the right half.
    - If left half is not sorted, the rotation point lies there → search the left half.
- Continue until the search space is exhausted, keeping track of the minimum found.

Why this is optimal:
- By leveraging the sorted + rotated structure, binary search efficiently narrows down the location of the minimum.
- This eliminates the need to scan the array linearly and ensures logarithmic search time.

Time Complexity: O(log n)
- Binary search repeatedly halves the search space.

Space Complexity: O(1)
- No extra data structures used.
*/

package binarySearch;

public class FindMinimumInRotatedSortedArray {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length -1;
            int ans = nums[0];

            while(left <= right){
                if(nums[left] < nums[right]){
                    ans = Math.min(ans, nums[left]);
                }
                int mid = (left + right)/2;
                ans = Math.min(ans, nums[mid]);

                if(nums[left] <= nums[mid]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
}
