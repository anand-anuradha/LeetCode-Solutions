/*
Problem: Longest Substring Without Repeating Characters
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Approach:
- Used the Sliding Window technique with two pointers: 'left' and 'right'.
- Maintain a HashSet to store unique characters currently in the window.
- Move 'right' pointer across the string:
    - If character s[right] is not in the set, add it and update the maximum length.
    - If it is already present, shrink the window by removing characters from the left until the duplicate is removed.
- This ensures the window always contains a substring with all unique characters.

Why this is optimal:
- Each character is added and removed from the HashSet at most once.
- The window only moves forward, never backtracks.
- Avoids the brute-force O(n²) substring check by maintaining uniqueness dynamically.

Time Complexity: O(n)
- A single pass through the string with each pointer moving at most n steps.

Space Complexity: O(k)
- HashSet stores at most k unique characters (k = charset size, typically ≤ 128).
*/


package slidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length()==0){
                return 0;
            }

            if(s.length() == 1){
                return 1;
            }

            int left = 0;
            int right = 0;
            int ans = 0;

            HashSet<Character> set = new HashSet<>();

            while(right < s.length()){
                char c = s.charAt(right);
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
                ans = Math.max(ans, right-left + 1);
                right++;
            }

            return ans;
        }
}
