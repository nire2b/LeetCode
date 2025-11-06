package first.hot100;

import java.util.*;

public class hash_05 {
    public static void main(String[] args) {
        //Set转为数组：Integer[] nums1 = set.toArray(new Integer[0]);
        Solution_05 solution = new Solution_05();
        solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }
}
class Solution_05 {
    //001 两数之和 简单
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int temp = 0;
        for(int i = 0;i<nums.length;i++){
            temp = target-nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i){
                return new int[]{i,map.get(temp)};
            }
        }
        return null;
    }

    //049 字母异位词分组 中等
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : entries) {
            result.add(entry.getValue());
        }

        return result;
    }

    //128 最长连续序列 中等
    public int longestConsecutive(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        Arrays.sort(nums);
        HashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Integer[] nums1 = set.toArray(new Integer[0]);
        int l = 0;
        int r = 1;
        int temp = nums1[0], tempLength = 1, maxLength = 1;
        while (r<nums1.length){
            if (++temp==nums1[r]){
                r++;
                tempLength++;
                maxLength = Math.max(maxLength,tempLength);
                continue;
            }else if(r+2<=nums1.length){
                l = r;
                temp = nums1[l];
                r = r+1;
                tempLength = 1;
            }else {

                return maxLength;
            }

        }
        return maxLength;
    }
}

