/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
*/

class Solution {
    
    public int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet();
        int count = 0;
        if (deads.contains(target))
            return -1;
        
        Queue<String> q = new LinkedList();
        q.offer("0000");
        visited.add("0000");
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String curr = q.poll();
                visited.add(curr);
                if (deads.contains(curr)) {
                    size--;
                    continue;
                }
                if (curr.equals(target))
                    return count;
                
                for (int i=0; i<4; i++) {
                    char x = curr.charAt(i);
                    int a = Integer.parseInt(String.valueOf(x));
                    int up = (a == 9 ? 0 : a + 1);
                    int down = (a == 0 ? 9 : a - 1);
                    String temp1 = curr.substring(0, i) + Integer.toString(up) + curr.substring(i+1);
                    String temp2 = curr.substring(0, i) + Integer.toString(down) + curr.substring(i+1);
                    if (!deads.contains(temp1) && !visited.contains(temp1)) {
                        q.offer(temp1);
                        visited.add(temp1);
                    }
                    if (!deads.contains(temp2) && !visited.contains(temp2)) {
                        q.offer(temp2);
                        visited.add(temp2);
                    }
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}
