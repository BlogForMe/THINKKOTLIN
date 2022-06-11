package leetcode.string;

import junit.framework.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution151Test extends TestCase {

    public void testReverseWords() {
//        String s = "the sky is blue";
//        new Solution().reverseWords(s);

        Deque<String> deque = new ArrayDeque();
        deque.offerFirst("the");
        deque.offerFirst("sky");
        deque.offerFirst("is");
        deque.offerFirst("smile");
        String join = String.join(" ", deque);

        System.out.println(join);
    }
}