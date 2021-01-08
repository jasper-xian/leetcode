/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--) {
            int x = arr[i];
            arr[i] = max;
            max = Math.max(max, x);
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}
