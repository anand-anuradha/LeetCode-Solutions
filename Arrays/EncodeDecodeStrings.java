/*
Problem: Encode and Decode Strings
Link: https://leetcode.com/problems/encode-and-decode-strings/

Approach:
- Used a length-prefix encoding format for each string:
      <length>#<string>
  Example: "word" → "4#word"
- During encoding, concatenate each string with its length and a '#' delimiter.
- During decoding, scan the encoded string:
    - Read characters until we hit '#', which gives us the length of the string.
    - Extract the next 'length' characters as our original string.
    - Continue scanning from the next index.

Why this is optimal:
- We avoid ambiguity: a string may contain '#', spaces, emojis, or UTF-8 chars.
  Length prefix ensures we always know where the string actually ends.
- Does not rely on escape sequences or replacement tricks.
- Works with empty strings ("") safely.

Time Complexity:
- Encode: O(m), m = total characters across all input strings.
- Decode: O(m), each character processed once.

Space Complexity:
- O(m + n):
    - m for characters stored in the output list.
    - n for list entries.
*/

package arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            result.add(str.substring(i, i + len));
            i = i + len;
        }

        return result;
    }
}
