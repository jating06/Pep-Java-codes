import java.util.*;
class same{
public static void same_(int nos[],ArrayList<Integer>arr , int idx ,boolean[] used ){
        
       
        //base case
        if(idx==nos.length){
            for(int i=0;i<arr.size();i++){
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();
            return;
        }


        //recursive case
                
                      
                    arr.add(nos[idx]);
                 same_(nos,arr,idx+1,used);
                
                 arr.remove(idx);
                   
                 
                
                  if(idx-1>=0){ 
                  
                    
                       arr.add(idx,nos[idx]+nos[idx-1]);
                       same_(nos,arr,idx+1 ,used );
                       arr.remove(idx);
                       
                   
                  }
                  
              
        
    }
    public static void main(String[] args){
         int nos[]={11,5,6,2,8,10};
          same_(nos,new ArrayList<Integer>(),0, new boolean[nos.length]);
    }
}