//https://leetcode.com/problems/sort-array-by-parity
class Solution {
  public int[] sortArrayByParity(int[] A) {
      if(A == null || A.length == 0 || A.length == 1)
          return A;
      int evenPointer = 0;
      int oddPointer = A.length - 1;
      while(evenPointer < oddPointer){
          if(A[evenPointer] % 2 == 0){
              evenPointer++;
              continue;
          }
          if(A[oddPointer] % 2 == 1){
              oddPointer--;
              continue;
          }
          int temp = A[evenPointer];
          A[evenPointer] = A[oddPointer];
          A[oddPointer] = temp;
      }
      return A;
  }
}