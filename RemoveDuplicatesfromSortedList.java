/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode a) {
        ListNode listNode = a;
        while( a != null&& a.next != null ){
            if(a.val == a.next.val)
                a.next=a.next.next;
           else a=a.next;
        }
        return listNode;
    }
 public ListNode deleteDuplicates2(ListNode a) {
        ListNode listNode = new ListNode(-1);
        ListNode dummy = listNode;
        while(a != null){
            //����&&���� �����һ������ȷ����ô�Ͳ�������жϵڶ�����ֵ  Ҫ��֤����һ��Ԫ�� 
            while(a.next != null&&a.val == a.next.val){
                a = a.next;
            }
            listNode.next = new ListNode (a.val);//����a��ֵ
            listNode = listNode.next;
            a = a.next;
                     
        }
        return dummy.next;
        
    }
}