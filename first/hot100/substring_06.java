package first.hot100;

public class substring_06 {
    public static void main(String[] args) {
        Solution_06 solution06 = new Solution_06();
        solution06.subarraySum(new int[]{1,1,1},2);
    }
}
class Solution_06 {
    //560.和为k的子数组
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len==1){
            return k==len?1:0;
        }
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i-1]+nums[i];
        }
        int ans = 0;
        for (int i =0;i<len;i++){
            if (preSum[i] ==k){
                ans++;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(preSum[j]-preSum[i-1]==k){
                    ans++;
                }
            }
        }
        return ans;
//        int len = nums.length;
//        if (len==1){
//            return k==len?1:0;
//        }
//        int[] preSum = new int[len+1];
//        preSum[0] = 0;
//        for (int i = 0; i < len; i++) {
//            preSum[i+1] = preSum[i]+nums[i];
//        }
//        int ans = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if(preSum[j+1]-preSum[i]==k){
//                    ans++;
//                }
//            }
//        }
//        return ans;
    }


}
