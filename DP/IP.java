class IP{
    // Minimum number of increasing subsequences
    // It is equal to longest decreasing subsequence
    
     public static int BoxStacking(int height[], int width[], int length[], int n)
   {
        class pair{
            int l;
            int b;
            int h;
            pair(int l , int b , int h){
                this.l = l;
                this.b = b;
                this.h = h;
            }
        }
        ArrayList<pair> arr = new ArrayList<>();
        for(int i = 0 ;i <n;i++){
            int h = height[i];
            int l = width[i];
            int b = length[i];
            arr.add(new pair(Math.max(l,h),Math.min(l,h),b));
            arr.add(new pair(Math.max(b,h),Math.min(b,h),l));
            arr.add(new pair(Math.max(b,l),Math.min(b,l),h));
        }
        Collections.sort(arr,(pair a , pair b)->{
            
         return a.l - b.l;    
        });
        int dp[] = new int[arr.size()];
        dp[0] = arr.get(0).h;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <arr.size();i++){
            pair pi = arr.get(i);
             dp[i] = pi.h;
            for(int j = i-1 ; j>=0 ; j-- ){
                pair pj = arr.get(j);
                
               
                if(pj.l<pi.l && pj.b < pi.b){
                    dp[i] = Math.max(dp[i],dp[j]+pi.h);
                    
                }
               
               
            }
             max = Math.max(dp[i],max);
        }
        
        
        return max;
   }
   public static MaxSumAlternatingSubsequence (int arr[]) {
	         int inc[] = new int[arr.length];
	         int dec[] = new int[arr.length];
	         dec[0] = arr[0];
	         inc[0] = arr[0];
	         boolean flag = false;
	        
	         for(int i = 1 ; i<arr.length;i++){
	             for(int j = i-1;j>=0 ; j--){
	                 if(arr[j]>arr[i]){
	                     dec[i] = Math.max(inc[j]+arr[i],dec[i]);
	                     flag = true;
	                 }
	                 else if(flag){
	                     inc[i] = Math.max(dec[j]+arr[i],inc[i]);
	                 }
	                 else{
	                     dec[i] = arr[i];
	                 }
	             }
	         }
	         int max = Integer.MIN_VALUE;
	         for(int i = 0 ;i<inc.length;i++){
	             max = Math.max(Math.max(inc[i],max),dec[i]);
	         }
	         return max;
	}
}
class Minimum Score Triangulation of Polygon {
    public int minScoreTriangulation(int[] arr) {
        if(arr.length==0) return 0 ;
          int dp[][]=new int[arr.length+1][arr.length+1];
                  return burstBallon(arr,0,arr.length-1,dp);
    }
      static int burstBallon(int arr[] , int left , int right ,int dp[][]){
      if(left+1==right){
          return dp[left][right]=0;
      }
      
         if(dp[left][right]!=0){
             return dp[left][right];
         }
   
      
         int ans = (int)1e8 ;
      for(int cut = left+1 ; cut< right;cut++){
            int leftCost =    burstBallon(arr,left,cut,dp);
            int rightCost =   burstBallon(arr,cut,right,dp);
              int myCost =  leftCost +arr[left]*arr[cut]*arr[right]+rightCost;
          if(myCost<ans){
              ans = myCost;
          }
      }
      return dp[left][right]=ans;
  }
}
class 2 Keys Keyboard
 {
    public int  (int n) {
       int ans = 0;
         for(int i = 2 ; i<=n;i++){
             while(n%i==0){
                 ans+=i;
                 n = n/i;
             }
         }
        return ans;
        
    }
}
public int nthSuperUglyNumber(int n, int[] primes) {
         int idx[] = new int[primes.length];
         int ugly[] = new int[n];
        Arrays.fill(ugly,Integer.MAX_VALUE);
         ugly[0] = 1;
        for(int i = 1 ; i<n ; i++){
            
        
            for(int j = 0 ; j<idx.length;j++){
                ugly[i] = Math.min(ugly[i],ugly[idx[j]]*primes[j]);
                 
            }
           for(int j = 0 ; j<idx.length;j++){
                if(ugly[i] == ugly[idx[j]]*primes[j]){
                    idx[j]++;
                }
                 
            }
            
            
            
            
            
        }
        
        return ugly[n-1];
    }

      public int superEggDrop(int N, int K) {
        // N eggs
        // k floors
         int dp[][] = new int[N+1][K+1];
         for(int eggs=1 ; eggs<=N;eggs++ ){
             for(int floors = 1;floors<=K ; floors++ ){
                 dp[eggs][floors] = Integer.MAX_VALUE;
                 if(eggs==1){
                     dp[eggs][floors] = floors;
                 }
                 else{
                     int lo = 1;
                     int hi = floors;
                     while(lo<=hi){
                         int x = (lo+hi)/2;
                         int eggBreak = dp[eggs-1][x-1];
                         int eggNotbreak = dp[eggs][floors-x];
                         if(eggBreak>eggNotbreak){
                             hi = x-1;
                         }
                         else{
                             lo = x+1;
                         }
                         int ans = 1+Math.max(eggBreak,eggNotbreak);
                         dp[eggs][floors] = Math.min(ans,dp[eggs][floors]);
                     }
                         
                         
                     }
                 }
             }
         
       
        return dp[N][K];
    }
    public int superEggDrop_02(int N, int K, int M) {
        // N eggs
        // k floors
        //M moves
         int dp[][] = new int[N+1][M+1];
         for(int eggs=1 ; eggs<=N;eggs++ ){
             for(int moves = 1;,moves<=M ; moves++ ){
                 if(moves ==  1){
                     dp[eggs][moves] = 1;
                 }
                 dp[eggs][moves] = 1 + dp[eggs][moves-1] + dp[eggs-1][moves-1];
                 
             }
         }
         
       
        return dp[N][M];
    }
      public static int HighWayBillboard(int m , int[] x, int[] rev, int t) {
          int dp[] = new int[x.length];
          dp[0] = rev[0];
           for(int i = 1 ; i<x.length;i++){
                    int temp = dp[i];
                 dp[i] = Math.max(rev[i],dp[i-1]);
               for(int j = i-1;j>=0;j--){
                    
                   if(x[i]-x[j]>t){
                      
                       dp[i] = Math.max(dp[i],rev[i]+dp[j]);
                   }
                   
               }
           }
           
           return dp[x.length-1];
    }
     public static int HighWayBillboard_02(int m , int[] x, int[] rev, int t) {
		int[] dp = new int[m + 1];
		int j = 0;
		for(int i = 1; i <= m; i++) {
            // System.out.println(i+"  "+j);
			if( j < x.length && x[j] == i) {
				dp[i] = Math.max(dp[i - 1],(i - t - 1 >= 0 ? dp[i - t - 1] : 0) + rev[j]);
				j++;
			}else {
				dp[i] = dp[ i - 1];
			}
        }
        return dp[m];
    }
        
    public int cherryPickup(int[][] grid) {
         n = grid.length;
          int dp[][][] = new int[n][n][n];
          return Math.max(0,cherryPickup_(grid,0,0,0,0,dp));
    }
    public int cherryPickup_(int[][] grid , int r1 , int r2 , int c1 , int c2,int dp[][][] ) {
            if( c1>=n || c2>=n||r1>=n||r2>=n||  grid[r1][c1]==-1 || grid[r2][c2]==-1){
                return Integer.MIN_VALUE;
            } 
           if((r1==n-1 && c1 ==n-1) || (r2==n-1 && c2 == n-1) ){
               return dp[r1][c1][r2]=grid[n-1][n-1];
           }
          if(dp[r1][c1][r2]!=0){
              return dp[r1][c1][r2];
          }
            
            int cherries = 0 ;
            
            if(r1==r2 && c1==c2){
                cherries+=grid[r1][c1];
            }
             else{
                  cherries+=grid[r1][c1]+grid[r2][c2];
             }
            int ch1 =cherryPickup_(grid,r1+1,r2+1,c1,c2,dp);
            int ch2 =cherryPickup_(grid,r1,r2,c1+1,c2+1,dp);
            int ch3 =cherryPickup_(grid,r1+1,r2,c1,c2+1,dp);
            int ch4 =cherryPickup_(grid,r1,r2+1,c1+1,c2,dp);
           return dp[r1][c1][r2]=cherries+Math.max(ch4,Math.max(ch1,Math.max(ch2,ch3)));
    }
    
    
    public boolean Frog_Jump(int[] stones) {
         HashMap<Integer,ArrayList<Integer>>hm = new HashMap<>();
        for(int i = 0 ; i < stones.length;i++){
            hm.put(stones[i],new ArrayList<>());
        }
       int start = 0 ;
        hm.get(0).add(1);
        int dest = stones[stones.length-1];
       for(int i = 0 ; i<stones.length; i++){
            for(int j  = 0 ; j<hm.get(stones[i]).size() ; j++){
                     int jump = hm.get(stones[i]).get(j);
                
                if(stones[i]+jump==dest){
                    return true;
                }
                     int j1 = jump-1;
                     int j2 = jump+1;
                     int j3 = jump;
                if(hm.containsKey(stones[i]+jump)){
                  ArrayList<Integer> s = hm.get(stones[i]+jump);
                   if(!s.contains(j1) && j1!=0  ){
                       hm.get(stones[i]+jump).add(j1);
                   }
                if(!s.contains(j2) && j2!=0){
                       hm.get(stones[i]+jump).add(j2);
                   }
                if(!s.contains(j3) && j3!=0){
                       hm.get(stones[i]+jump).add(j3);
                   }   
}
               
                
            }
       }
        
        return false;
    }                

     public int maxSumNonadjacentelements(int[] nums) {
         if(nums.length==0) {
             return 0;
         }
        int inc = nums[0];
        int exc = 0;
        
        for(int i = 1 ; i<nums.length;i++){
              int temp = inc;
              inc = exc + nums[i];
              exc = Math.max(temp,exc);
        }
        return Math.max(inc,exc);
    }

    class Solution {
        public int maximizeTheProfit(int n, List<List<Integer>> offers) {   
            Collections.sort(offers,(List<Integer> a  , List<Integer> b )->{
                return a.get(0) - b.get(0);
            });
            dp = new int[offers.size()];
            Arrays.fill(dp,-1);
            return solve(offers,0);
    
        }
        int dp[] ;
        public int solve(List<List<Integer>> offers , int idx){
            if(idx >= offers.size()){
                return 0;
            }
            if(dp[idx] != -1){
                return dp[idx];
            }
    
            int ub = upperBound(offers,idx+1,offers.get(idx).get(1));
            int p1 = solve(offers,ub) + offers.get(idx).get(2);
            int p2 = solve(offers,idx+1);
            return dp[idx] = Math.max(p1,p2);
        }
    
    
        public int upperBound(List<List<Integer>> offers , int idx , int val){
           int lo = idx;
           int hi = offers.size();
           
           while(lo < hi){
               int mid = (lo+hi)/2;
               if(offers.get(mid).get(0) > val){
                 hi = mid;
               }
               else{
                 lo = mid+1;
               }
           }
           return hi;
        } 
    }