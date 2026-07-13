class Solution {
    public int mutation(String startGene, String endGene, String[] bank) {
       // bank ko list me convert karo
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            ls.add(bank[i]);
        }

        // agar endGene bank me hi nahi hai to -1 return
        if (!ls.contains(endGene)) return -1;

        // visited map banao
        HashMap<String, Boolean> visited = new HashMap<>();
        for (String gene : ls) {
            visited.put(gene, false);
        }
        // startGene ko bhi map me daalo
        visited.put(startGene, true);

        char[] choices = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        q.add(startGene);

        int mutations = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String gene = q.poll();

                if (gene.equals(endGene)) return mutations;

                char[] arr = gene.toCharArray();

                // har position pe character ko mutate karo
                for (int pos = 0; pos < arr.length; pos++) {
                    char original = arr[pos];
                    for (char c : choices) {
                        if (c == original) continue;

                        arr[pos] = c;
                        String newGene = new String(arr);

                        if (visited.containsKey(newGene) && !visited.get(newGene)) {
                            visited.put(newGene, true);
                            q.add(newGene);
                        }
                    }
                    arr[pos] = original; // reset karo
                }
            }
            mutations++;
        }
        return -1;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        return mutation(startGene, endGene, bank);
    }
}