//https://leetcode.com/problems/number-of-1-bits/solution/
public class Solution {
  public int hammingWeight(int n) {
      int numberOfOnes = 0;
      int mask = 1;
      for(int i=1;i<=32;i++){
          if((n & mask) != 0)
              numberOfOnes++;
          mask <<= 1;
      }
      return numberOfOnes;
  }
}