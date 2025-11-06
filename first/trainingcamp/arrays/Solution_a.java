package first.trainingcamp.arrays;

public class Solution_a {
    public static void main(String[] args) {
        int search = removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println(search);
    }

    //704.二分查找
    public static int search(int[] nums, int target) {
        int l = 0; //左边界
        int r = nums.length-1; //右边界
        int mid =l+r>>1; //中间点，防止越界
        while (l<=r){
            if(target>nums[mid]){
                l = mid+1;
            }else if(target<nums[mid]){
                r = mid-1;
            }else {
                return mid;
            }
            mid = l+r>>1;
        }
        return -1;
    }

    //27.移除元素
    public static int removeElement(int[] nums, int val) {
        int index = nums.length-1; //需要被换过来的下标
        int count = 0;//与val不同的数量
        for (int i = 0; i < nums.length; i++) {
            if(i>index){//当前下标大于被换的下标就代表结束
                break;
            }
            if(nums[i]==val){
                nums[i] = -1;//修改值
                swap(nums,i,index--);//交换当前与后面的数的位置
                i--;//因为交换了，所以当前位置需要再次判断
            }else {
                count++;
            }
        }
        return count;
    }
    public static void swap(int[] nums,int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        
    }
}

