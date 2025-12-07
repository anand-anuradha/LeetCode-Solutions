/*
Problem: Search in Rotated Sorted Array
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

Approach:
- The array is originally sorted but may be rotated at an unknown pivot.
- At any point during binary search, at least one half (left or right) will always be sorted.
- After computing mid:
    - Check if nums[mid] is the target.
    - Determine which half is sorted:
        - If nums[left] <= nums[mid], the left half is sorted.
          Check if the target lies within this sorted range.
          If yes → search left half; otherwise → search right half.
        - Otherwise, the right half is sorted.
          Check if the target lies within that sorted range.
          If yes → search right half; otherwise → search left half.
- This ensures the search space is cut in half every iteration while accounting for rotation.

Why this is optimal:
- The approach exploits the rotated + sorted structure to maintain binary search behavior.
- Avoids linear scanning by always eliminating one full half based on sorted boundaries.

Time Complexity: O(log n)
- Binary search shrinks the interval by half each iteration.

Space Complexity: O(1)
- No extra memory used beyond pointers.
*/

package binarySearch;

public class SearchInRotatedSortedArray {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while(left <= right){
                int mid = (left+right)/2;
                if(nums[mid] == target){
                    return mid;
                }

                if(nums[left] <= nums[mid]){
                    if(target < nums[left] || target > nums[mid]){
                        left = mid+1;
                    }
                    else{
                        right = mid-1;
                    }
                }
                else{
                    if(target > nums[right] || target < nums[mid]){
                        right = mid-1;
                    }
                    else{
                        left = mid+1;
                    }
                }
            }

            return -1;
        }
}
