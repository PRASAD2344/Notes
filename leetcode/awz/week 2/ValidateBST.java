//https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/514/
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
  public boolean isValidBST(TreeNode root) {
    if(root == null)
        return true;
    List<Integer> traversedValues = new ArrayList();  
    return inOrderTraversal(root,traversedValues);
  }
  public boolean inOrderTraversal(TreeNode root,List<Integer> traversedValues){
      boolean retValue = true;
      if(retValue && root.left != null)
          retValue = retValue && inOrderTraversal(root.left,traversedValues);
      if(retValue){
           if(traversedValues.size() > 0){
              retValue = retValue && (traversedValues.get(traversedValues.size()-1) < root.val);
          }
          traversedValues.add(root.val);   
      }
      if(retValue && root.right != null)
          retValue = retValue && inOrderTraversal(root.right,traversedValues);
      return retValue;
  }
}