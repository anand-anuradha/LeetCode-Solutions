/*
Problem: 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/

Approach:
- Used a HashMap named 'map' to count occurrences of each character in string 's'.
- Iterate through string 't':
    - If the character is not in 'map', return false.
    - Otherwise, decrement its count in 'map'.
    - If the count reaches zero, remove the character from 'map'.
- Finally, check if 'map' is empty. If yes, 't' is an anagram of 's'.

Why this is optimal:
- Time Complexity: O(n), where n is the length of the strings. Each string is traversed once.
- Space Complexity: O(n), storing character counts in the HashMap.
- Using a single HashMap with removal of zero-count characters keeps lookups and updates in constant time.
- This approach works for Unicode characters because keys are Character objects.
*/

package arrays;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
