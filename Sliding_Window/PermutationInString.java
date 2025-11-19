/*
Problem: Permutation in String
Link: https://leetcode.com/problems/permutation-in-string/

Approach:
- Used the Sliding Window technique with two frequency arrays of size 26 for lowercase letters.
- Initialize:
    - s1Map: frequency map for string s1
    - s2Map: frequency map for the first window of s2 of size s1.length()
- Slide the window across s2:
    - At each step, compare s1Map and s2Map using a helper function.
    - If they match, return true (a permutation exists in s2).
    - Update s2Map for the next window:
        - Increment count of the new character entering the window.
        - Decrement count of the character leaving the window.
- Check the last window after the loop.

Why this is optimal:
- Each character in s2 is processed exactly once in the sliding window.
- Comparison of frequency arrays is O(26), which is constant time.
- Avoids generating all permutations or using nested loops (O(n*m) approach).

Time Complexity: O(n)
- n = length of s2, each character is processed once. Array comparison is constant time.

Space Complexity: O(1)
- Two fixed-size frequency arrays of size 26 are used.
*/

package slidingWindow;

public class PermutationInString {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            int[] s1Map = new int[26];
            int[] s2Map = new int[26];

            // Initialize frequency maps for s1 and the first window of s2
            for (int i = 0; i < s1.length(); i++) {
                s1Map[s1.charAt(i) - 'a']++;
                s2Map[s2.charAt(i) - 'a']++;
            }

            // Slide the window through s2 and compare the maps
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if (matches(s1Map, s2Map)) {
                    return true;
                }
                s2Map[s2.charAt(i + s1.length()) - 'a']++; // Add new character to the window
                s2Map[s2.charAt(i) - 'a']--; // Remove old character from the window
            }

            // Check the last window
            return matches(s1Map, s2Map);
        }

        // Helper function to compare two frequency maps
        private boolean matches(int[] s1Map, int[] s2Map) {
            for (int i = 0; i < 26; i++) {
                if (s1Map[i] != s2Map[i]) {
                    return false;
                }
            }
            return true;

        }
}
