//https://leetcode.com/problems/factorial-trailing-zeroes
import java.math.BigInteger;
class Solution {
    public int trailingZeroes(int n) {
        int[] digits = new int[30000];
        int res_size = 1;
        digits[0] = 1;
        for(int i = 2;i<=n;i++){
            res_size = multiply(digits,i,res_size);
        }
        int numberOfDigits = 0;
        for(int i=0;i<res_size;i++){
            if(digits[i] == 0){
                numberOfDigits++;
                continue;
            }
            break;
        }
        return numberOfDigits;
    }  
    public int multiply(int[] digits,int num,int res_size){
        int retValue = res_size;
        int carryForward = 0;
        for(int i = 0;i < retValue;i++){
            int product = (digits[i] * num)+carryForward;
            digits[i] = product % 10;
            carryForward = (int)Math.floor(product / 10);
        }
        while(carryForward != 0){
            retValue++;
            digits[retValue-1] = carryForward % 10;
            carryForward = (int)Math.floor(carryForward / 10);
        }
        return retValue;
    }
}