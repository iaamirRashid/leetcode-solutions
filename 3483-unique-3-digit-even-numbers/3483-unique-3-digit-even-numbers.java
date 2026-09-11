class Solution {
    public static int totalNum(int digits[]) {
        Set<Integer> result = new HashSet<>();

        for(int i=100; i<=999; i++) {
            if(i%2 != 0) continue;

            int freq[] = new int[10];
            for(int num : digits) {
                freq[num]++;
            }

            int a = i/100;
            int b = (i/10)%10;
            int c = i%10;

            freq[a]--;
            freq[b]--;
            freq[c]--;

            if(freq[a] >= 0 && freq[b] >= 0 && freq[c] >= 0) {
                result.add(i);
            }
        }
        return result.size();
    }
    public int totalNumbers(int[] digits) {
        return totalNum(digits);
    }
}