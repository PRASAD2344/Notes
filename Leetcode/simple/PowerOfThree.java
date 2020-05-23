//https://leetcode.com/problems/power-of-three/solution/
//i = log3(n); i = log10(n)/log10(3);
class Solution {
  public boolean isPowerOfThree(int n) {
      return (Math.log10(n)/Math.log10(3) % 1 == 0);
  }
}