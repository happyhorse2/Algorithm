package RememberTest;

import com.node.LinkNode;

//删除重复元素不保留重复元素
public class Problemfive {
   public static void main(String[] args) {
	   LinkNode head = construct();
	   LinkNode result = deleteDuplication(head);
	   while(result!=null) {
		   System.out.println(result.value);
		   result = result.next;
	   }
   }
   public static LinkNode deleteDuplication(LinkNode pHead){
	   LinkNode head=pHead;
       LinkNode pre = new LinkNode(-1);
       pre.next = head;
       LinkNode tpre= pre; 
       boolean isReapeat= false;
       while(head!=null&&head.next!=null){
           if(head.value==head.next.value){
               isReapeat = true;
               head.next = head.next.next;
               System.out.println("aaa");
           }else{
        	   System.out.println("bbb");
               if(isReapeat==true){
                   tpre.next = head.next;
               }else{
                   tpre = tpre.next;
               }
               head = head.next;
               isReapeat = false;
           }
       }
       return pre.next;
   }
   public static LinkNode construct() {
		LinkNode first = new LinkNode(1);
		LinkNode second = new LinkNode(1);
//		LinkNode third = new LinkNode(1);
//		LinkNode four = new LinkNode(1);
//		LinkNode five = new LinkNode(1);
//		LinkNode six = new LinkNode(1);
		first.next = second;
//		second.next = third;
//		third.next=four;
//		four.next = five;
//		five.next = six;
		return first;
	}
}
