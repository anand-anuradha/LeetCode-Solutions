/*
Problem: Valid Palindrome
Link: https://leetcode.com/problems/valid-palindrome/

Approach:
- Used a two-pointer technique: Initialized one pointer at the start (left) and one at the end (right).
- While left < right:
   - Move the left pointer forward until it points to an alphanumeric character.
   - Move the right pointer backward until it points to an alphanumeric character.
- Compare the characters at both pointers after converting them to lowercase:
   - If they differ, return false immediately.
- Move both pointers inward and continue checking.
- If all mirrored characters match, return true.

Why this is optimal:
- No need to create a filtered copy of the string.
- Two-pointer scanning avoids extra memory usage.
- Each character is processed at most once.

Time Complexity:
- O(n), because we traverse the string once from both ends.

Space Complexity:
- O(1), since no extra data structures are used.
*/


package twoPointers;

public class ValidPalindrome {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while(left<right){
                while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                    left++;
                }
                while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                    right--;
                }
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
}
