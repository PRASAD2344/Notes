//https://leetcode.com/problems/merge-sorted-array
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      for(int j=0, i=0;j<n;j++){
          for(;i<nums1.length;i++){
              if(nums2[j] <= nums1[i] || i >= m){
                  //Do swapping
                  for(int k=nums1.length-1;k>i;k--){
                      nums1[k] = nums1[k-1];
                  }
                  nums1[i] = nums2[j];
                  m++;
                  break;
              }
          }
      }
  }
}