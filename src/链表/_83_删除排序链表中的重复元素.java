package 链表;


/**
 * @author MH
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode tempNode = head;
		ListNode tempNextNode = head.next;
		while (tempNextNode != null) {
			if (tempNextNode.val == tempNode.val) {
				tempNode.next = tempNextNode.next;
			} else {
				tempNode = tempNode.next;
			}
			tempNextNode =  tempNextNode.next;
		}
		return head;
    }
}
