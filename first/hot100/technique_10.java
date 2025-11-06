package first.hot100;

import java.util.Arrays;

public class technique_10 {
    public static void main(String[] args) {
        Solution_10 solution10 = new Solution_10();
        solution10.nextPermutation(new int[]{1,2,3});
    }
}

class Solution_10 {
    //136.只出现一次的数字
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }

    //169.多数元素
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i <nums.length ; i++) {
            if (major==nums[i]){
                count++;
            }else if(--count==0){
                major=nums[i];
                count = 1;
            }
        }
        return major;
    }

    //75.颜色分类
    public void sortColors(int[] nums) {

    }

    //31.下一个排列
    public void nextPermutation(int[] nums) {
        boolean isMin = false;
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i]>nums[i-1]){
                int j = nums.length-1;
                while (nums[j]<=nums[i-1]){
                    j--;
                }
                //交换i-1和j
                swap(nums,i-1,j);
                //从i开始反转后续的数组
                reverse(nums,i,nums.length-1);
                isMin=true;
                break;
            }
        }
        if (!isMin){
            Arrays.sort(nums);
        }
    }
    void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end] = temp;
    }
    void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //287.寻找重复数
    public int findDuplicate(int[] nums) {
        //1.初始化快慢指针
        int slow = 0;
        int fast = 0;
        //2.寻找相遇点
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }while (slow!=fast);
        //3.寻找入口点
        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
