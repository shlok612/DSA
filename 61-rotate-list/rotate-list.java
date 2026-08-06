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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        int stop=len-k;
        ListNode last=head;
        while(stop>1){
            last=last.next;
            stop--;
        }
        ListNode first=last.next;
        last.next=null;
        if(k==1){
            first.next=head;
            return first;
        }
        ListNode mid=first;
        while(k>1){
            mid=mid.next;
            k--;
        }
        mid.next=head;
        return first;
    }
}