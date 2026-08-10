class Solution {
    public int compressStr(char[] chars) {
        int index = 0;
        int i = 0;

        while(i<chars.length) {
         char currentChar = chars[i];
         int count = 0;

         while(i<chars.length && chars[i] == currentChar) {
            count++;
            i++;
         }
         chars[index++] = currentChar;

        // If count > 1, convert count to characters and write
         if(count>1) {
            for(char c : Integer.toString(count).toCharArray()) {
                chars[index++] = c;
            }
         }
        }
        return index;

    }
    public int compress(char[] chars) {
        return compressStr(chars);
    }
}