class Solution {

    public boolean transform(int[] source, int[] target) {

        long sum = 0;
        long sum2 = 0;

        for (int i = 0; i < source.length; i++) {
            sum += source[i];
        }

        for (int i = 0; i < target.length; i++) {
            sum2 += target[i];
        }

        return sum == sum2;
    }

    public boolean canTransform(int[] source, int[] target) {
        return transform(source, target);
    }
}