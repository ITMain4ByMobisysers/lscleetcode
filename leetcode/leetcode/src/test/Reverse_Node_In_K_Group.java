package test;

import Model.ListNode;
//�ٴΣ�ע��ListNode head��headָ���ǵ�һ����ֵ�Ľڵ㣬���Ǻ��Ϊ��һ���ڵ�Ŀսڵ㣡����
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
        	//ÿ������Ҫ������һ������һֱ������
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
	//����pre��һ���ڵ㵽endǰһ���ڵ����������
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
		
        ListNode helper = new ListNode(-1);//��һ���ڵ�
        helper.next=head;
        ListNode pre = helper;
        
        ListNode curfirst = head;//��ǰ��ĵ�һ���ڵ�
        ListNode curlast = null;//��ǰ������һ���ڵ�
        
        ListNode nextfirst=null;
        ListNode nextlast = null;
        
        while(curfirst!=null&&curfirst.next!=null){
        	//ÿ����k�����������k������ȷ��������׽ڵ㣬��������
            int curi=1;
            ListNode curindex = curfirst;
            while(curindex!=null&&curi<=k){            	
            	curi++;
            	curindex = curindex.next;
            	if(curi==k){
                	//ȷ���������һ��Ԫ��
                	curlast=curindex;
            		//�ж��Ƿ������һ��
            		if(curlast.next!=null){
            			//�ж���һ���Ƿ�ȫ
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
            		//����Ϊ�ı�����˳��
                    ListNode a = curfirst;
                    ListNode b = null;
                    //��������
                    while(a.next!=null){
                    	b=a.next;
                    	a.next.next=a;
                        a=b;                
                    }
                    pre.next=curlast;
                    //�����һ��ȫ����ָ����һ������һ��
            		if(nextlast!=null){
            			curfirst.next=nextlast;
            		}            		
            		//�����һ�鲻ȫ����ָ����һ��ĵ�һ��
            		else
            			curfirst.next=nextfirst;	
            		pre=curfirst;
            		curfirst=nextfirst;
                }
            }
            
       
        }            		                      
        return helper.next;
    }*/
	//����
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
