    class Question{
    public ListNode middleNode(ListNode head) {
           if(head==null || head.next==null){
               return head;
           }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next;
        }
        return slow;
    }
     public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
               return head;
           }
        ListNode prev = null;
        ListNode curr = head;
        
        
        while(curr!=null){
           ListNode next = curr.next;
           curr.next = prev;
            prev = curr;
            curr = next;
            
          
            
        }
        return prev;
    }
     public ListNode getMidNode2(ListNode node) { //lower bound mid
        if (node == null || node.next == null)
            return node;
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

     public boolean isPalindrome(ListNode head) {
            if(head==null || head.next==null){
               return true;
           }
           ListNode mid = getMidNode2(head);
           ListNode nh = reverseList(mid);
           ListNode p1 = head;
           ListNode p2 = nh ;
           while(p1!=null && p2!=null){
               if(p1.val == p2.val){
                   p1 = p1.next;
                   p2 = p2.next;
               }
               else{
                   return false;
               }
           }
           return true;
    }
     public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null)
            return head;
        if (n == 1 && head.next == null)
            return null;

        ListNode slow = head, fast = head;
        while (n-- > 0) {
            fast = fast.next;
            // if(fast==null && n > 0) return null;
        }

        if (fast == null)
            return slow.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
     public void reorderList(ListNode head) {
         if(head==null || head.next==null){
               return ;
           }
           ListNode mid = getMidNode2(head);
           ListNode nh = reverseList(mid);
           mid.next = null;
           ListNode p1 = head;
           ListNode p2 = nh ;
           while(p2!=null){
               ListNode next = p1.next;
               p1.next = p2;
               p1 = p2;
               p2 = next;
           }
           return ;

    }
     public mergeTwoLists_01(ListNode l1, ListNode l2) {
        if(l1==null || l2==null ) {
            return l1==null?l2:l1;
        }
         ListNode node  = new ListNode(-1);
         ListNode dummy = node;
         ListNode prev = null;
         while(l1!=null && l2!=null){
             
             if(l1.val <= l2.val){
                 node.next = l1;
                 prev = l1;
                 l1 = l1.next;
             }
             else{
                 node.next = l2 ;
                 prev = l2;
                 l2 = l2.next ;
             }
             node = node.next ;
         }
         if(l1!=null){
             prev.next = l1;
         }
        else if(l2!=null){
            prev.next = l2;
        }
       
        return dummy.next;
    }
        public ListNode mergeTwoLists_02 (ListNode l1, ListNode l2) {
        if(l1==null || l2==null ) {
            return l1==null?l2:l1;
        }
       ListNode dummy = new ListNode(-1);
       ListNode node = dummy ;
       while(l1!=null && l2!=null){
           if(l1.val<=l2.val){
               ListNode next = node.next;
               node.next = l1;
               node = l1;
               l1 = l1.next;
           }
           else{
               ListNode next = node.next;
                node.next = l2;
               node = l2;
               l2 = l2.next;
               
           }
           
       }
        
        while(l1==null && l2!=null){
            node.next = l2;
            node=l2;
            l2 = l2.next;
        }
         while(l2==null && l1!=null){
            node.next = l1;
            node=l1;
            l1 = l1.next;
        }
        return dummy.next;
    }
         public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
       ListNode nhead = head.next;
        
        while(p1.next!=null && p2.next!=null){
          
             p1.next = p2.next ;
             p1 = p1.next ;
             
             p2.next = p1.next ;
             
             p2 = p2.next;
           }
           p1.next = nhead;
           return head;

    }
     public boolean hasCycle(ListNode head) {
           if(head==null || head.next==null){
            return false;
        }
        ListNode slow  = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
     public ListNode detectCycle(ListNode head) {
              if(head==null || head.next==null){
            return null;
        }
        ListNode slow  = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast) return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return  slow;
    }
     public ListNode deleteDuplicates(ListNode head) {
         ListNode curr = head;
        while(curr!=null && curr.next!=null){
            ListNode next = curr.next;
            while(next!=null && next.val==curr.val){
                next = next.next;
                
            }
            curr.next = next;
            curr = curr.next;
        }
        return head;
    }
    //203 leetcode
      public ListNode removeElements(ListNode head, int val) {
           if(head==null|| head.next==null && head.val==val   ){
               return null;
           }
        
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode curr = node;
       while(curr!=null){
           ListNode next = curr.next;
           while(next!=null && next.val == val){
               next = next.next;
           }
           
           curr.next = next;
           curr = curr.next;
       }
        node = node.next;
        return node;
        
    }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null) return null;
        if(headB==null) return null;
        if(headA == headB) return headA;
         ListNode curr = headA;
         while(curr.next!=null){
          curr = curr.next;
         }
         curr.next = headB;
         ListNode intersection = detectCycle(headA);
            curr.next = null;
         if(intersection == null) return null;
         
         return intersection;
    }
        public ListNode sortList(ListNode head) {
               if(head == null || head.next==null) return head;
               ListNode mid = getMidNode2(head);
              ListNode mnext = mid.next;
               mid.next = null;
              return  mergeTwoLists(sortList(head),sortList(mnext));
    }
     public ListNode mergeKLists(ListNode[] lists,int si , int ei) {
           if(si==ei) return lists[si];

           int mid = (si+ei)/2;
          return        mergeTwoLists(mergeKLists(lists,si,mid),mergeKLists(lists,mid+1,ei));
    }
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           int carry = 0;
         while(l1!=null || l2!=null){
             
             int sum = 0;
             if(l1!=null){
                 sum+=l1.val;
                 l1 = l1.next;
             }
             if(l2!=null){
                 sum+=l2.val;
                 l2 = l2.next;
             }
             sum+=carry;
             addLast(new ListNode(sum%10));
             carry = sum/10;
             
         }
        if(carry!=0) addLast(new ListNode(carry));
        return th;
    }  
        }

         


    }