//https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] notFoundInvalid = new int[]{-1,-1};
        if(nums==null || nums.length == 0){
            return notFoundInvalid;
        }
        Map<Integer,Integer> numsIndexMap = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(numsIndexMap.get(target-nums[i]) != null){
                return new int[]{i,numsIndexMap.get(target-nums[i])};
            }
            numsIndexMap.put(nums[i],i);
        }
        return notFoundInvalid;
    }
}
