class Solution {
    public List<String> frequentWords(String[] words, int k) {
  // 1. Frequency map
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // 2. Min Heap of size k
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                
                // Same frequency -> lexicographically larger
                // word will be considered worse
                if (freq.get(a).equals(freq.get(b))) {
                    return b.compareTo(a);
                }

                // Lower frequency -> worse
                return freq.get(a) - freq.get(b);
            }
        );

        // 3. Keep only top k words
        for (String word : freq.keySet()) {

            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 4. Build answer
        LinkedList<String> ans = new LinkedList<>();

        while (!pq.isEmpty()) {
            ans.addFirst(pq.poll());
        }

        return ans;
    }
    public List<String> topKFrequent(String[] words, int k) {
     return frequentWords(words, k);   
    }
}