class BT_QUESTIONS{
      public void pathSum(TreeNode root, int sum, List < List < Integer >> res, List < Integer > smallAns) { // leetcode  113
        if (root == null) return;
        if (root.left == null && root.right == null && sum - root.val == 0) {
            List < Integer > base = new ArrayList < > (smallAns);
            base.add(root.val);
            res.add(base);
            return;
        }

        smallAns.add(root.val);
        pathSum(root.left, sum - root.val, res, smallAns);
        pathSum(root.right, sum - root.val, res, smallAns);
        smallAns.remove(smallAns.size() - 1);
    }

    public List < List < Integer >> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList < > ();

        List < List < Integer >> res = new ArrayList < > ();
        List < Integer > smallAns = new ArrayList < > ();
        pathSum(root, sum, res, smallAns);
        return res;
    }

      int totalCoins = 0;
    public int distributeCoins_(TreeNode root) {
        if(root == null) return 0;
        int leftDefeGain = distributeCoins_(root.left);
        int rightDefeGain = distributeCoins_(root.right);

        totalCoins += Math.abs(leftDefeGain) + Math.abs(rightDefeGain);

        return root.val - 1 + leftDefeGain + rightDefeGain;
    }
   
    public int distributeCoins(TreeNode root) {
      
        distributeCoins_(root);
        return totalCoins;
    }
// 0 means i am covered i can cover you
// 1 means i am covered bcoz of my child
// 2 i need a coverage
// 3 i am a null node
    int camera=0;
    public int minCameraCover(TreeNode root) {
         if(minCameraCover_(root)==-1){
             camera++;
             return camera;
         }
         
        
        return camera;    }
    public int minCameraCover_(TreeNode root) {
        if(root == null) {
            return 3;
         } 
         int la = minCameraCover_(root.left);
         int ra = minCameraCover_(root.right);
  
         if(la == 2  || ra == 2){
           cameras++;
           return 0;
         }
         if(la == 0 || ra == 0){
           return 1; 
         }
         return 2;
    }
    
}
    public static Tree cloneTree(Tree tree){
            CloneNodes(tree);
            CloneRandomPointers(tree);
            Tree Cloned = tree.left;
             RetreiveTree(tree);
             return Cloned;
           
     }
     public static void CloneNodes(Tree tree){
         if(tree==null){
             return ;
         }
          Tree Node = tree.left;
          Tree clone = new Tree(tree.data);
          tree.left = clone;
          clone.left =  Node;
          
          CloneNodes(tree.left.left);
          CloneNodes(tree.right);
          
     }
     public static void CloneRandomPointers(Tree tree){
            if(tree ==  null){
                return ;
            }
            Tree node = tree;
            Tree cloned = tree.left;
            if(node.random!=null){
                cloned.random = node.random.left;
            }
            
            CloneRandomPointers(tree.left.left);
            CloneRandomPointers(tree.right);
            
     }
      public static Tree RetrieveTree_01(Tree tree){
         if(tree == null){
             return null;
         }
        
         Tree left = RetrieveTree(tree.left.left);
         Tree Right = RetrieveTree(tree.right);
         
         Tree cloned = tree.left;
         tree.left = cloned.left;
         cloned.left = left;
         cloned.right = Right;
         
       
         return cloned;
     }
     public static void RetreiveTree_02(Tree tree){
         if(tree == null ){
             return ;
         }
        
         Tree Cloned = tree.left;
         
         tree.left = Cloned.left;
         if(tree.left!=null)
         Cloned.left = tree.left.left;
         if(tree.right!=null)
         Cloned.right = tree.right.left;
         RetreiveTree(tree.left);
         RetreiveTree(tree.right);
         
         
       
        
     }
      
     