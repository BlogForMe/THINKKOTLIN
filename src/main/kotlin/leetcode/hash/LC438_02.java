package leetcode.hash;

import java.util.ArrayList;
import java.util.List;

public class LC438_02 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        // 该循环确保[lo, hi)的区间中的出现的字符总是p的一个子集
        // PS1: "na"是"and"的子集，而"nn"则不是"and"的子集
        // PS2: 除了评论中那个边际条件，前面已经有评论解释过了
        while (hi < s.length()) {
            char c = s.charAt(hi);
            if (cnt[c] > 0) {
                // 子集条件满足，右移增大窗口
                char c1 = s.charAt(hi++);
                cnt[c1]--;
                // 窗口长度 == p.len，且窗口内字符是p的子集
                // <=> (充要条件) s.substring(lo, hi)是p的同字母异序词
                if (hi - lo == p.length()){
                    res.add(lo);
                }
            } else {
                // 再右移hi不可能满足子集条件，
                // 右移左边界lo、复位计数器，直到这个条件（子集条件）再次满足
                char c1 = s.charAt(lo++);
                cnt[c1]++;
            }
        }
        return res;
    }
}
