import java.util.*;
class construction{
    public static int height(int []arr, int idx){
            int lh = height(arr,2*idx+1);
            int rh = height(arr,2*idx+2);
            return Math.max(lh,rh)+1;
        }

        //=====================HEAP==========================
    static class heap{
        boolean isMaxHeap;
        ArrayList<Integer>arr = new ArrayList<Integer>();
        heap(int list[] , boolean isMaxHeap){
        
            this.isMaxHeap = isMaxHeap;
           
             for(int ele : list){
                 arr.add(ele);
                 
             }
             int n = arr.size();
             for(int i = n-1;i>=0;i--){
                   downHeapify(i,n);
             }
        }
        
        public void swap(int x, int y) { // O(1)

            int ele1 = arr.get(x);
            int ele2 = arr.get(y);

            arr.set(x, ele2);
            arr.set(y, ele1);
        }
        public int compareTo(int a , int b ){
            if(isMaxHeap){
                return this.arr.get(a) - this.arr.get(b);
            }
            else 
            {
                return this.arr.get(b) - this.arr.get(a);
            }
        }

       public  void downHeapify(int pi, int n){
           int lci = 2*pi+1;
           int rci = 2*pi+2;
           int wrongIdx = pi;
           if(lci<n && compareTo(lci,wrongIdx)>0){
                  wrongIdx = lci;
           }
           if(rci<n &&compareTo(rci,wrongIdx)>0){
                 wrongIdx = rci;
           }
           if(wrongIdx!=pi){
               swap(wrongIdx,pi);
               downHeapify(wrongIdx,n);
           }
       }
       public  void upHeapify(int ci){
           int pi = (ci-1)/2;
           int wrongIdx = ci;
           if(pi>=0 && compareTo(wrongIdx,pi)>0){
                 wrongIdx = pi;
           }
           if(wrongIdx!=ci){
                swap(wrongIdx,ci);
                upHeapify(wrongIdx);
           }

       }

       //==================user FUnctions====================


       public void add(int data){
           arr.add(data);
           upHeapify(arr.size()-1);
       }
       public void pop(){
           if(arr.size()==0) return; 
           swap(0,arr.size()-1);
           arr.remove(arr.size()-1);
           downHeapify(0,arr.size()-1);
    }
    public int top(){
        if(arr.size()<=0) return -1;
        return arr.get(0);
    }
     public int size() {
            return arr.size();
        }


  

}
  public static void main(String[] args){
                int[] arr2 = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
                heap hp = new heap(arr2,true);
                
                while(hp.size()>0){
                    System.out.print(hp.top()+" ");
                    hp.pop();
                }

    }
}