IP Questions{
    
public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
            ArrayList<Integer> ans = new ArrayList<>();
            LinkedList<Node> q = new LinkedList<>();
            q.addLast(node);
            ans.add(node.data);
            while(q.size()>0){
                int size = q.size();
                while(size-->0){
                    Node top =  q.removeFirst();
                    if(top.right!=null){
                        ans.add(top.right.data);
                        q.addLast(top.right);
                    }
                    if(top.left!=null){
                        ans.add(top.left.data);
                        q.addLast(top.left);
                    }
                }
            }
            Collections.reverse(ans);
            return ans;
    }

    Node DLLToBT(int n ){
        if(n==0){
            return null;
        }
        Node left = DLLToBST(n/2);
        Node root = temp ;
        root.prev = left;
        temp  = temp.next ;

        root.next = DLLToBST(n-n/2-1);
    }
    public static Tree LLToBT(Node head, Tree node) {
              LinkedList<Tree> q  = new LinkedList<>();
              node = new Tree(head.data);
              q.addLast(node);
              head = head.next;
              while(q.size()>0 && head!=null){
                  int size = q.size();
                  while(size-->0){
                      Tree top = q.removeFirst();
                      if(head!=null){
                          Tree left = new Tree(head.data); 
                          top.left = left;
                          q.addLast(left);
                      }
                      else{
                          break;
                      }
                      if(head.next!=null){
                          head = head.next;
                          
                          Tree right = new Tree(head.data); 
                          top.right = right;
                          q.addLast(right);
                          head = head.next;
                      }
                      else{
                          head = head.next;
                      }
                      
                    
                     
                      
                  }
              }
              return node;
             
    }

    Node head1 = null;
    Node head2 = null;
    Node prev = null;
    public List<Integer> merge(Node root1,Node root2)
    {       TreeToDLL_01(root1);
         
         prev = null;
           TreeToDLL_02(root2);
         List<Integer> ans = new ArrayList<>();
   while(head1!=null && head2!=null){
             
             if(head1.data<head2.data){
                 
                 ans.add(head1.data);
                 head1 = head1.right;
             }
             else{
                 ans.add(head2.data);
                 head2 = head2.right;
             }
         }
         while(head1!=null){
             ans.add(head1.data);
              head1 = head1.right;
         }
         
         while(head2!=null){
             ans.add(head2.data);
              head2 = head2.right;
         }
         
        return ans;
        
    }
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
          dfs(root,x);
        return lc>n/2||rc>n/2||n-(lc+rc)-1>n/2;
    }
    int lc = -1;
    int rc = -1;
    public int dfs(TreeNode root , int x) {
          if(root==null){
              return 0;
          }
           int left = dfs(root.left,x);
           int right = dfs(root.right,x); 
         if(root.val==x){
             lc = left;
             rc = right;
         }
        return left+right+1;
    }
     public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return null;
        }    
       
            root.left = removeLeafNodes(root.left,target);
            root.right = removeLeafNodes(root.right,target);
         if(root.val==target && root.left==null && root.right==null){
            
                 return null;
         }
        return root;
    } 
     public Node Populating_Next_Right_Pointers(Node root) {
        if(root==null){
            return null;
        }  
        
       if(root.left!=null && root.right!=null){
           root.left.next = root.right;
           if(root.next!=null){
               root.right.next = root.next.left;
           }
            
       } 

      
        
        connect(root.left);
         connect(root.right);
        return root;
    }

    class  Maximum_Product_of_Splitted_Binary_Tree {
    long maxProduct = 1;
    long sum = 0;
    int mod = 1000000007;
    public int maxProduct(TreeNode root) {
          sum = sum(root);
        maxProduct_(root);
        
         return (int)(maxProduct%mod);
    }
    public long maxProduct_(TreeNode root){
        if(root==null){
            return 0;
        }
        long ls = maxProduct_(root.left);
        long rs = maxProduct_(root.right);
        long n1 = ls+rs+root.val;
        long n2 = sum-n1;
        maxProduct = Math.max((n1*n2),maxProduct);
        return ls+rs+root.val;        
    }
    
    
    public long sum(TreeNode root){
      if(root==null){
          return 0;
      }
        long ls =   sum(root.left);
       long rs =  sum(root.right);
       return ls+rs+root.val;
        
    }

    
    
}

class  Longest_ZigZag_Path {
    class pair{
        int left; 
        int right;
        pair(int left , int right){
            this.left = left;
            this.right = right;
        }
        
    }
    int lpz = 0;
    public int longestZigZag(TreeNode root) {
        longestZigZag_(root);
           return lpz-1;
    }
     public pair longestZigZag_(TreeNode root) {
         if(root==null){
             return new pair(0 ,0);
         }
         pair lp = longestZigZag_(root.left);
         pair rp = longestZigZag_(root.right);
         pair np = new pair(0,0);
        
         lpz = Math.max(lp.right+1,Math.max(rp.left+1,lpz));
         np.left = lp.right+1;
         np.right = rp.left+1;
         return np;
    }
}
class Sum_Root_to_Leaf_Numbers {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
         sumNumbers_(root,0);
        return ans;
    }
    public void sumNumbers_(TreeNode root , int no) {
        if(root==null){
            return ;
            
        }
        if(root.left==null && root.right==null){
           
            ans+=(no*10+root.val);
        }
         sumNumbers_(root.left , no*10+root.val);
         sumNumbers_(root.right ,  no*10+root.val);
    }
    
}


}