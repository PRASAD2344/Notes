//https://leetcode.com/problems/contains-duplicate
class Solution {
  public boolean containsDuplicate(int[] nums) {
      Set<Integer> numsSet = new HashSet<>();
      for(int i=0;i<nums.length;i++){
          numsSet.add(nums[i]);
      }
      return numsSet.size() != nums.length;
  }
}