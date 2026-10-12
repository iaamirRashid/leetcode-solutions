class Solution {
    public boolean prime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> primeMax(int n, int s) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            if (prime(i)) {
                if (sum + i > s) {
                    break;
                }

                list.add(i);
                sum += i;
            }
        }

        return list;
    }
    public List<Integer> maxPrimes(int n, int s) {
        return primeMax(n, s);
    }
}