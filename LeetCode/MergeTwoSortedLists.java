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
      //指针aa bb
       // ListNode aa =a;
        //ListNode bb =b;
        ListNode listNode = new ListNode(-1);
        ListNode dummy = listNode;
             
        while(a !=null || b!= null){
            //使用if elseif else 在循环中保证每次只插入一种情况
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
                       
            //b<=a,存b的值，b后移
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