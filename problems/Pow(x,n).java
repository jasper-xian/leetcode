/*
Implement pow(x, n), which calculates x raised to the power n (i.e. x^n).
*/

class Solution {
    public double myPow(double x, int n) {
        if (n==0)
            return 1;
        double half = myPow(x, n/2);
        if (n > 0) {
            if (n%2==0)
                return half * half;
            else
                return half * half * x;
        }
        else {
            if (n%2==0)
                return half * half;
            else
                return half * half / x;
        }
    }
}
