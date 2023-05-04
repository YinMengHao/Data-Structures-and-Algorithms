package 链表;


/**
 * @author MH
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class _141_判断一个链表是否有环 {

	public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if (fast == slow) {
				return true;
			}
		}
        
		return false;
    }
}
