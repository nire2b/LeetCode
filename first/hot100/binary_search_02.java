package first.hot100;

public class binary_search_02 {
    public static void main(String[] args) {
        Solution_02 solution02 = new Solution_02();
        solution02.searchRange(new int[]{1,2,3},2);
    }
}

class Solution_02 {
    //35.搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>1;
            if (nums[mid]<target){
                l = mid +1;
            }else if(nums[mid]>target){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return l;
    }

    //74.搜索二维矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int len = matrix[i].length;
            if(target<=matrix[i][len-1]){
                index = i;
                break;
            }
        }
        if (index<0){
            return false;
        }
        for (int i = 0; i <matrix[index].length ; i++) {
            if(target==matrix[index][i]){
                return true;
            }
        }
        return false;
    }

    //34.在排序数组中查找元素的第一个位置和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        if(nums == null||nums.length==0){
            return new int[]{-1,-1};
        }
        int l =0;
        int r = nums.length-1;
        int mid = 0;
        while (l<=r){
             mid = l + (r-l)/2;
            if(nums[mid]>target){
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid +1;
            }else {
                break;
            }
        }
        if(nums[mid]!=target){
            return new int[]{-1,-1};
        }
        for (int i = 0; i <= mid; i++) {
            if (nums[i] == target){
                l = i;
                break;
            }
        }
        for (int i = mid; i < nums.length; i++) {
            if (nums[i] != target){
                r = i-1;
                break;
            }
        }
        return new int[]{l,r};
    }

    //33.搜索旋转排序数组（待做）
    public int search(int[] nums, int target) {
        return -1;
    }

    //153.寻找旋转数组中的最小值（待做）
    public int findMin(int[] nums) {
        return -1;
    }

    //4.寻找两个正序数组的中位数（待做）
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return -1;
    }
}
