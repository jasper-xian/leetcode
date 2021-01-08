/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
*/

class Solution {
    public int numSquares(int n) {
        if (n == 0)
            return 1;
        
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> visited1 = new HashSet();
        HashSet<Integer> visited2 = new HashSet();
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        int count = 1;
        
        int max = (int) Math.floor(Math.sqrt((double) n));
        for (int i=1; i<=max; i++) {
            list.add((int) Math.pow(i, 2));
            q1.offer((int) Math.pow(i, 2));
        }
        q2.offer(n);
        
        while (!q1.isEmpty() || !q2.isEmpty()) {
            int size1 = q1.size();
            while (size1 > 0) {
                int curr = (int) q1.poll();
                visited1.add(curr);
                
                if (curr == n)
                    return count;
                
                for (int i=0; i<list.size(); i++) {
                    int temp = curr + list.get(i);
                    if (!visited1.contains(temp))
                        q1.offer(temp);
                }
                size1--;
            }
            count++;
            
            int size2 = q2.size();
            while (size2 > 0) {
                int curr = (int) q2.poll();
                visited2.add(curr);
                
                if (q1.contains(curr))
                    return count;
                
                for (int i=0; i<list.size(); i++) {
                    int temp = curr - list.get(i);
                    if (!visited2.contains(temp))
                        q2.offer(temp);
                }
                size2--;
            }
            count++;
            
            Object[] check = q1.toArray();
            for (int i=0; i<check.length; i++) {
                if (q2.contains(check[i]))
                    return count;
            }
        }
        return -1;
    }
}
