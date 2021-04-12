/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer, Integer> treeMap = new HashMap<>();
        preOrder(root, 0, treeMap);
        int max = 0;
        for (int key : treeMap.keySet()) {
			max = Math.max(max, key);
		}        
        return treeMap.get(max);
    }
    
    public void preOrder(TreeNode node, int depth, HashMap<Integer, Integer> map){
        if (node == null){
            return;
        }        
        if (map.get(depth) == null){
            map.put(depth, node.val);
        }
        else {
            map.put(depth, map.get(depth) + node.val);
        }
        preOrder(node.left, depth + 1, map);
        preOrder(node.right, depth + 1, map);
    }
}
