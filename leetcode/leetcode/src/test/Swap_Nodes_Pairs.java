package test;

import Model.ListNode;
/*
 * Swap Nodes in Pairs 
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_Pairs {
	public ListNode swapPairs(ListNode head) {
	      if(head == null)  
	        return null;  
	    ListNode helper = new ListNode(0);  
	    helper.next = head;  
	    ListNode pre = helper;  
	    ListNode cur = head;  
	    while(cur!=null && cur.next!=null)  
	    {  
	        ListNode next = cur.next.next;  
	        cur.next.next = cur;  
	        pre.next = cur.next;  
	        if(next!=null 
	        && next.next!=null)  
	            cur.next = next.next;  
	        else  
	            cur.next = next;  
	        pre = cur;  
	        cur = next;  
	    }  
	    return helper.next;  
	} 
	//≤‚ ‘
		public static void main(String[] args){
			//ListNode head = new ListNode(-1);
			ListNode head = new ListNode(1);
			ListNode n2 = new ListNode(2);
			ListNode n3 = new ListNode(3);
			ListNode n4 = new ListNode(4);
			ListNode n5 = new ListNode(5);
			head.next=n2;
			n2.next=n3;
			n3.next=n4;
			n4.next=n5;
			n5.next=null;
			
			
			Swap_Nodes_Pairs swapNodes = new Swap_Nodes_Pairs();
			ListNode l2 = swapNodes.swapPairs(head);
			
			ListNode b = l2;
			while(b!=null){
				System.out.println("l2 "+b.val);
				b=b.next;
			}
		}
}
