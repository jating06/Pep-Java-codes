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

  class UniqueBSTs {
    public int numTrees(int n) {
        int c[] = new int[n+1];
        c[0] = 1;
        c[1] = 1;
        for(int i = 2 ; i <= n ; i ++ ){
            for(int j = 0 ; j < i ; j++){
                c[i] += c[j] * c[i-1-j]; 
            }
        }
        return c[n];
    }

    /* reasoning for this is 

    c[4] = (c[0] * c[3]) +( c[1] * c[2]) + (c[2] * c[1]) + (c[3] * c[0])
    we will check by taking each node as root node;
    if left tree has 1 node and right subtree has 2 nodes then final ans will be multiplication of unique subtrees in left and right subtree
    
    */


    class leetcode375 {
        public int getMoneyAmount(int n) {
           int dp[][] = new int[n+1][n+1];
           for(int arr[] : dp){
               Arrays.fill(arr,-1);
           }
           dp[1][1] = 0;
           solve(1,n,dp);
           return dp[1][n];
        }
    
        public int solve(int start , int end , int dp[][]){
            if(start >= end ){
                return 0;
            }
            if(dp[start][end] != -1 ){
                return dp[start][end];
            }
            int min = Integer.MAX_VALUE;
            for(int i = start ; i <= end ; i++){
               min = Math.min(min,Math.max(solve(start,i-1,dp) , solve(i+1,end,dp)) + i);
            }
            return dp[start][end] = min;
        }
    }
}

    public static void main(String[] args) {
      int arr[] = {34, 8, 50};
        int dp[][] = new int[arr.length][arr.length];
        System.out.println( OBST_rec_DP(arr, 0, arr.length-1));
        display2d(dp);
    }
}