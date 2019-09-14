/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        //全是空的情况
        if(a == null && b == null){
            return new ListNode(0);
        }
        //进位
        int carry=0;
        //新的链表 存结果 头结点设置为-1
        ListNode listNode = new ListNode(-1); 
        ListNode dummy = listNode;
        //链表一个不为空的情况，有进位的情况
       while(a != null || b != null || carry > 0){
          //对应位 相加的和 会受到自进位carry的影响
           int sum =carry;
           //新的一轮对应位数的值相加，先把进位设置为0
           carry = 0;
           if(a != null)  sum += a.val;
           if(b != null)  sum += b.val;
           
           if(sum > 9){
               //取个位
               sum %= 10;
               //进位+1
               carry = 1;
           }
           
           //把结果sum保存到链表中 因为只有一个头结点 每次保存都要new一个
          
           listNode.next = new ListNode(sum);
           //指针后移
           listNode = listNode.next; 
           
           //当前指针位置的值已经加完了，如果a，b链表后边还有值，指针后移，继续进行下一个数的相加，如果没有就跳出去
           if(a!= null) a= a.next;
           if(b!= null) b= b.next;
                             
        }
        //把结果返回 把头节点去掉       
        return dummy.next;  
    }
        
}
