class BSTQuestions{

    // leetcode 173===========
      Stack<TreeNode> st ;
      BSTIterator(TreeNode root) {

               st = new Stack<>();

         allLeftNodes(root);
        
    }
    
     void allLeftNodes(TreeNode node){

         while(node!=null){
             
             st.push(node);

             node = node.left;

         }
         
    }
    int next() {
         TreeNode node = st.pop();
         allLeftNodes(node.right);
         return node.val;

    }
    
   
    boolean hasNext() {
        return st.size()>0;
    }
}
