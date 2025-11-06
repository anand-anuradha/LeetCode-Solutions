/*
Problem: Group Anagrams
Link: https://leetcode.com/problems/group-anagrams/

Approach:
- Used a HashMap<String, List<String>> named 'ansMap' where:
    - Key   => A unique string built from character frequency counts (e.g., "#1#0#1...")
    - Value => List of strings (anagrams) that share the same frequency pattern.
- Maintained a fixed-size integer array 'count' of length 26 (for lowercase English letters).
- For each string:
    - Reset the 'count' array to zeros.
    - Count occurrences of each character.
    - Converted the 'count' array into a key using StringBuilder by appending counts with a '#' separator to avoid ambiguity (e.g., '11' and '1#1').
    - Used this key to group the string into the HashMap (create the list if missing).
- Finally, returned all grouped anagram lists as an ArrayList of ansMap.values().

Why this is optimal:
- Avoids sorting each string which costs (O(n logn)).
- HashMap lookups and insertions provide average O(1) performance.
- Reusing the same 'count' array saves extra memory allocations.

Time Complexity:
- O(n * l), where:
    n = number of strings,
    l = longest length of any string.
- Each string is processed once with a constant 26-length frequency build.

Space Complexity:
- O(n * l) for storing grouped results in the HashMap.
*/

package arrays;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }

        Map<String, List> ansMap = new HashMap<>();

        int[] count = new int[26];

        for(String s:strs){
            Arrays.fill(count, 0);
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){
                ansMap.put(key,new ArrayList());

            }
            ansMap.get(key).add(s);

        }

        return new ArrayList(ansMap.values());
    }
}
