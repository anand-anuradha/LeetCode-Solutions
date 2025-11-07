/*
Problem: Product of Array Except Self
Link: https://leetcode.com/problems/product-of-array-except-self/

Approach:
- Created an output array `result` where result[i] will store the product of all elements except nums[i].
- First pass (left to right):
    * Maintain a running variable `prefix` which stores the product of all elements to the left of the current index.
    * Store this prefix product into result[i], then multiply prefix by nums[i].
- Second pass (right to left):
    * Maintain a running variable `postfix` which stores the product of all elements to the right of the current index.
    * Multiply result[i] (which already holds prefix) by postfix, then multiply postfix by nums[i].

Why this is optimal:
- Time Complexity: O(n), since the array is scanned twice—once prefix, once postfix.
- Space Complexity: O(1) extra space (output array is not counted). Only two integer variables are used to maintain running products.
- Avoids division, making it safe for arrays containing zeros.
- Efficiently combines prefix + postfix products without additional structures.
*/

package arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];

        int prefix = 1;
        for(int i=0;i<nums.length;i++){
            result[i] = prefix;
            prefix = prefix*nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1;i>=0;i--){
            result[i] = postfix * result[i];
            postfix = postfix * nums[i];
        }

        return result;
    }
}
