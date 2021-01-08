/*
Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.

Notice that the row index starts from 0.
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        
        double c = 1;
        for (int i=0; i<=rowIndex; i++) {
            list.add((int) c);
            c = (c * (rowIndex-i)) / (i+1);
        }
        return list;
    }
}
