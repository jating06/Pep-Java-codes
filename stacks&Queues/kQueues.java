class kQueues{
      int arr[];
      int start[];
      int end[];
      int nxtFree[]; // dual behaviour arrays stores index of next available spot before push and stores idx of ele after me
      int free = 0;
    
    kQueues(int n) {
       arr  = new int[10];
       start = new int[n];
       end = new int[n];
       nxtFree = new int[10];
       for(int i = 0; i < nxtFree.length; i++){
           nxtFree[i] = i+1;
       }
       for(int i = 0; i <n;i++){
           start[i]=-1;
       }
       for(int i = 0; i <n;i++){
           end[i]=-1;
       }  
       nxtFree[nxtFree.length-1] = -1;

    }
    public void push(int ele , int qn){
        if(free == -1){
            System.out.println("Queue overflow");
            return;
        }
        int nas = nxtFree[free];
        arr[free] = ele;
        if(start[qn]==-1){  // it is critical bcoz when popping stack can become empty and start is at -1;
            start[qn] = free;
            end[qn] = free;
        }
        else{
            nxtFree[end[qn]] = free;
            end[qn] = free;
        }
        nxtFree[free] = -1;
        free = nas;

    }
    public void pop(int qn ){
        int removeidx = start[qn];
        arr[removeidx] = 0;
        start[qn] = nxtFree[removeidx];
        nxtFree[removeidx] = free;
        free = removeidx; 

    }
    public int top(int qn ){
        
        return arr[start[qn]];

    }
    public static void main(String args[]){
        kQueues q = new kQueues(3);
       
       q.push(2,1);
       q.push(3,1);
       q.push(5,0);
       q.push(4,1);
       q.push(6,0);
       q.push(10,2);
       q.push(6,0);
       q.push(6,0);
       q.push(6,0);
       q.push(6,0);
       q.push(6,0);

       System.out.println(q.top(1));
    }

}