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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = head;
        int k = 0;
        while(k<n){
            fast=fast.next;
            k++;
        }
        if(fast==null){
            return dummy.next;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow.next==null){
            return null;
        }
        slow.next=slow.next.next;
        return dummy;
    }
}