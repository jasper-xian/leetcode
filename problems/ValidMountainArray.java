/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
*/

class Solution {
    public boolean validMountainArray(int[] arr) {
        int flag = 0;
        
        if (arr.length < 3)
            return false;
        else if (arr[1] > arr[0]) {
            for (int i=1; i<arr.length; i++) {
                if (arr[i] == arr[i-1])
                    return false;
                else if (flag % 2 == 0 && arr[i] < arr[i-1])
                    flag++;
                else if (flag % 2 == 1 && arr[i] > arr[i-1])
                    flag++;
            }
        }
        else
            return false;
        
        if (flag == 1)
            return true;
        return false;
            
    }
}
