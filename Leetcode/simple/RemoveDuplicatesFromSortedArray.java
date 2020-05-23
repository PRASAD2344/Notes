//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
  public int removeDuplicates(int[] nums) {
      if(nums == null || nums.length == 0)
          return 0;
      int neededLength = 0;
      int parsedLength = nums.length;
      Integer previousValue = null;
      for(int i=0;parsedLength >= 1;parsedLength--){
          if(previousValue != null && previousValue == nums[i]){
              for(int j=i;j<nums.length-1;j++){
                  nums[j] = nums[j+1];
              }
              nums[nums.length-1] = previousValue;
              continue;
          }
          neededLength++;
          previousValue=nums[i];
          i++;
      }
      return neededLength;
  }
}

//Optimized Moving Pointer Soulution O(n)
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
  public int removeDuplicates(int[] nums) {
      if(nums == null || nums.length == 0)
          return 0;
      if(nums.length == 1)
          return 1;
      int neededLength = 1;
      int previousValue = nums[0];
      int currentPointer = 0;
      int movingPointer = 1;
      for(;movingPointer<nums.length;movingPointer++){
          if(nums[movingPointer] != nums[currentPointer]){
              nums[++currentPointer] = nums[movingPointer];
              neededLength++;
          }
      }
      return neededLength++;
  }
}

