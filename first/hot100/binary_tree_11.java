package first.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val=val;};
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left = left;
        this.right = right;
    };
}
public class binary_tree_11 {
    public static void main(String[] args) {
        Solution_11 solution11 = new Solution_11();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        solution11.inorderTraversal(node1);
    }
}
class Solution_11 {
    //94.二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root,List<Integer> list) {
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    //104.二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth((root.left));
        int right = maxDepth((root.right));
        return Math.max(left,right)+1;
    }

    //226.翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    //101.对称二叉树
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode l,TreeNode r) {
        if(l==null&&r==null){
            return true;
        }
        if(l==null||r==null){
            return false;
        }
        return l.val==r.val&&check(l.left,r.right)&&check(l.right,r.left);
    }

    //543.二叉树的直径
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        deep(root);
        return ans-1;
    }
    public int deep(TreeNode root) {
        if (root==null){
            return 0;
        }
        int l = deep(root.left);
        int r = deep(root.right);
        ans = Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }

    //102.二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root ==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    //108.将有序数组转换为平衡搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = procee(nums,0,nums.length-1);
        return root;
    }
    public TreeNode procee(int[]nums,int left,int right){
        if (left>right){
            return null;
        }
        int mid = left+((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = procee(nums,left,mid-1);
        root.right = procee(nums,mid+1,right);
        return root;
    }

    //98.验证二叉搜索树
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i =1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}