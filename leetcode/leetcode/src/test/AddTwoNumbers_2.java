package test;

import Model.ListNode;
/*
 * ע�⣺leetcode�ϵ���Ŀ��������head(1,next)->(2,next)->(3,null)
 * ����һ���ڵ���Ǳ�ͷ���������ݽṹ���Ͻ��ܵ�{ͷ�ڵ�valΪ�գ�ͷ�ڵ㲻��ֵֻ��ָ�룬������ֵ�ýڵ��Ǵ�ͷ������һ���ڵ㿪ʼ}
 * 
 */

public class AddTwoNumbers_2 {
	//����������Ϊ������
	public Long listTOLong(ListNode l){
		long num = 0;
		long temp =1;
		int i=0;
		while(l!=null){
			num = num+l.val*temp;
			temp=temp*10;
			l=l.next;
		}
		return num;
	}	
	public ListNode longToList(Long num){		
		ListNode l3 = new ListNode(-1);
		l3.next = null;
		ListNode c = l3;
		c.val=(int)(num%10);
		num = num/10;
		while(num>0){		
			ListNode cnext = new ListNode((int)(num%10));
			cnext.next=null;
			c.next=cnext;
			num = num/10;
			c=c.next;
		}
		return l3;
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null){
			return null;
		}
		//����תlong��
		long num1 = listTOLong(l1);
		long num2 = listTOLong(l2);
		//System.out.println("l1:"+num1+" l2:"+num2);
		long num3 = num1+num2;
		//System.out.println("l3:"+num3);
		//long��ת����
		ListNode l3 = longToList(num3);
		return l3;
		
	}
	//����һ��������Ĳ���
	/*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//���Ϊl1Ϊ����l2Ϊ��
		if(l1==null&&l2==null){
			return null;
		}
		//���һ��ʼ��l1Ϊ�գ�����Ϊl2
		else if(l1!=null&&l2==null){
			return l2;
		}
		//���һ��ʼ��l2Ϊ�գ�����Ϊl1
		else if(l1==null&&l2!=null){
			return l1;
		}
		//l1��l2����Ϊ��
		ListNode a=l1;
		ListNode b=l2;
		int t = 0;//��λ
		int m=0;//�Ӻ͵�ֵ
		ListNode l3 = new ListNode(-1);
		l3.next=null;
		ListNode c =l3;
		do{
			m=(t+a.val+b.val)%10;//�Ӻ͵�ֵ
			t=(t+a.val+b.val)/10;//��λ
			c.val=m;
			//a.next,b.next����Ϊ��
			if(a.next!=null&&b.next!=null){
				a=a.next;
				b=b.next;
				ListNode cnext = new ListNode(-1);
				c.next=cnext;
				c=c.next;
			}
			//a.next,b.next��Ϊ��
			else if(a.next==null&&b.next==null){
				//�н�λ
				if(t>0){
					ListNode cnext = new ListNode(t);
					cnext.next=null;
					c.next=cnext;
					return l3;
				}
				return l3;				
			}
			//a.nextΪ��,b.next��Ϊ��
			else if(a.next==null&&b.next!=null){
				//��ʱ�϶���ҪΪc������һ��Ԫ�أ�������ô�Ӻ͵�����
				b=b.next;
				
				ListNode anext = new ListNode(0);
				anext.next=null;
				a.next = anext;
				a=a.next;
				
				ListNode cnext = new ListNode(0);
				cnext.next=null;
				c.next = cnext;
				c=c.next;
			}
			//a.next��Ϊ�գ�b.nextΪ��
			else if(a.next!=null&&b.next==null){
				//��ʱ�϶���ҪΪc������һ��Ԫ�أ�������ô�Ӻ͵�����
				a=a.next;
				ListNode bnext = new ListNode(0);
				bnext.next=null;
				b.next = bnext;
				b=b.next;
				ListNode cnext = new ListNode(0);
				cnext.next=null;
				c.next = cnext;
				c=c.next;									
			}
			
		}while(a!=null||b!=null||t>0);
		return l3;
		
    }*/
	
	public static void main(String[] args){
		
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(5);		
		l11.next=l12;
		l12.next=l13;
		l13.next=null;
		ListNode a = l11;
		while(a!=null){
			System.out.println("l1 "+a.val);
			a=a.next;
		}
		
		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);		
		l21.next=l22;
		l22.next=l23;
		l23.next=null;
		
		ListNode b = l21;
		while(b!=null){
			System.out.println("l2 "+b.val);
			b=b.next;
		}				
		AddTwoNumbers_2 addTwoNumbers_2 = new AddTwoNumbers_2();		
		ListNode l3=addTwoNumbers_2.addTwoNumbers(l11,l21);		
		if(l3!=null){
			ListNode d=l3;
			while(d!=null){
				System.out.println(" "+d.val);
				d=d.next;
			}			
		}	    
	}

}
