/*
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.
*/

class Solution {
    
    HashMap<Integer, Boolean> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet();
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0);
        for (int i=0; i<rooms.size(); i++) {
            if (!map.containsKey(i))
                return false;
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int room) {
        if (visited.contains(room))
            return;
        map.put(room, true);
        visited.add(room);
        
        List<Integer> curr = rooms.get(room);
        for (int i=0; i<curr.size(); i++) {
            dfs(rooms, curr.get(i));
        }
    }
}
