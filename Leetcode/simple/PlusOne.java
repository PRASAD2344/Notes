//https://leetcode.com/problems/plus-one
class Solution {
  public int[] plusOne(int[] digits) {
      int[] output = new int[digits.length];
      int carryForward = 0;
      int sum = 0;
      for(int i=output.length-1;i>=0;i--,sum=0){
          if(i==output.length-1){
              sum = digits[i]+1;
          }else
              sum = digits[i];
          sum = sum + carryForward;
          if(sum > 9){
              carryForward = 1;
              output[i] = sum % 10;
          }else{
              carryForward = 0;
              output[i] = sum;
          }
      }
      if(carryForward > 0){
          int[] output2 = new int[digits.length+1];
          output2[0]=carryForward;
          for(int i=0,j=1;i<digits.length;i++){
              output2[j] = output[i];
          }
          return output2;
      }
      return output;
  }
}