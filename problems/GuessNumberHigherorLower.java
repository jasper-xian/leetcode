/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns 3 possible results:

-1: The number I picked is lower than your guess (i.e. pick < num).
1: The number I picked is higher than your guess (i.e. pick > num).
0: The number I picked is equal to your guess (i.e. pick == num).
Return the number that I picked.
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1; int right = n;
        if (guess(left) == 0)
            return left;
        if (guess(right) == 0)
            return right;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return -1;
    }
}
