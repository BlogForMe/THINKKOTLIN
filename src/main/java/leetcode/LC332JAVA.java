package leetcode;

import java.util.*;

public class LC332JAVA {
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //from,             dest,    number
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            map.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> treeMap = map.get(from);
            treeMap.put(to, treeMap.getOrDefault(to, 0) + 1);
        }

        res.add("JFK");
        backtrack(tickets, map, 0);

        return res;
    }

    private boolean backtrack(List<List<String>> tickets, Map<String, TreeMap<String, Integer>> map, int progress) {
        if (progress == tickets.size()) {
            return true;
        }

        TreeMap<String, Integer> tos = map.get(res.get(res.size() - 1));
        if (tos == null || tos.isEmpty() || tos.size() == 0)
            return false;

        for (String str : tos.keySet()) {
            if (tos.get(str) == 0)
                continue;

            res.add(str);
            tos.put(str, tos.get(str) - 1);

            if (backtrack(tickets, map, progress + 1))
                return true;

            res.remove(res.size() - 1);
            tos.put(str, tos.get(str) + 1);
        }

        return false;
    }

//    作者：郭郭
//    链接：https://leetcode.cn/problems/reconstruct-itinerary/solutions/654811/java-bu-yong-ou-la-zhi-yong-hui-su-si-lu-4v83/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
