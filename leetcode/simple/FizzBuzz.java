//https://leetcode.com/problems/fizz-buzz/
class Solution {
  public List<String> fizzBuzz(int n) {
      List<String> retValue = new ArrayList<>();
      String fizzBuzz = "FizzBuzz";
      String fizz = "Fizz";
      String buzz = "Buzz";
      for(int i=1;i<=n;i++){
          String loopInsert = Integer.toString(i);
          if(i%3 == 0){
              loopInsert = i%5 == 0 ? fizzBuzz: fizz;
          }else if(i%5 == 0){
              loopInsert = i%3 == 0 ? fizzBuzz : buzz;
          }
          retValue.add(loopInsert);
      }
      return retValue;
  }
}