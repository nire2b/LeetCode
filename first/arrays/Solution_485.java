package first.arrays;

class Solution_485 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if((nums[i]&1)==0){
                max = Math.max(max,count);
                count = 0;
                continue;
            }
            count++;
        }
        return Math.max(max, count);
    }
}
