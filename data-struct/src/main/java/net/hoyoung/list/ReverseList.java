package net.hoyoung.list;

import java.util.LinkedList;

/**
 * Created by hoyoung on 16-4-20.
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode head = n1;
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        head = reverse(n1);
        while (head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }

    }



    static ListNode reverse(ListNode head){

        ListNode prev = null;

        while (head != null){
            ListNode tempNext = head.next;

            head.next = prev;
            prev = head;
            head = tempNext;
        }
        return prev;
    }
    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
