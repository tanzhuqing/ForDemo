package com.tzq.leetcode.sulution.num234;

public class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode medien = head;
		ListNode tail = head.next;
		while (tail != null && tail.next != null) {
			medien = medien.next;
			tail = tail.next;
			if (tail != null) {
				tail = tail.next;
			}
		}
		ListNode h = medien.next;
		medien.next = null;
		while (h != null) {
			ListNode next = h.next;
			h.next = medien.next;
			medien.next = h;
			h = next;
		}
		ListNode l1 = head, l2 = medien.next;
		while (l2 != null) {
			if (l1.val != l2.val)
				return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		return true;

	}

}
