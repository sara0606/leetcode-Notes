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
           //set.contains(n) 是否包含n的引用
            if(set.contains(n)){
                return true;
            }
            else{
                //把n的引用存进去
                set.add(n);
                n=n.next;
            }
        }
        return false;
    }
}