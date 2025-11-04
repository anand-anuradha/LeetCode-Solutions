/*
Problem: Contains Duplicate
Link: https://leetcode.com/problems/contains-duplicate/

Approach:
- Used a HashSet named 'seenNumbers' to track all numbers we have encountered.
- Iterate through the array 'nums':
    - If the current number is already in 'seenNumbers', return true.
    - Otherwise, add the number to 'seenNumbers'.
- If the iteration completes without finding duplicates, return false.

Why this is optimal:
- Time Complexity: O(n), because we iterate through the array once.
- Space Complexity: O(n), storing at most n elements in the HashSet.
- Using a HashSet allows constant-time lookup for duplicates, making it efficient.
*/

package arrays;

import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for(int num:nums){
            if(seenNumbers.contains(num)){
                return true;
            }

            seenNumbers.add(num);
        }

        return false;
    }
}
