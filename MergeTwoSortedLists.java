/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
      //ָ��aa bb
       // ListNode aa =a;
        //ListNode bb =b;
        ListNode listNode = new ListNode(-1);
        ListNode dummy = listNode;
             
        while(a !=null || b!= null){
            //ʹ��if elseif else ��ѭ���б�֤ÿ��ֻ����һ�����
            if(a== null){
                listNode.next = new ListNode(b.val);
                listNode = listNode.next;
                b=b.next;
            }           
           else if(b == null){
                listNode.next = new ListNode(a.val);
                 listNode = listNode.next;
                a = a.next;
            }
                       
            //b<=a,��b��ֵ��b����
           else if(a.val >= b.val){
              listNode.next = new ListNode(b.val);
              listNode = listNode.next;
              b = b.next;
                
          }else{
              listNode.next = new ListNode(a.val);
                listNode = listNode.next;
              a = a.next;     
          }
                                     
        }
        return dummy.next;
        
        
    }
}