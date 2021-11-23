class stringPermutation{
    public static int  possibilities(String str,String asf,int j, boolean marked[] ){
   if(j==str.length()){
       System.out.println(asf);
       return 0;
   }
    boolean used[]=new boolean[26];
    int count=0;
    if(asf.length()!=0){
         System.out.println(asf);
    }
   
    for(int i=0;i<str.length();i++){
        int k=(int)str.charAt(i)-'A';
          if(used[k]==false && marked[i]==false){
         used[k]=true;
         marked[i]=true;
         
        count+=possibilities(str,asf+str.charAt(i),j+1 ,marked)+1;
        marked[i]=false;
          }
     }
     return count;
    
    }


    public static void main(String[] args){
    System.out.println(possibilities("AAB","",0,new boolean[3]));
    }
}