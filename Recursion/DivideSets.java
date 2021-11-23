import java.util.*;
public class DivideSets{
    public static void main(String[] args){
        int arr[]={10,20,30,40,50,60,70,80};
        divide2(arr,0, 0 ,0 ,"","" );
    }
    public static void divide(int arr[],int idx, int s1, int s2 , String set1 , String set2){
        if(idx==arr.length){
            if(s1==s2){
            System.out.println("set 1: "+set1);
            System.out.println("set 2: "+set2);
            }
            return;
        }
        
        divide(arr,idx+1,s1+arr[idx],s2,set1+arr[idx]+" ",set2);
        
       
         divide(arr,idx+1,s1,s2+arr[idx],set1,set2+arr[idx]+" ");
       
    }
     public static void divide2(int arr[],int idx, int s1, int s2 , String set1 , String set2){
       
            if(idx==arr.length){
                if(s1==s2){
            System.out.println("set 1: "+set1);
            System.out.println("set 2: "+set2);
            }
           
             return;
         } 
        
        
        
        divide2(arr,idx+1,s1+arr[idx],s2,set1+arr[idx]+" ",set2);
        
       
         divide2(arr,idx+1,s1,s2+arr[idx],set1,set2+arr[idx]+" ");
          divide2(arr,idx+1,s1,s2,set1,set2);
       
    }
}