/*
Problem: Minimum Window Substring
Link: https://leetcode.com/problems/minimum-window-substring/

Approach:
- Used the Sliding Window technique with two hashmaps:
    - targetMap: stores the frequency of each character in string t
    - windowMap: stores the frequency of each character in the current window of s
- Initialize pointers 'left' and 'right' to define the window.
- Track 'required': the number of unique characters in t that must be present in the window.
- Track 'formed': the number of unique characters in the current window meeting their required frequency.
- Expand the window by moving 'right':
    - Update windowMap for s[right].
    - If the frequency matches targetMap, increment 'formed'.
- When 'formed' == 'required':
    - Try to shrink the window from 'left' to minimize its size while maintaining validity.
    - Update minimum window length and start index accordingly.
    - Decrement windowMap and adjust 'formed' if needed.
- Continue until 'right' reaches the end of s.

Why this is optimal:
- Each character in s is processed at most twice (once by right pointer, once by left pointer).
- Avoids O(m*n) brute-force substring checks.
- Hashmaps allow constant-time frequency checks and updates.

Time Complexity: O(m + n)
- m = length of s, n = length of t. Each pointer moves across s at most once, and building targetMap takes O(n).

Space Complexity: O(m + n)
- targetMap stores t's characters (O(n))
- windowMap stores characters in the current window of s (O(m) in worst case)
*/

package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";

            Map<Character, Integer> targetMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int required = targetMap.size();
            int formed = 0;
            Map<Character, Integer> windowMap = new HashMap<>();

            int minLen = Integer.MAX_VALUE;
            int minLeft = 0;

            while (right < s.length()) {
                char c = s.charAt(right);
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

                if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                    formed++;
                }

                while (left <= right && formed == required) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }

                    char toRemove = s.charAt(left);
                    windowMap.put(toRemove, windowMap.get(toRemove) - 1);

                    if (targetMap.containsKey(toRemove) && windowMap.get(toRemove).intValue() < targetMap.get(toRemove).intValue()) {
                        formed--;
                    }

                    left++;
                }

                right++;
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
        }
}
