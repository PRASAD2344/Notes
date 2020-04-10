
//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2967/
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer minDistance=null;
        int minSum=0;
        for(int i=0;i<nums.length-2;i++){
            int sum = nums[i] + twoSumClosest(nums,i+1,nums.length-1,target-nums[i]);
            int difference = Math.abs(target-sum);
            if(difference == 0){
                return sum;
            }else if(minDistance == null || minDistance > difference){
                minDistance = difference;
                minSum = sum;
            }
        } 
        return minSum;
    }
    
    public int twoSumClosest(int[] nums,int left,int right,int target){
        Integer minDistance=null;
        int minSum=0;
        while(left<right){
            int sum = nums[left]+nums[right];
            int difference = Math.abs(target-sum);
            if(sum == target){
                return sum;
            }else if(sum < target){
                left+=1;
            }else if(sum > target){
                right-=1;
            }
            if(minDistance == null || minDistance > difference){
                minDistance = difference;
                minSum = sum;
            }
        }
        return minSum;
    }
}