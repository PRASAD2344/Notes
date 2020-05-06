//https://leetcode.com/problems/3sum/
//We can use map to get only the ones we need - N
//How can we remove duplicate triplets??, can we order them so that we can remove triplets
//n2+n complexity - for total process
//triplets - map 
import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> retValue = new ArrayList();
        Map<String,Integer> occurances = new HashMap<>();
        for(int i=0;i<nums.length-2;i++){
            List<List<Integer>> result = twoSum(nums,i+1,nums.length-1,-1*nums[i]);
            if(result.size() == 0)
                continue;
            for(List<Integer> combination : result){
                String triplet = nums[i]+","+combination.get(0)+","+combination.get(1);
                if(occurances.containsKey(triplet))
                    continue;
                occurances.put(triplet,1);
                retValue.add(List.of(nums[i],combination.get(0),combination.get(1)));
            }
        }
        return retValue;
    }
    public List<List<Integer>> twoSum(int[] nums,int left,int right,int target){
        List<List<Integer>> retValues = new ArrayList<>();
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                retValues.add(List.of(nums[left],nums[right]));
                left+=1;
            }else if(sum < target){//Move to higher zones
                left+=1;
            }else if(sum > target){//Move to lesser zones
                right-=1;
            }
        }
        return retValues;
    }
}