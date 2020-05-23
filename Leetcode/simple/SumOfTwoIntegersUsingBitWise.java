//https://prismoskills.appspot.com/lessons/Bitwise_Operators/Sum_using_only_bitwise_ops.jsp
//https://leetcode.com/problems/sum-of-two-integers/
class Solution {
  public int getSum(int a, int b) {
      int commonBits = a & b;
      int unCommonBits = a ^ b;
      if(commonBits == 0)
          return unCommonBits;
      return getSum(unCommonBits,commonBits << 1);
  }
}