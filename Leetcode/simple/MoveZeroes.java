//https://leetcode.com/problems/move-zeroes/
class Solution {
  public void moveZeroes(int[] nums) {
      //Find the number of zeroes first
      int numberOfZeroes = 0;
      for(int i=0;i<nums.length;i++){
          if(nums[i] == 0){
              numberOfZeroes++;
          }
      }
      for(int i=0,j=0;i<nums.length;i++){
          if(nums[i] != 0){
              nums[j++] = nums[i];
          }
      }
      for(int i=nums.length-numberOfZeroes;i<nums.length;i++){
          nums[i] = 0;
      }
  }
}