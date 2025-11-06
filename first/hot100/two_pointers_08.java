package first.hot100;

import java.util.*;

public class two_pointers_08 {
    public static void main(String[] args) {

    }
}

class Solution_08 {
    //283.移动零
    public void moveZeroes(int[] nums) {
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i <len ; i++) {
            nums[i] = 0;
        }
    }

    //11.盛水最多的容器
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = (r-l)*Math.min(height[l],height[r]);
        while (l<r){
            if (height[l]>=height[r]){
                r--;
                max = Math.max(max,(r-l)*Math.min(height[l],height[r]));
            }else {
                l++;
                max = Math.max(max,(r-l)*Math.min(height[l],height[r]));
            }
        }
        return max;
    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            // 如果当前数字大于0，则后续的所有数字之和必定大于0，可以直接跳出循环
            if (nums[k] > 0) break;
            // 跳过重复的数字，避免产生重复的三元组
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int s = nums[k] + nums[i] + nums[j];
                if (s > 0) {
                    // 移动右指针，并跳过重复的数字
                    while (i < j && nums[j] == nums[--j]);
                } else if (s < 0) {
                    // 移动左指针，并跳过重复的数字
                    while (i < j && nums[i] == nums[++i]);
                } else {
                    // 找到一个解，添加到结果列表中
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 同时移动左右指针，并跳过重复的数字
                    while (i < j && nums[j] == nums[--j]); // 先移动再检查
                    while (i < j && nums[i] == nums[++i]); // 先移动再检查
                }
            }
        }
        return list;
    }
}
