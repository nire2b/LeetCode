package first.hot100;

import java.util.*;


public class sliding_window_07 {
    public static void main(String[] args) {
        Solution_07 solution07 = new Solution_07();
        solution07.findAnagrams("baa","aa");
    }
}
@SuppressWarnings("all")
class Solution_07 {
//    3.无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if(len<=1){
            return len;
        }
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < len-1; i++) {
            map.put(charArray[i],0);
            for (int j = i+1; j < len; j++) {
                if (map.containsKey(charArray[j])){
                    max = Math.max(max,map.size());
                    map.clear();
                    break;
                }
                map.put(charArray[j],0);
            }
        }
        max = Math.max(max,map.size());
        return max;
    }

//    438.找到字符串中所有字母的异位词
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        // 初始化两个计数数组
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        // 检查初始化的窗口是否为Anagram
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        // 使用滑动窗口遍历字符串s
        for (int i = 0; i < sLen - pLen; i++) {
            // 更新窗口两端的字符计数
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            // 检查当前窗口是否为Anagram
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1); // 注意这里应该是i+1，因为i是从0开始的
            }
        }
        return ans;
    }

}
