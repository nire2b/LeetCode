package first.hot100;

import java.util.ArrayList;
import java.util.List;

public class others {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permutationsI(new int[]{1,2,3});
    }
}

class Solution {
    /* 回溯算法 */
    //46.全排列 I
    public List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }
    public void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<Integer>(state));
            return;
        }
        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素
            if (!selected[i]) {
                // 尝试：做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /* 贪心算法 */
    //121.买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i <prices.length ; i++) {
            if(prices[i]>min){
                max = Math.max(max,prices[i]-min);
            }else {
                min = prices[i];
            }
        }
        return Math.max(max, 0);
    }

    //55.跳跃游戏
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int target = len - 1;
        for (int i = len-2; i >=0 ; i--) {
            //从i开始往后跳nums[i]个位置
            if (i+nums[i]>=target){
                target = i;
            }
        }
        return target == 0;
    }

    //45.跳跃游戏Ⅱ
    public int jump(int[] nums) {
        int target = nums.length-1;
        int step = 0;
        while (target>0){
            for (int i = 0; i < nums.length; i++) {
                if(i+nums[i]>=target){
                    target=i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

}