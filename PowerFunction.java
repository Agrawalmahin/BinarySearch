/*
    

Implement pow(x, n) % d.

In other words, given x, n and d,

find (x^n % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.


*/

    public class Solution {
        public int pow(int x, int n, int d) {
            
            if(x == 0) return 0;
            if(n == 0) return 1;
            if(d == 1) return 0;;
            long rem = 1;
            int check = 0;
            if(x < 0){
                x = Math.abs(x);
                if(n%2 != 0) check = 1;
            }
            long temp = x%d;
            while(n > 0){
                if(n%2 != 0){
                    rem = (rem*temp)%d;
                }
                temp = temp*temp;
                temp%= d;
                
                n/=2;
                if(rem > d) rem%=d;
            }
            if(check == 1) return d - (int)rem;
            return (int) rem;
        }
    }

