/*
Problem: Longest Repeating Character Replacement
Link: https://leetcode.com/problems/longest-repeating-character-replacement/

Approach:
- Used the Sliding Window technique with two pointers: 'left' and 'right'.
- Maintain a frequency array 'count' of size 26 for uppercase English letters.
- Keep track of 'maxFreq', the count of the most frequent character in the current window.
- For each character at 'right':
    - Increment its frequency in 'count'.
    - Update 'maxFreq' if this character's frequency is higher.
    - Check if the current window can be converted into a repeating character substring:
        - If (window length - maxFreq) > k, shrink window by moving 'left' and decrementing count[left].
    - Update 'maxLength' with the current valid window size.
- Continue until 'right' reaches the end of the string.

Why this is optimal:
- Each character is processed exactly once by the window.
- Sliding window avoids O(n²) brute-force checks.
- Frequency array ensures constant-time character count updates.

Time Complexity: O(n)
- Each pointer moves across the string once.

Space Complexity: O(1)
- Frequency array is fixed size (26 for uppercase letters).
*/

package slidingWindow;

public class LongestRepeatingCharacterReplacement {
        public int characterReplacement(String s, int k) {

            int[] count = new int[26];
            int left = 0;
            int maxFreq = 0;
            int maxLength = 0;

            for (int right = 0; right < s.length(); right++) {

                count[s.charAt(right) - 'A']++;

                maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

                if ((right - left + 1) - maxFreq > k) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
}
