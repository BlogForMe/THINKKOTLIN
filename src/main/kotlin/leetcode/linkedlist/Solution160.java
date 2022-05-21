package leetcode.linkedlist;

import leetcode.tool.ListNode;

public class Solution160 {
    public static void main(String[] args) {
//        ListNode intersectionNode = new Solution160().getIntersectionNode(new ListNode(new int[]{4, 1, 8, 4, 5}), new ListNode(new int[]{5, 0, 1, 8, 4, 5}));
//        System.out.println(intersectionNode);

        ListNode intersectionNode = new Solution160().getIntersectionNode(new ListNode(new int[]{2, 6, 4}), new ListNode(new int[]{1, 5}));
        System.out.println(intersectionNode);


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
//            pA = pA == null ? headB : pA.getNext();
//            pB = pB == null ? headA : pB.getNext();
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.getNext();
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.getNext();
            }
        }
        return pA;
    }
}


//作者：ityou-o
//        链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/shuang-zhi-zhen-yyds-dai-ma-jian-ji-teng-0bch/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
