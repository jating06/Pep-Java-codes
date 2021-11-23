import java.util.*;

public class coinChange{
	public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       
       int n=s.nextInt();
       int mark[]=new int [n];
       int arr[]=new int[n];
       for(int i=0;i<arr.length;i++){
           arr[i]=s.nextInt();
       }
       Permutation01( arr, 10, "",0,new int[n],0);
       
    
    }
    
      public static void Permutation01(int[] arr, int tar, String str,int csum,int used[],int idx){
        if(csum>tar||idx==arr.length){
           return;
       }
       if(csum==tar){
           System.out.println(str);
           return;
       }
    
    
          
          for(int i=0;i<arr.length;i++){
              
              if(used[i]==0){
                  used[i]=1;
             Permutation01(arr,tar,str+arr[i],csum+arr[i],used,i);
             used[i]=0;
              }
          
           
          }
      }
      public static void PermutionsInf1(int arr[],String str,int tar,int csum){
       if(csum>tar){
           return;
       }
       if(csum==tar){
           System.out.println(str);
           return;
       }
       for(int i=0;i<arr.length;i++){
           PermutionsInf1(arr,str+arr[i],tar,csum+arr[i]);
       }
    }

    
      public static void Combination01(int[] arr, int idx, int tar, String str,int csum){
        if(csum>tar){
           return;
       }
       if(csum==tar){
           System.out.println(str);
           return;
       }
    
          
          for(int i=idx;i<arr.length;i++){
           Combination01(arr,i+1,tar,str+arr[i],csum+arr[i]);
          }
          
         
 
      }
      
      public static void CombinationInf1(int[] arr,  int tar, String str,int csum,int idx){
        if(csum>tar){
           return;
       }
       if(csum==tar){
           System.out.println(str);
           return;
       }
    
          
          for(int i=idx;i<arr.length;i++){
           CombinationInf1(arr,tar,str+arr[i],csum+arr[i],i);
          }
          
         
 
      }
}


