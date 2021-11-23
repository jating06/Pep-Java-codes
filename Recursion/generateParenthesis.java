class generateParenthesis{
    
    
    public static void parenthesis(int n, String asf, int ob, int cb){
         if( ob+cb==2*n && ob==cb){
          System.out.println(asf);
             return;
         }
         if(ob<n){
        parenthesis(n,asf+"(" , ob+1,cb);
         }
         if(cb<ob){
          parenthesis(n,asf+")", ob,cb+1);
         }
         
        
        

    }
    
    public static void main(String[] args){
       parenthesis(3,"",0,0);
    }
}