/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        Queue<Integer> lessQueue = new LinkedList<>();
        Queue<Integer> greaterQueue = new LinkedList<>();
        
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        
        while (head != null){
            if (head.val < x){
                lessQueue.add(head.val);
            }
            else {
                greaterQueue.add(head.val);
            }
            head = head.next;
        }
        
        ListNode result = null;
        ListNode start = null;
        while(lessQueue.isEmpty() == false){
            if (result == null){                
                result = new ListNode(lessQueue.remove(), null);
                start = result;
            }
            else {
                result.next = new ListNode(lessQueue.remove(), null);
                result = result.next;
            }            
        }
        
        while(greaterQueue.isEmpty() == false){
            if (result == null){
                result = new ListNode(greaterQueue.remove(), null);
                start = result;
            }
            else {
                result.next = new ListNode(greaterQueue.remove(), null);
                result = result.next;
            }            
        }
        
        return start;
    }
}
