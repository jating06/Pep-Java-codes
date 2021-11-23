class kstacks{
    int arr[];
    int nxtFree[]; // stores next available spot when we are pushing the ele and stores element below me after element is pushed
    int top[];
    int free = 0;
    kstacks(int n) {
        arr = new int[10];
        nxtFree = new int[10];
        for(int i = 0 ; i<arr.length;i++){
            nxtFree[i] = i+1;
        }
        nxtFree[nxtFree.length-1] = -1;
        top = new int[n];

    }
    public void push(int ele , int sn){
        if(free==-1){
            return;
        }
        int nas = nxtFree[free]; // nas: next available spot
        arr[free] = ele;
        nxtFree[free] = top[sn];
        top[sn] = free;
        free = nas;


    }
    public void pop(int sn){
        int removeidx = top[sn];
        arr[removeidx] = 0 ;
        top[sn] = nxtFree[removeidx];
        nxtFree[removeidx] = free;
        free = removeidx ;

    }
    public int top(int sn){
            if(top[sn]==-1){
                return -1;
            }
            else {
                return arr[top[sn]];
            }
    }
    public static void main(String[] args){
         kstacks k = new kstacks(3);
         k.push(2,0);
         k.push(5,1);
         k.push(3,0);
         k.push(6,1);
         k.push(4,0);
         k.push(7,2);
         
         System.out.println(k.top(0));
         System.out.println(k.top(1));
         System.out.println(k.top(2));
    }
}