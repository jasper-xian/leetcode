/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==0 && i!=arr.length-1) {
                for (int j=arr.length-2; j>i; j--) {
                    arr[j+1] = arr[j];
                }
                arr[i+1] = 0;
                i++;
            }
        }
    }
}
