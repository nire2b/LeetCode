package first.hot100;

import java.util.*;

/*     53.最大子数和
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组是数组中的一个连续部分。
*/
public class array_01 {
    public static void main(String[] args) {
        Solution_01 solution01 = new Solution_01();
//        solution01.rotate(new int[]{-1,-100,3,99},2);
        solution01.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
class Solution_01 {
    //283 最大子数组和 中等
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int preMin = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            max = Math.max(preSum-preMin,max);
            preMin = Math.min(preMin,preSum);
        }
        return max;
    }

    //056 区间合并 中等
    public int[][] merge(int[][] intervals) {
        if (intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int tempL = 0;
        int tempR = 0;
        for (int i = 0; i<intervals.length-1;i++){
            if(intervals[i][1]>=intervals[i+1][0]){
                tempL = intervals[i][0];
                tempR = Math.max(intervals[i][1],intervals[i+1][1]);
                intervals[i+1][0] = tempL;
                intervals[i+1][1] = tempR;
            }else {
                list.add(intervals[i]);
            }
        }
            list.add(intervals[intervals.length-1]);
        int[][] result = new int[list.size()][];
        int index = 0;
        for(int[] a:list){
            result[index] = a;
            index++;
        }
        return result;
    }

    //238 除自身以外的乘积
    public int[] productExceptSelf(int[] nums) {
        int totleMle = 1;
        int zeroNum = 0;
        for (int i = 0;i<nums.length;i++){
            totleMle *=nums[i];
            if (nums[i]==0){
                zeroNum++;
            }
        }
        if(zeroNum>=2){
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
            return nums;
        }
        if (zeroNum==1){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0){
                    int temp = 1;
                    for (int j = 0; j < i; j++) {
                        temp*=nums[j];
                        nums[j] = 0;
                    }
                    for (int j = i+1; j < nums.length; j++) {
                        temp*=nums[j];
                        nums[j] = 0;
                    }
                    nums[i] = temp;
                    return nums;
                }
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = totleMle/nums[i];
        }
        return nums;
    }

    //189 轮转数组
    public void rotate(int[] nums, int k) {
        if(k==0||k%nums.length==0){
            return;
        }
        int len = nums.length;
        k %= len;
        int[] res = new int[len];
        for (int i = 0; i < len-k; i++) {
            res[i+k] = nums[i];
        }
        int index = 0;
        for (int i = len-k; i<len;i++){
            res[index] = nums[i];
            index++;
        }
        for (int i = 0; i < len; i++) {
            nums[i] = res[i];
        }
    }

    //41 缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],1);
            max = Math.max(max,nums[i]);
        }
        for (int i = 1; i < max; i++) {
            if (!map.containsKey(i)){
                return i;
            }
        }
        return ++max;
    }

}
