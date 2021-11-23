class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }
    static Node construct(int si, int ei, int input[]) {

        if (si > ei) {
            return null;

        }
        int mid = (si + ei) / 2;
        Node node = new Node(input[mid]);
        node.left = construct(si, mid - 1, input);
        node.right = construct(mid + 1, ei, input);
        return node;
    }
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    Node prev = null;

    public boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
        if (prev == null) {
            prev = root;
        } else
        if (root.data <= prev.data) {

            return false;
        } else {
            prev = root;
        }

        if (!isValidBST(root.right)) return false;

        return true;
    }
    static Node a = null;
    static Node b = null;
    static Node c = null;
    public static boolean recoverTree(Node node) {
        if (node == null) return false;
        if (recoverTree(node.left)) return true;

        if (c != null && node.data < c.data) {
            b = node;
            if (a == null) {
                a = c;
            } else {
                return true;
            }


        }
        c = node;
        if (recoverTree(node.right)) return true;

        return false;
    }
    public static void recoverTree_(Node node) {
        if (recoverTree(node)) {
            if (a != null) {
                int t = a.data;
                a.data = b.data;
                b.data = t;
            }
        }
    }
    public static int LCA(Node node , int a , int b){
        if(node == null ){
            return -1;
        }
         if(node.data > a && node.data > b){
             return LCA(node.left, a,b);
         }
         else if(node.data < a && node.data < b){
           return LCA(node.right, a,b);
         }
          else{
              return node.data;
          }
          
    }
    /* public static int LCA_02(Node node , int a , int b){
        if(node == null ){
            return -1;
        }
         if(node.data > a && node.data > b){
             return LCA_02(node.left, a,b);
         }
         else if(node.data < a && node.data < b){
           return LCA_02(node.right, a,b);
         }
          else{
                 return find(curr, a) && find(curr, b) ? curr->data : -1; 
          }
          
    }*/
    public static void PreAndSucc(Node node,int data){
            Node succ = null ;
            Node pre = null ;
            while(node != null){
            if(node.data == data){
                if(node.right == null) System.out.println(succ!=null ? succ.data : "-1" );
                   else{
                       succ = node.right;
                          while(succ.left!=null){
                      succ = succ.left;
                }
                System.out.println(succ!=null ? succ.data : "-1" );
                   }
               if(node.left==null) System.out.println(pre!=null ? pre.data : "-1" );
               else{
                   pre = node.left;
                   while(pre.right!=null){
                       pre = pre.right;
                   }
                   System.out.println(pre!=null ? pre.data : "-1" );
               }   

               break;

                
            }
            if(data <  node.data){
                succ = node;
                node=node.left;
            }
            else if(data > node.data){
                pre = node;
                node=node.right;
            }

            }

    }
    static int idx = 0 ;
    public static Node ConstructBSTWPreorder(int arr[], int lb, int rb){  //You can use when dont want to contruct the tree 
        if( idx == arr.length||arr[idx] < lb || arr[idx] > rb ){
            return null;

        }
        Node node = new Node(arr[idx]);
        idx ++ ; 
        node.left = ConstructBSTWPreorder(arr,lb,node.data);
        node.right = ConstructBSTWPreorder(arr,node.data,rb);
        return node;
    }
     
    public static int HeightWPreorder(int arr[], int lb, int rb){
        if( idx == arr.length||arr[idx] < lb || arr[idx] > rb ){
            return -1;

        }
       int ele = arr[idx];
        idx ++ ; 
        int lh = HeightWPreorder(arr,lb,ele);
        int rh = HeightWPreorder(arr,ele,rb);
        return Math.max(lh,rh)+1;
    }
    public static void Preorder(Node node){
        if(node==null) return;
        System.out.print(node.data +" ");
        Preorder(node.left);
        Preorder(node.right);
    }
    public static Node addData(Node node , int data){
        if(node==null) return new Node(data) ;

        if(data > node.data){
            node.right = addData(node.right,data);
        }
        else if(data < node.data){
           node.left =  addData(node.left,data);
        }
        
        
            

            return node;

        
        
            }
            public static int MaxELE(Node node){
                Node curr = node;
                while(curr.right!=null){
                    curr = curr.right;
                }
                return curr.data;
            }

            public static Node removeData(Node node , int data){
                if(node == null ){
                    return null;
                }
                if(data < node.data){
                    node.left = removeData(node.left,data);
                }
                else
                if(data > node.data){
                    node.right = removeData(node.right,data);
                }
                else{
                    if(node.left == null || node.right == null) return node.left!= null? node.left : node.right;
                    
                    else{
                        
                         int maxInleft=MaxELE(node.left);
                           node.data=maxInleft;
                           node.left=removeData(node.left,maxInleft);
                    }
                        
                    
                }
                return node;

            }
        
class  Kth Smallest Element {
    int K = -1;
    public int inorder(TreeNode root){
        if(root==null){
            return -1;
        }
        int left = inorder(root.left);
        if(left!=-1){
            return left;
        }
        if(--K==0){
            return root.val;
        }
        int right =  inorder(root.right);
        if(right!=-1){
            return right;
        }
        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        K = k ;
        return inorder(root);
        
}
    }
    class kthSmallest_02 {           // O(1) space morris traversal
            public int inorder(TreeNode root ,int k){
          while(root!=null){
              if(root.left==null){
                  k-- ;
                  if(k==0){
                      return root.val;
                  }
                  root = root.right;
              }
              else{
                  TreeNode p1 = root.left;
                  while(p1.right!=null && p1.right!=root){
                      p1 = p1.right;
                  }
                  if(p1.right==null){
                     p1.right = root;
                     root = root.left;
                  }
                  else{
                      p1.right = null;
                      
                     k--;
                      if(k==0){
                          return root.val;
                      }
                      root = root.right;
                      
                  }
              }
          }
        return -1;
    }
   

    public int kthSmallest(TreeNode root, int k) {
        
        return inorder(root,k);
    }
}
    
    public static void main(String args[]) {
         int[] input =  {9,12,14,17,19,23,50,54,67,72,76};
         int []Preorder ={23,14,9,12,17,19,67,50,54,72,76 };
        Node root = construct(0, input.length - 1, input);
        
        
       

          root = removeData(root,12);
      
          display(root);
    }
}