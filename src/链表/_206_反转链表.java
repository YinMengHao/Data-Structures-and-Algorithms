package 链表;


/**
 * @author MH
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class _206_反转链表 {

	public ListNode reverseList(ListNode head) {
//		return func1(head);
		return func2(head);
    }
	
	// 迭代（非递归）实现 
	private ListNode func2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode();
		newHead.next = null;
		
		ListNode p = head, q = null;
		while (p != null && p.next != null) {
			q = p.next;
			p.next = newHead.next;
			newHead.next = p;
			p = q;
		}
		
		return newHead;
	}
	
	// 递归实现
	private ListNode func1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
