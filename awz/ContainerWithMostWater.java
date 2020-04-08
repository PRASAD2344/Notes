//https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int maxArea = -1;
        int left = 0;
        int right = height.length - 1;
        for(;left<right;){
            if(height[left] > height[right]){
                maxArea = Math.max(maxArea,(right-left)* height[right]);
                right--;
            }else{
                maxArea = Math.max(maxArea,(right-left)* height[left]);
                left++;
            }
        }
        return maxArea;
    }
}
