/*
Problem: Top K Frequent Elements
Link: https://leetcode.com/problems/top-k-frequent-elements/

Approach:
- First, count the frequency of each number in the array using a HashMap<Integer, Integer>.
- Used a Min Heap (PriorityQueue) of size k to keep track of the k most frequent elements:
    - Comparator: (a, b) -> count.get(a) - count.get(b) ensures the smallest frequency is at the top.
    - For each number in the map, add it to the heap.
    - If heap size exceeds k, remove the smallest element (poll).
- After processing all numbers, the heap contains the k most frequent elements.
- Pop all elements from the heap into the result array.

Why this is optimal:
- Time Complexity: O(n log k)
    - O(n) to count frequencies
    - O(n log k) to maintain the heap of size k
- Space Complexity: O(n)
    - O(n) for the frequency map
    - O(k) for the heap
    - O(k) for the result array
- This approach is better than sorting the entire array by frequency (O(n log n)) and satisfies the follow-up requirement.
*/


package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n:nums){
            count.put(n, count.getOrDefault(n,0) +1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a,b) -> count.get(a)-count.get(b));

        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = heap.poll();
        }

        return ans;
    }
}
