class CutType {
    public static void display2d(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int MCM(int arr[], int si, int ei, int dp[][]) {
        if (si + 1 == ei) {
            return dp[si][ei] = 0;
        }
        if (dp[si][ei] != 0) return dp[si][ei];
        int ans = Integer.MAX_VALUE;
        for (int cut = si + 1; cut < ei; cut++) {
            int leftCost = MCM(arr, si, cut, dp);
            int rightCost = MCM(arr, cut, ei, dp);

            int myCost = leftCost + arr[si] * arr[cut] * arr[ei] + rightCost;
            if (myCost < ans)
                ans = myCost;
        }

        return dp[si][ei] = ans;

    }
    public static int MCM_DP(int arr[], int si, int ei, int dp[][]) {
        for (int gap = 1; gap < arr.length; gap++) {
            for (si = 0, ei = gap; ei < arr.length; si++, ei++) {
                if (si + 1 == ei) {
                    dp[si][ei] = 0;
                    continue;
                }

                int ans = Integer.MAX_VALUE;
                for (int cut = si + 1; cut < ei; cut++) {
                    int leftCost = dp[si][cut];
                    int rightCost = dp[cut][ei];

                    int myCost = leftCost + arr[si] * arr[cut] * arr[ei] + rightCost;
                    if (myCost < ans)
                        ans = myCost;
                }

                dp[si][ei] = ans;
            }
        }

        return dp[0][arr.length - 1];
    }
     public static int MCM_D_W_String(int arr[], int si, int ei, int dp[][]) {
         String dpS[][] = new String[arr.length][arr.length];

        for (int gap = 1; gap < arr.length; gap++) {
            for (si = 0, ei = gap; ei < arr.length; si++, ei++) {
                if (si + 1 == ei) {
                    dp[si][ei] = 0;
                    dpS[si][ei]= (char)(si+'A')+"";
                    continue;
                }

                int ans = Integer.MAX_VALUE;
                String s = "";
                for (int cut = si + 1; cut < ei; cut++) {
                    int leftCost = dp[si][cut];
                    int rightCost = dp[cut][ei];

                    int myCost = leftCost + arr[si] * arr[cut] * arr[ei] + rightCost;
                    if (myCost < ans)
                        ans = myCost;
                        s = "("+dpS[si][cut]+dpS[cut][ei]+")";
                }

                dp[si][ei] = ans;
                dpS[si][ei] = s;
            }
        }
         System.out.println(dpS[0][arr.length - 1]);
        return dp[0][arr.length - 1];
    }
static int costOfSearching(int freq[] , int si , int ei ){
    int sum = 0 ;
    for(int i = si ; i <=ei ; i++){
        sum+=freq[i];
    }
    return sum;
}

static int OBST_rec(int freq[] , int si , int ei ){
        int maxCost = Integer.MAX_VALUE;
        for(int i = si ; i<=ei ; i++){
            int leftCost =  (i == si )?0: OBST_rec(freq,si,i-1);
            int rightCost =  (i == ei )?0:OBST_rec(freq,i+1,ei);
            int cost = leftCost + costOfSearching(freq,si,ei) +rightCost;
            if(cost < maxCost){
                maxCost = cost;
            }
        }
        return maxCost;
}
static int OBST_rec_DP(int freq[] , int si , int ei ){
      int prefixSum[] = new int[freq.length+1];
      for(int i = 1 ; i<prefixSum.length ; i++){
          prefixSum[i] = prefixSum[i-1] + freq[i-1];
      }
        int maxCost = Integer.MAX_VALUE;
        for(int i = si ; i<=ei ; i++){
            int leftCost =  (i == si )?0: OBST_rec(freq,si,i-1);
            int rightCost =  (i == ei )?0:OBST_rec(freq,i+1,ei);
            int cost = leftCost + (prefixSum[ei+1]-prefixSum[si])   +rightCost;
            if(cost < maxCost){
                maxCost = cost;
            }
        }
        return maxCost;
}
 static int burstBallon(int arr[] , int si , int ei ,int dp[][]){
       if (dp[si][ei] != 0)
        return dp[si][ei];
         int lvalue = si==0 ? 1 : arr[si-1];
      int rvalue = ei==arr.length-1 ? 1 :  arr[ei+1];
      
         int ans = 0 ;
      for(int cut = si ; cut<=ei;cut++){
            int leftCost =  (cut==si)?0 :burstBallon(arr,si,cut-1,dp);
            int rightCost =  (cut==ei)?0:burstBallon(arr,cut+1,ei,dp);
              int myCost =  leftCost +lvalue*arr[cut]*rvalue+rightCost;
          if(myCost>ans){
              ans = myCost;
          }
      }
      return dp[si][ei]=ans;
  }
    public static void main(String[] args) {
      int arr[] = {34, 8, 50};
        int dp[][] = new int[arr.length][arr.length];
        System.out.println( OBST_rec_DP(arr, 0, arr.length-1));
        display2d(dp);
    }
}