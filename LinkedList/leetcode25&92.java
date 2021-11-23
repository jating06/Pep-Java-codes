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
    ListNode oh = null;
ListNode ot = null;
ListNode th = null;
ListNode tt = null;
public void addFirst(ListNode node){
     if(th==null){
         th = node;
         tt = node;
     }
     else{
       node.next = th;
       th = node;
     }
}
public int length(ListNode node){
    ListNode curr = node;
    int len = 0 ; 
    while(curr!=null){
        curr = curr.next;
        len ++;
    }
    return len;
}
public ListNode reverseKGroup(ListNode head, int k) {
    if(head==null || head.next ==null){
        return head;
    }
    int length = length(head);
    if(length < k ){
        return head;
    }
    ListNode curr = head;
    while(curr!=null){
      int tk = k;
      
      while(tk-->0){
           ListNode forward = curr.next;
           curr.next =null; 
          addFirst(curr);
           curr = forward;         
          }
          if(oh==null){
              oh = th;
              ot = tt;
          }else{
              ot.next = th;
              ot = tt;
          }
         th = null;
         tt = null;
         length-=k;
         if(length<k){
               ot.next = curr; 
             curr = null;
           
         }

     }
     return oh ; 
 }
 public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head.next == null || n==m){
            return head;
         }
        ListNode curr = head;
        ListNode prev = null;
        int idx = 1;
        while(curr!=null){
            while(idx>=m && idx<=n){
                ListNode forward = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forward;
                idx++;
            }
            if(tt!=null){
                tt.next = curr;
                if(prev!=null){
                    prev.next = th;
                }
                else{
                    return th;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }
        return head;
    }
}