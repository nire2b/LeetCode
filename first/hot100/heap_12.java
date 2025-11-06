package first.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class heap_12 {
    public static void main(String[] args) {

    }
}

class Solution_12 {
    //215.数组中第k个最大的元素
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i <k ; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i]>=heap.peek()){
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.poll();
    }
}
