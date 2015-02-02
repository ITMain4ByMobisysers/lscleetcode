package test;

import Model.ListNode;
//再次，注意ListNode head的head指的是第一个有值的节点，而非后继为第一个节点的空节点！！！
/*
 * Reverse Nodes in k-Group 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 * You may not alter the values in the nodes, only nodes itself may be changed.

 * Only constant memory is allowed.

 * For example,
 * Given this linked list: 1->2->3->4->5

 * For k = 2, you should return: 2->1->4->3->5

 * For k = 3, you should return: 3->2->1->4->5
 */
public class Reverse_Node_In_K_Group {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){  
        	return null;  
        }  
        ListNode helper = new ListNode(0);  
        helper.next = head;  
        int count = 0;  
        ListNode pre = helper;  
        ListNode cur = head;  
        while(cur != null)
        {  
        	//每到本组要求的最后一个，则一直往后走
        	count ++;  
        	ListNode next = cur.next;  
        	if(count == k)  
        	{  
        		pre = reverse(pre, next);  
        		count = 0;     
        	}  
        	cur = next;  
        }  
        return helper.next;  
    }
	//将从pre下一个节点到end前一个节点的链表逆序
    private ListNode reverse(ListNode pre, ListNode end)  
    {  
    	if(pre==null || pre.next==null)  
    		return pre;  
    	ListNode nextpre = pre.next;  
    	ListNode cur = pre.next.next;  
    	while(cur!=end)  
    	{  
    		ListNode next = cur.next;  
    		cur.next = pre.next;  
    		pre.next = cur;  
    		//System.out.print(cur.val+" ");
    		cur = next;
    		
    	}  
    	nextpre.next = end;  
    	return nextpre;  
    }  
	/*public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null){
			return null;
		}
		else if(head!=null&&k==0){
			return head;
		}
		else if(head!=null&&k==1){
			return head;
		}
		
        ListNode helper = new ListNode(-1);//第一个节点
        helper.next=head;
        ListNode pre = helper;
        
        ListNode curfirst = head;//当前组的第一个节点
        ListNode curlast = null;//当前组的最后一个节点
        
        ListNode nextfirst=null;
        ListNode nextlast = null;
        
        while(curfirst!=null&&curfirst.next!=null){
        	//每次走k步，如果能走k步，则确定下组的首节点，交换本组
            int curi=1;
            ListNode curindex = curfirst;
            while(curindex!=null&&curi<=k){            	
            	curi++;
            	curindex = curindex.next;
            	if(curi==k){
                	//确定本组最后一个元素
                	curlast=curindex;
            		//判断是否存在下一组
            		if(curlast.next!=null){
            			//判断下一组是否全
            			nextfirst = curlast.next;
            			int nexti=1;
            			ListNode nextindex = nextfirst;
            			while(nextindex!=null&&nexti<=k){
            				nexti++;
            				nextindex=nextindex.next;      
            				if(nexti==k){
                				nextlast=nextindex;
                			}
            			}            			
            		}
            		else{
            			nextfirst=null;
            		}
            		//以下为改变链表顺序
                    ListNode a = curfirst;
                    ListNode b = null;
                    //组内逆序
                    while(a.next!=null){
                    	b=a.next;
                    	a.next.next=a;
                        a=b;                
                    }
                    pre.next=curlast;
                    //如果下一组全，则指向下一组的最后一个
            		if(nextlast!=null){
            			curfirst.next=nextlast;
            		}            		
            		//如果下一组不全，则指向下一组的第一个
            		else
            			curfirst.next=nextfirst;	
            		pre=curfirst;
            		curfirst=nextfirst;
                }
            }
            
       
        }            		                      
        return helper.next;
    }*/
	//测试
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
		
		int k=3;
		Reverse_Node_In_K_Group reverseNodeKGroup = new Reverse_Node_In_K_Group();
		ListNode l2 = reverseNodeKGroup.reverseKGroup(head, k);
		
		ListNode b = l2;
		while(b!=null){
			System.out.println("l2 "+b.val);
			b=b.next;
		}
	}
}
