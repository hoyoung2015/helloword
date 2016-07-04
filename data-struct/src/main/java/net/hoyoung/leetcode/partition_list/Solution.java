package net.hoyoung.leetcode.partition_list;

public class Solution {
	public ListNode partition(ListNode head, int x) {
		if(head==null) return null;
		ListNode rt = head;
		ListNode cur = head;
		ListNode pre = null;
		ListNode tar = null;
		while(cur!=null){
			if(cur.val >= x){
				tar = pre;//当第一个数就>=x时，tar是null
				pre = cur;
				break;
			}
			pre = cur;
			cur = pre.next;
		}

		cur = pre.next;
		while(cur!=null){
			if(cur.val<x){//挪动
				pre.next = cur.next;
				if(tar==null){
					rt = cur;
					cur.next = head;
					tar = cur;
				}else{
					cur.next = tar.next;
					tar.next = cur;
					tar = tar.next;
				}
				
			}else{
				pre = cur;
			}
			cur = pre.next;
		}
		
		return rt;
	}
public static void main(String[] args) {
	ListNode h1 = new ListNode(1);
	ListNode h2 = new ListNode(4);
	ListNode h3 = new ListNode(3);
	ListNode h4 = new ListNode(2);
	ListNode h5 = new ListNode(5);
	ListNode h6 = new ListNode(2);
	h1.next = h2;
	h2.next = h3;
	h3.next = h4;
	h4.next = h5;
	h5.next = h6;
	
	ListNode t = new Solution().partition(h1, 3);
	
	while(t!=null){
		System.out.println(t.toString());
		t = t.next;
	}
	
	
}
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}
		
	}
}
