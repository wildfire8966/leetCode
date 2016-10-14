package AddTwoNum;

/**
 * Created by yuanye8 on 2016/10/14.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode rs = new ListNode(-1);
        ListNode tmp = rs;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            ListNode l3 = new ListNode(carry % 10);
            tmp.next = l3;
            tmp = tmp.next;
            carry = carry / 10;
        }

        if (carry == 1) {
            ListNode l3 = new ListNode(1);
            tmp.next = l3;
        }

        return rs.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
