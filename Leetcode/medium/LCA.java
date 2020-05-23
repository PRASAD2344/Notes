//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
      List<TreeNode> pathP = new ArrayList<>();
      findPath(root,p,pathP);
      
      List<TreeNode> pathQ = new ArrayList<>();
      findPath(root,q,pathQ);
      
      for(TreeNode parentNode : pathQ){
          if(pathP.contains(parentNode)){
              return parentNode;
          }
      }
     
      return null;
  }
  
  public boolean findPath(TreeNode root,TreeNode node,List<TreeNode> path){
      if(root == null){
          return false;
      }else if(root.val == node.val){
          path.add(root);
          return true;
      }
      boolean foundInLeft = findPath(root.left,node,path);
      if(foundInLeft){
          path.add(root);
          return true;
      }
      boolean foundInRight = findPath(root.right,node,path);
      if(foundInRight){
          path.add(root);
          return true;
      }
      return false;
  }
}