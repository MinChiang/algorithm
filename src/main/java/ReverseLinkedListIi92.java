import common.ListNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-09 15:39
 */
public class ReverseLinkedListIi92 {

    // 1 -> 2 -> 3 -> 4 -> 5
    //   |  ^         ^ |
    // 1 -> 4 -> 3 -> 2 -> 5
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode pre = null, current = head, end = null, begin = null, next = null;

        while (count < left) {
            pre = current;
            current = current.next;
            count++;
        }
        begin = pre;
        end = current;
        pre = null;
        while (count <= right) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            count++;
        }

        end.next = current;
        if (begin == null) {
            head = pre;
        } else {
            begin.next = pre;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5});
//        System.out.println(listNode.toListString());

        ReverseLinkedListIi92 reverseLinkedListIi92 = new ReverseLinkedListIi92();
        System.out.println(reverseLinkedListIi92.reverseBetween(listNode, 2, 5).toListString());
    }

}
