class Solution {
    public static int productMax(int n) {
        
        String str = String.valueOf(n);
        int maxProduct = 0;
        
        for(int i=0; i<str.length(); i++) {
            int digit1 = str.charAt(i) - '0';;
            for(int j=i+1; j<str.length(); j++) {
            int digit2 = str.charAt(j) - '0';
                int product = digit1 * digit2;
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }
    public int maxProduct(int n) {
        return productMax(n);
    }
}