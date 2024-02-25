
class KthLargest {
    PriorityQueue<Integer> pq;
    int k = -1;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int num : nums ){
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
class KthSmallest {
       class pair{
            int ele;
            int r;
            int c;
           pair(int ele , int r,int c){
               this.ele = ele ;
               this.r = r ;
               this.c = c ; 
           }
       }
    public int kthSmallest(int[][] matrix, int k) {
          PriorityQueue<pair>pq = new PriorityQueue<>((pair a , pair b )->{
              return a.ele - b.ele;
          });
        int n = matrix.length;
        for(int i = 0 ; i<n ; i++){
            pq.add(new pair(matrix[i][0],i,0));
        }
       
        while(k-->1){
           pair p = pq.remove();
           if(p.c+1<n){
           pair np = new pair(matrix[p.r][p.c+1],p.r,p.c+1);
           pq.add(np);
           }
        }
        return pq.peek().ele;
    }
}
    class  K-th Smallest Prime Fraction {
    class pair{
        
        int r;
        int c;
        pair( int r , int c){
            this.r = r ;
            this.c = c ; 
        }
    }
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<pair> pq = new PriorityQueue<>((pair a , pair b)->{
            return A[a.r]*A[b.c]-A[b.r]*A[a.c];
        });
        int n = A.length;
        for(int i = 0 ; i<n;i++){
            pq.add(new pair(0,i));
            
        }
        while(K-->1){
            pair p = pq.remove();
            
            if(p.r+1<n){
                pair np = new pair(p.r+1,p.c);
                pq.add(np);
            }
        }
        pair p = pq.peek();
        return new int[]{A[p.r],A[p.c]};
    }
    }
     public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer>ans  = new ArrayList<>();
        for(int i = 0 ; i<nums1.length;i++){
            hs.add(nums1[i]);
        }
        for(int i = 0 ; i<nums2.length;i++){
            if(hs.contains(nums2[i])){
                ans.add(nums2[i]);
            }
            hs.remove(nums2[i]);
        }
        int a[] = new int[ans.size()];
        for(int i = 0 ; i<ans.size();i++){
            a[i] = ans.get(i);
        }
        
        return a;
    }

    class  Intersection of Two Arrays II {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0 ; i<nums1.length;i++){
            if(hs.containsKey(nums1[i])){
                  hs.put(nums1[i] , hs.get(nums1[i])+1);
            }
            else {
                hs.put(nums1[i],1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
       for(int i = 0 ; i<nums2.length;i++ ){
             if(hs.containsKey(nums2[i])){
                 ans.add(nums2[i]);
                 hs.put(nums2[i],hs.get(nums2[i])-1);
                  if(hs.get(nums2[i])==0){
               hs.remove(nums2[i]);
                }
             }
          
       }
        int a[] = new int[ans.size()];
        int i = 0 ;
       for(int ele : ans){
           a[i] = ans.get(i);
           i++;
       }
        return a;
    }
}
  public int longestConsecutive(int[] nums) {
     
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : nums){
            hs.add(ele);
        }
        int max = 0;
      
        for(int ele : nums){
            int prev = ele-1;
            int next = ele+1;
            hs.remove(ele);
            while(hs.contains(prev)){
                hs.remove(prev);
                prev--;
            }
            while(hs.contains(next)){
                hs.remove(next);
                next++;
            }
            int len = next - prev - 1;
          
             max = Math.max(len,max);
            
        }
        return max;
    }

     public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hs = new HashMap<>();
        for(int i = 0 ; i<strs.length;i++){
            String s = strs[i];
           char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
          
            
           String str=new String(charArray);

           
            if(hs.containsKey(str)){
               
                hs.get(str).add(s);
                
            }
            else{ hs.put(str,new ArrayList<>());
                 hs.get(str).add(s);
                 };
         
        }
         List<List<String>> a = new ArrayList<>();
        
       for(String str : hs.keySet()){
           a.add(hs.get(str));
       }
        
        
       
        return a;
    }

 public void longestSubarrayOfEqualZeroAndOnes(){
  int arr[] = {0,0,1,0,1,0};


    HashMap<Integer,Integer>umap = new HashMap<>();
    umap.put(0 , -1);

    int sum = 0;
    int len = 0;
    int val=0;
    for (int i = 0; i < arr.length; i++)
    {
        val = arr[i];
        if (arr[i] == 0)
            val = -1;

        sum += val;
        if (!umap.containsKey(sum))
            umap.put(sum,i);
        else
            len = Math.max(len, i - umap.get(sum));
    }
    System.out.println(umap);

     System.out.println(len);
 }
 	 public static int countSubarrWithEqualZeroAndOne(int[] nums) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int pcZero = 0 ;
        int pcOne = 0;
        hs.put(0,1);
        int noOfSubarrays=0;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]==0){
                pcZero++;
            }
            else{
                pcOne++;
            }
            int diff=pcZe ro-pcOne;
            if(hs.containsKey(diff)){
                noOfSubarrays+=hs.get(diff);
                hs.put(diff,hs.get(diff)+1);
            }
            else{
                hs.put(diff,1);
            }
        }
        return noOfSubarrays;
    }
 public static int Sub_Array_sum_divisible_by_K(int arr[],int k){
        HashMap<Integer,Integer> hs = new HashMap<>();
        int rem[] = new int[arr.length];
       
       hs.put(0,1);
       int noOfSubarrays=0;
       int ps = 0;
       for(int i = 0 ; i<arr.length;i++){
           ps+=arr[i];
           if(ps<0){
               ps = ps+k;
           }
           // satisfy prefixSum(i-1)%k = prefixSum(j-1)%k    
           if(hs.containsKey(ps%k)){
             noOfSubarrays+=hs.get(ps%k);  
            hs.put(ps%k,hs.get(ps%k)+1);
          }
          else{
              hs.put(ps%k,1);
          }
    }
    return noOfSubarrays;

    }

class MedianFinder {
     PriorityQueue<Integer> right = new PriorityQueue<>();
      PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
          if(left.size() == 0 || num<left.peek() ){
              left.add(num);
              
          }
   
        else
        if(right.size() == 0 ||num>right.peek()){
            right.add(num);
        }
        else{
            left.add(num);
        }
        if(left.size()-right.size()>=2){
            right.add(left.remove());
            
        }
        else if(right.size()>left.size()){
            left.add(right.remove());
        }
        
    }
    
    public double findMedian() {
       
        if(left.size()>right.size()){
            return left.peek();
        }
        
        else{
           return 1.0 * (left.peek()+right.peek())/2 ; 
        }
    }
     public Node copyRandomList_01(Node head) {
        Node curr = head;
       
        HashMap<Node,Node>hm = new HashMap<>();
        while(curr!=null){
            Node node = new Node(curr.val);
            hm.put(curr,node);
            curr = curr.next;
        }
        for(Node key : hm.keySet()){
             Node n  = hm.get(key);
            if(hm.containsKey(key.next))
             n.next = hm.get(key.next);
            if(hm.containsKey(key.random))
             n.random = hm.get(key.random);
        }
        
        return hm.get(head);
    }
    class Copy List with Random Pointer {
    public Node copyRandomList_02(Node head) {
        if(head==null) return head;
        copyList(head);
        copyRandomPointers(head);
        return ExtractNode(head);
    }
    public void copyList(Node node){
        Node curr = node;
        while(curr!=null){
            Node forwd = curr.next;
            Node n = new Node(curr.val); 
            curr.next = n ;
            n.next = forwd;
            curr = forwd;
        }
    }
    public void copyRandomPointers(Node node){
        Node curr = node;
        while(curr!=null ){
            if(curr.random !=null)
           curr.next.random = curr.random.next;
           curr = curr.next.next;
        }
        
    }
    public Node ExtractNode(Node node){
        Node curr1 = node;
        Node curr2 = node.next;
        Node h = curr2;
        while(curr1.next!=null && curr2.next!=null){
            Node forwd = curr2.next ;
            curr1.next = forwd;
            curr2.next = forwd.next;
            curr1 = forwd;
            curr2 = forwd.next;
        }
        curr1.next = null;
        curr2.next = null;
        return h;
        
    }
}
 /*Node *copyRandomList(Node *head) //03
    {

        copyList(head);
        setRandomPointers(head);
        return ExtractNode(head);
    }

    //Step 01 : CopyList
    void copyList(Node *node)
    {
        Node *curr = node;
        while (curr != nullptr)
        {
            Node *forw = curr->next;
            Node *node = new Node(curr->val);

            curr->next = node;
            node->next = forw;

            curr = forw;
        }
    }

    //Step 02:set Random pointers
    void setRandomPointers(Node *node)
    {
        Node *curr = node;
        while (curr != nullptr)
        {
            if (curr->random != nullptr)
                curr->next->random = curr->random->next;
            curr = curr->next->next;
        }
    }

    //Step 03: Extract Your copyied list
    Node *ExtractNode(Node *node)
    {
        Node *curr = node;
        Node *NewList = new Node(-1);
        Node *curr2 = NewList;

        while (curr != nullptr)
        {
            Node *forw = curr->next->next;

            Node *copyNode = curr->next;
            curr->next = forw;
            curr2->next = copyNode;

            curr = forw;
            curr2 = copyNode;
        }

        return NewList->next;
    }
};
*/
}

public int swimInWater(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int dirA[][] =  {{0,1},{0,-1},{-1,0},{1,0}};
        boolean vis[][] = new boolean[n][m];
        class pair{
            int data;
            int pos;
            pair(int data,int pos){
                this.data = data;
                this.pos = pos;
            }
        }
        PriorityQueue<pair>q = new PriorityQueue<>((pair a , pair b )->{
            return a.data - b.data;
        });
        q.add(new pair(grid[0][0],0));
        while(q.size()>0){
            
                pair top = q.remove();
                
                int x = top.pos/m;
                int y = top.pos%m;
                max = Math.max(max,grid[x][y]);
                if(x==n-1 && y==m-1 ) break;
                vis[x][y] = true;
                for(int i = 0 ; i<4;i++){
                    int r = x + dirA[i][0];
                    int c = y + dirA[i][1];
                    if(r>=0 && c>=0 && r<n && c<m && !vis[r][c]){
                       q.add(new pair(grid[r][c],r*m+c));
                    }
                }
                
            }
        
        return max;
    }
    class LRUCache {
      int size = 0;
      HashMap<Integer,Integer> hm = new HashMap<>();
      LinkedList<Integer> ll = new LinkedList<>();
    public LRUCache(int capacity) {
          this.size  = capacity; 
    }
    
    public   int get(int key)
    {
        if (!hm.containsKey(key))
            return -1;
        else
        {
            ll.remove((Integer)key);    // O(n)
            ll.addFirst(key); //O(1)
            return hm.get(key);   //O(1)
        }
    }

    
    public   void put(int key, int value)
    {
        if (hm.containsKey(key))
        {
            ll.remove((Integer)key);    // O(n)
            ll.addFirst(key); //O(1)
            hm.put(key,value); //O(1)
        }
        else //O(1)
        {
            hm.put(key,value);
            
            if (ll.size() == size)
            {
                hm.remove(ll.removeLast());
                
            }
            
            ll.addFirst(key);
        }
        
     
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Solution {
    public int compress(char[] arr) {
          int i = 0 ; 
          int j = 1 ; 
          char curr = arr[0];
          int freq = 1; 
          while(i<arr.length && j <arr.length){
                 if(arr[j]!=curr){
                     char ncurr = arr[j];
                     arr[i]  = curr ; 
                    
                      String s = freq+"";
                     int t = 0 ; 
                      if(freq!=1){
                     while(freq!=0){
                         i++;
                         arr[i] = s.charAt(t);
                         t++;
                         freq = freq/10;
                         
                     }
                      }
                     
                     i++;
                     curr = ncurr;
                     freq = 1; 
                     
                     
                 }
               else{
                   
                    freq++;
               }
              j++;
          }
         
                     arr[i]  = curr ; 
                     String s = freq+"";
                     int t = 0 ; 
                     if(freq!=1){
                         while(freq!=0){
                         i++;
                         arr[i] = s.charAt(t);
                         t++;
                         freq = freq/10;
                         
                     } 
                     }
                    
                     
                     i++;

        return i;
    }
}
