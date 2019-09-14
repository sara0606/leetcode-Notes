/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode n) {
        Set<ListNode> set = new HashSet<>();
        while(n!= null){
            //HashSet
           //set.contains(n) �Ƿ����n������
            if(set.contains(n)){
                return true;
            }
            else{
                //��n�����ô��ȥ
                set.add(n);
                n=n.next;
            }
        }
        return false;
    }
}