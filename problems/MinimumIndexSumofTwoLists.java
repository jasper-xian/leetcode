/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum.
If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
*/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<Integer, ArrayList<String>> dups = new HashMap<Integer, ArrayList<String>>();
        for (int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }
        
        int minKey = Integer.MAX_VALUE;
        for (int i=0; i<list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int key = map.get(list2[i]) + i;
                minKey = Math.min(key, minKey);
                if (!dups.containsKey(key)) {
                    dups.put(key, new ArrayList<String>());
                    dups.get(key).add(list2[i]);
                }
                else {
                    dups.get(key).add(list2[i]);
                }
            }
        }
        ArrayList<String> list = dups.get(minKey);
        String[] result = new String[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
