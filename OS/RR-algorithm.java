public static void waitingTime(int quantum , int bt[],int waitingTime[]){
     int n = bt.lenght;
    int rem_bt[] = new int[n]; 
        for (int i = 0 ; i < n ; i++) 
            rem_bt[i] =  bt[i]; 
            int t = 0;
     while(true){
         boolean done = true;
         for(int i = 0 ; i<n;i++){
             if(rem_bt[i]>0){
                 done = false;
             if(rem_bt[i]>quantum){
                 rem_bt[i]-=quantum;
                 t+=quantum;
               
             }
             else{
                 t+=rem_bt[i];
                 waitingTime[i] = t-bt[i];
                 rem_bt[i] = 0;
             }
             }
         }
         if(done==true){
             break;
         }
         
     }
   
}
public static void tat(int wt[] , int bt[] , int tat[]){
     for(int i = 0 ;  i<bt.length;i++){
         tat[i] = wt[i]+bt[i];
     }
}