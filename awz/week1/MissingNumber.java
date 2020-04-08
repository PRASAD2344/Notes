//https://leetcode.com/problems/missing-number/
class Solution {
    public int missingNumber(int[] nums) {
        int max = -1;
        int sum = 0;
        boolean containsZero = false;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            sum = sum + nums[i];
            if(nums[i] == 0)
                containsZero = true;
        }
        if(!containsZero)
            return 0;
        int sumExpected = (max * ( max + 1 )) / 2;
        if(sum < sumExpected)
            return sumExpected-sum;
        else
            return max+1;
    }
}
