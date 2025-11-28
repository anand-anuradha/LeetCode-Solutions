/*
Problem: Search a 2D Matrix
Link: https://leetcode.com/problems/search-a-2d-matrix/

Approach:
- The matrix has two properties:
    1. Each row is sorted in non-decreasing order.
    2. The first element of each row is greater than the last element of the previous row.
- These properties allow us to treat the entire matrix as a single sorted 1D array.
- Use binary search over the virtual index range [0, m*n - 1].
- For a given mid index:
    - Convert it to 2D coordinates using:
        row = mid / n
        col = mid % n
    - Compare matrix[row][col] with the target.
- Adjust the search space just like normal binary search:
    - If midValue < target → search right half.
    - If midValue > target → search left half.
    - If equal → return true.
- If search ends without finding the target → return false.

Why this is optimal:
- Treating the matrix as a flattened sorted array allows direct binary search.
- Achieves the required O(log(m*n)) time complexity.
- No extra space or additional traversal.

Time Complexity: O(log(m*n))
- Binary search over m*n elements.

Space Complexity: O(1)
- Only pointer variables are used.
*/

package binarySearch;

public class SearchA2DMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int left = 0;
            int right = m * n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midValue = matrix[mid / n][mid % n];

                if (midValue == target) {
                    return true;
                } else if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }
}
