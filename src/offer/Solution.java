package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by albert on 2017/7/26.
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        HashMap<Integer,Integer> npre = new HashMap<>();
        HashMap<Integer,Integer> nin = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            if (npre.containsKey(pre[i]) || nin.containsKey(in[i])) return null;
            npre.put(pre[i],i);
            nin.put(in[i],i);
        }
        TreeNode root = null;
        root = build(root,nin,pre,0,0,pre.length-1);
        return root;
    }

    private TreeNode build(TreeNode x, HashMap<Integer, Integer> nin, int[] pre, int lo, int mid, int hi) {
        if (lo > hi) return null;
        for (int i = 0; i < pre.length; i++) {
            if (nin.get(pre[i]) >= lo && nin.get(pre[i]) <= hi){
                mid = i;
                break;
            }
        }
        x = new TreeNode(pre[mid]);
        x.left = build(x.left, nin, pre, lo, mid, nin.get(pre[mid]) - 1);
        x.right = build(x.right, nin, pre, nin.get(pre[mid]) + 1, mid, hi);
        return x;
    }

    public static void main(String[] args) {
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
//        Solution solution = new Solution();
//        TreeNode treeNode = solution.reConstructBinaryTree(pre,in);
//        dfs(treeNode);
        System.out.println(-16>>>2);
        ArrayList list = new ArrayList();
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(list.size());
        list.clone();
    }

    public static void dfs(TreeNode treeNode){
        if (treeNode == null) return;
        dfs(treeNode.left);
        System.out.print(treeNode.val + " ");
        dfs(treeNode.right);
    }

    public void solu(int[] su){
        

    }












    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
