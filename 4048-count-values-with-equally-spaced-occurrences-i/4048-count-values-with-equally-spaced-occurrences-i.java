import java.util.*;
class Solution {
    public int IntegerSpecial(int[] nums) {
        int n = nums.length;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

       for(int i=0; i<n; i++) {
           map.putIfAbsent(nums[i], new ArrayList<>());

           map.get(nums[i]).add(i);
       }

        int count = 0;

        for(ArrayList<Integer> pos : map.values()) {
    if(pos.size() == 3 && pos.get(1) - pos.get(0) == pos.get(2) - pos.get(1)) {
                count++;
            }
        }
        return count;
    }
    public int countSpecialIntegers(int[] nums) {
        return IntegerSpecial(nums);
    }
}