//https://leetcode.com/problems/majority-element/submissions/
class Solution {
  public int majorityElement(int[] nums) {
      Map<Integer,Integer> occurances = new HashMap<>();
      for(int i=0;i<nums.length;i++){
          if(occurances.containsKey(nums[i])){
              occurances.put(nums[i],occurances.get(nums[i])+1);
          }else
              occurances.put(nums[i],1);
      }
      int majorityLimit = (int)Math.floor(nums.length/2);
      int maxKey = 0;
      int maxValue = Integer.MIN_VALUE;
      for(Map.Entry<Integer,Integer> entry : occurances.entrySet()){
          if(entry.getValue() >= majorityLimit && entry.getValue() >= maxValue){
              maxKey = entry.getKey();
              maxValue = entry.getValue();
          }
      }
      return maxKey;
  }
}