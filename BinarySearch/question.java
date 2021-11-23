class question{
       public int shipWithinDays(int[] weights, int D) {
        int ans=0;
        int min = Integer.MIN_VALUE; 
        for(int i = 0 ; i <weights.length ; i++){
              min = Math.max(weights[i],min);
         }
        int max = 0;
        for(int i = 0 ; i<weights.length;i++){
             max+=weights[i];
        }
          while(min<=max){
            int mid = (min+max)/2;
        
        int ret = NoOfDays(weights,mid);
      
        if(ret>D){
            
            min = mid+1;
        }
        else if(ret<=D){
               ans = mid;
               max = mid-1; 
             
        }
        
        }
        return ans;
    }
    public int NoOfDays(int[] weights ,int max){
        int days=1;
        int sum=0;
        for(int  i = 0 ; i<weights.length;i++){
            if(sum+weights[i]>max){
                days++;
                sum=0;
                
            }
            sum+=weights[i];
        }
        return days;
    }
      public int splitArray(int[] nums, int m) {
           int ans=0;
        int min = Integer.MIN_VALUE; 
        for(int i = 0 ; i <nums.length ; i++){
              min = Math.max(nums[i],min);
         }
        int max = 0;
        for(int i = 0 ; i<nums.length;i++){
             max+=nums[i];
        }
        while(min<=max){
             int mid = (min+max)/2;
             int ret = chunks(nums,mid);
          
            if(ret>m){
                min = mid+1;
            }
            else if(ret<=m){
                ans = mid;
                   max = mid-1;
                  
            }
            
        }
        return ans;
    }
    int chunks(int[] nums , int max){
        int chunks=1;
        int sum = 0;
        for(int i = 0; i <nums.length;i++){
            if(sum+nums[i]>max){
                sum = 0;
                chunks++;
                
            }
           
                sum+=nums[i];
            
        }
        return chunks;
    }
}