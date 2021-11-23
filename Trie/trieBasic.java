class trieBasic{
    static class Node{
        int wordEnd=0;
        Node[]childs ;
        
        Node(){
            this.childs = new Node();
            this.wordEnd =0;

        }
    }
    Node root = new Node() ;
    static void insert(String word){
        Node curr = root;
             for(int i=0 ; i<word.length;i++){
                  int idx = word.charAt(i) - 'a';
                 if(curr.childs[idx]=null){
                     curr.childs[idx] = new Node();
                 }
                 curr = curr.childs[idx];
                 
             }
             curr.wordEnd++;
    }
    public boolean Search(String word){
        Node curr = root;
        int n = word.length();
        for(int  i = 0 ; i<n ;i++){
              int idx = word.charAt(i) - 'a';
              if(word.charAt(i)=='.' || curr.child[idx]!=null ) 
                curr =  curr.child[idx]
            
                if(curr == null){
                    return false;
                }
           
           }
           
               return curr.wordEnd > 0
           

    }
    public boolean prefix(String word){
        Node curr = root;
        int n = word.length();
        for(int i = 0 ; i<n ;i++){
            int idx = word.charAt(i) - 'a';
            curr = curr.child[idx];
            if(curr ==null){
                return false;
            }

        }
        return true;
    }
   static class leetcode 211{
     
    /** Adds a word into the data structure. */
    public void addWord(String word) {
         curr = root;
         for(int i = 0 ; i<word.length;i++){
        int idx = word.charAt(i) - 'a';
          if(curr.childs[idx]=null)
             curr.childs[idx] = new Node();
                 
         curr = curr.childs[idx];   
         }
         curr.wordEnd++;

    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search_(Node node, int si , String word) {
        if(node == null){
            return false;
        }
        if(si == word.length){
            return node.wordEnd>0;
        
        boolean ans = false;
       if(word.charAt(si)=='.'){
         for(int i = 0 ;i<26 i++){
             if(node.childs[i]!=null)
            ans =   ans || search_(node.childs[i],si+1,word);
         }
       }
       else{
           int idx = word.charAt(si)-'a'
           if(node.childs[idx]!=null){
              ans = ans || search_(node.childs[idx],si+1,word);
           }
       }
       return ans;
    }
    public boolean search(String word){
      return search_(root,word,0,)
    }
    }
    static class leetcode 212{
         class Node{
        int wordEnd=0;
        Node[]childs ;
        String word="";
        
        Node(){
            this.childs = new Node[26];
            this.wordEnd =0;


        }
    }
    Node root = new Node() ;
        int dirA[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
          void addWord(String s){
             Node  curr = root;
              for(int i = 0 ; i<s.length() ; i++){
                  int idx = s.charAt(i) - 'a';
                  if(curr.childs[idx]==null)
                  curr.childs[idx] = new Node();
                  curr = curr.childs[idx];
              }
              curr.wordEnd++;
              curr.word=s;
          }
          List<String> ans =new ArrayList<String>();
          void search(char[][]board,int r, int c,Node node){
                  if(node.wordEnd > 0 ){
                      node.wordEnd--;
                      ans.add(node.word);
                      
                  }

                  char ch = board[r][c];
                   board[r][c]='*';
                 for(int d = 0 ; d<dirA.length;d++){
                     int i = r + dirA[d][0];
                     int j = c + dirA[d][1];
         if(i>=0 && j>=0 && i<board.length && j<board[0].length && board[i][j]!='*' && node.childs[board[i][j]-'a']!=null  )
         {
             search(board,i,j,node.childs[board[i][j]-'a']);
         }    
                     

                 }
                   board[r][c]= ch;
              
          }
          public List<String> findWords(char[][] board, String[] words) {
         
         for(int i = 0 ; i<words.length ;i++){
             addWord(words[i]);
         }
         for(int i = 0 ; i<board.length ;i++){
             for(int j = 0 ; j<board[0].length ;j++){
                   if(root.childs[board[i][j]-'a']!=null){
                       search(board,i,j,root.childs[board[i][j]-'a']);
                   }
             }
         }
      Collections.sort(ans);

         return ans;
         
         }

    }
}


 // leetcode search word with given suffix and prefix;
class WordFilter {
          
     class Node{
           char ch; 
           Node childs[] = new Node[26];
           boolean isend;
           ArrayList<Integer> pos = new ArrayList<Integer>();
           Node(char ch){
               this.ch = ch ;
             
           }
     }
    Node prefix = new Node('#');
    Node suffix = new Node('#');
    public WordFilter(String[] words) {
            for(int i = 0 ; i<words.length ; i++){
                 add(words[i] , i , prefix);
                 add( new StringBuilder(words[i]).reverse().toString(), i,suffix);
            }
    }
    public void add(String str ,int index , Node node){
          
              for( int  i = 0 ; i<str.length() ; i++){
                   char ch = str.charAt(i);
                    if(node.childs[ch-'a']==null){
                         node.childs[ch-'a'] = new Node(ch);
                    }
                  node.childs[ch-'a'].pos.add(index);
                  node = node.childs[ch-'a'];
              }
        
    }
    
    
    public ArrayList<Integer> search(String str , Node node){
        ArrayList<Integer> indices =  new ArrayList<>(); ;
               for( int  i = 0 ; i<str.length() ; i++){
                   char ch = str.charAt(i);
                 if(node.childs[ch-'a']!=null){
                        indices = new ArrayList<>(node.childs[ch-'a'].pos);
                        node = node.childs[ch-'a'];
                    } 
                  else{
                      return new ArrayList<>();
                  }
              }
        return indices;
    }
    public int f(String pre, String suf) {
        
           ArrayList<Integer> Pre = search(pre,prefix);
           ArrayList<Integer> Suf = search(new StringBuilder(suf).reverse().toString(),suffix);
           if( pre.length() == 0 ||  Pre.size()==0 || suf.length()==0 || Suf.size()==0 ){
               return -1;
           }
           int i = Pre.size () - 1, j = Suf.size () - 1;
        
        while (i >= 0 && j >= 0) {
            if (Objects.equals (Pre.get (i), Suf.get (j))) {
                return Pre.get (i);
            }
            else if (Pre.get (i) > Suf.get (j)) {
                i--;
            }
            else {
                j--;
            }
        }
        
        return -1;
          
        
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */