import java.util.*;
class DP {
    public static void display2d(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void display1d(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public static int mazeVPath(int sr, int sc, int er, int ec, int dp[][]) {
        if (sr == er && sc == ec) {
            return 1;
        }
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int count = 0;
        if (sr + 1 < er) {
            count += mazeVPath(sr + 1, sc, er, ec, dp);
        }
        if (sc + 1 < ec) {
            count += mazeVPath(sr, sc + 1, er, ec, dp);
        }
        if (sr + 1 < er && sc + 1 < ec) {
            count += mazeVPath(sr + 1, sc + 1, er, ec, dp);
        }
        return dp[sr][sc] = count;
    }
    public static int mazeVPath_DP(int sr, int sc, int er, int ec, int dp[][]) {
        for (int i = er; i >= 0; i--) {
            for (int j = ec; j >= 0; j--) {
                if (sr == er && sc == ec) {
                    return 1;
                }
                if (dp[sr][sc] != 0) {
                    return dp[sr][sc];
                }
                int count = 0;
                if (sr + 1 < er) {
                    count += dp[sr + 1][ec];
                }
                if (sc + 1 < ec) {
                    count += dp[sr][sc + 1];
                }
                if (sr + 1 < er && sc + 1 < ec) {
                    count += dp[sr + 1][sc + 1];
                }
                dp[sr][sc] = count;
            }
        }
        return dp[0][0];

    }

    public static int mazePathMulti_DP(int sr, int sc, int er, int ec, int dp[][]) {

        for (sr = er; sr >= 0; sr--) {
            for (sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int jump = 1; sr + jump <= er; jump++)
                    count += dp[sr + jump][sc]; //mazePathMulti(sr + jump, sc, er, ec, dp);

                for (int jump = 1; sc + jump <= ec; jump++)
                    count += dp[sr][sc + jump]; //mazePathMulti(sr, sc + jump, er, ec, dp);

                for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
                    count += dp[sr + jump][sc + jump]; //mazePathMulti(sr + jump, sc + jump, er, ec, dp);

                dp[sr][sc] = count;
            }
        }

        return dp[0][0];
    }
    public static int boardPath(int sp, int ep, int dp[]) {
        if (sp == ep) {
            return 1;
        }
        if (dp[sp] != 0) {
            return dp[sp];
        }
        int count = 0;
        for (int dice = 1; dice <= 6; dice++) {
            if (sp + dice <= ep) {
                count += boardPath(sp + dice, ep, dp);
            }
        }
        return dp[sp] = count;
    }
    public static int boardPath_DP(int sp, int ep, int dp[]) {



        for (sp = ep; sp >= 0; sp--) {
            if (sp == ep) {
                dp[sp] = 1;
                continue;
            }
            int count = 0;
            for (int dice = 1; dice <= 6; dice++) {
                if (sp + dice <= ep) {

                    count += dp[sp + dice];
                    dp[sp] = count;
                }

            }

        }
        return dp[0];
    }
    public static int boardPath_Best(int sp, int ep) {


        LinkedList < Integer > li = new LinkedList < > ();
        for (sp = ep; sp >= 0; sp--) {
            if (sp >= ep - 1) {
                li.addFirst(1);
                continue;
            }



            if (li.size() <= 6) {

                li.addFirst(2 * li.getFirst());

            } else {
                li.addFirst(2 * li.getFirst() - li.removeLast());
            }


        }

        return li.getFirst();
    }

    //https://leetcode.com/problems/climbing-stairs/description/
    public int climbStairs_01(int n, int dp[]) {
        if (n <= 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = climbStairs_01(n - 1, dp) + climbStairs_01(n - 2, dp);
        return dp[n] = ans;

    }
    public int climbStairs_02(int n, int dp[]) {

        for (int i = 0; i <= n; i++) {
            if (i <= 1) {
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i - 1] + dp[i - 2];


        }
        return dp[n];



    }
    public static int FriendsPairing(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ways = FriendsPairing(n - 1, dp) + (n - 1) * FriendsPairing(n - 2, dp);
        return dp[n] = ways;
    }
    public static void FriendsPairing_dp(int n) {


        int N = n;
        long dp[] = new long[N + 1];
        for (n = 0; n <= N; n++) {
            if (n == 0 || n == 1) {
                dp[n] = 1;
                continue;
            }
            dp[n] = dp[n - 1] + (n - 1) * dp[n - 2];

        }
        System.out.println(dp[N]);

    }
    public static int MinPathSum(int[][] board, int sr, int sc, int er, int ec, int dp[][]) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = board[sr][sc];
        }
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;
        if (sr + 1 <= er) {
            cost1 = MinPathSum(board, sr + 1, sc, er, ec, dp);
        }
        if (sc + 1 <= ec) {
            cost2 = MinPathSum(board, sr, sc + 1, er, ec, dp);
        }

        return dp[sr][sc] = Math.min(cost1, cost2) + board[sr][sc];


    }
    public static int MinPathSum_dp(int[][] board, int sr, int sc, int er, int ec, int dp[][]) {
        for (sr = er; sr >= 0; sr--) {
            for (sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = board[sr][sc];
                    continue;
                }

                int cost1 = Integer.MAX_VALUE;
                int cost2 = Integer.MAX_VALUE;
                if (sr + 1 <= er) {
                    cost1 = dp[sr + 1][sc];
                }
                if (sc + 1 <= ec) {
                    cost2 = dp[sr][sc + 1];
                }

                dp[sr][sc] = Math.min(cost1, cost2) + board[sr][sc];
            }
        }
        return dp[0][0];



    }
    static int dirA[][] = {
        {
            0,
            1
        },
        {
            -1,
            1
        },
        {
            1,
            1
        }
    };
    public static int goldMine(int sr, int sc, int er, int ec, int dp[][], int cost[][]) {
        if (sc == ec) {
            return dp[sr][sc] = cost[sr][sc];
        }
        if (dp[sr][sc] != 0) return dp[sr][sc];
        int maxCoins = 0;
        for (int i = 0; i < dirA.length; i++) {
            int x = sr + dirA[i][0];
            int y = sc + dirA[i][1];
            if (x >= 0 && y >= 0 && x <= er && y <= ec)
                maxCoins = Math.max(maxCoins, goldMine(x, y, er, ec, dp, cost));
        }
        return dp[sr][sc] = maxCoins + cost[sr][sc];

    }
    public static int goldMine_(int cost[][]) {
        int n = cost.length;
        int m = cost[0].length;
        int dp[][] = new int[n][m];
        int maxCoins = 0;
        for (int i = 0; i < n; i++) {
            maxCoins = Math.max(maxCoins, goldMine(i, 0, n - 1, m - 1, dp, cost));
        }
        return maxCoins;
    }
    public static int goldMine_dp(int sr, int sc, int er, int ec, int dp[][], int cost[][]) {

        int SR = sr;
        int SC = sc;
        for (sc = ec; sc >= 0; sc--) {
            for (sr = er; sr >= 0; sr--) {

                if (sc == ec) {
                    dp[sr][sc] = cost[sr][sc];
                    continue;
                }

                int maxCoins = 0;
                for (int i = 0; i < dirA.length; i++) {
                    int x = sr + dirA[i][0];
                    int y = sc + dirA[i][1];
                    if (x >= 0 && y >= 0 && x <= er && y <= ec)
                        maxCoins = Math.max(dp[x][y], maxCoins);
                }
                dp[sr][sc] = maxCoins + cost[sr][sc];
            }
        }

        return dp[SR][SC];


    }
    // https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
    public static int countways(int n, int k, int dp[][]) {
        if (n < k) return 0;
        if (k == 1 || n == k) {
            return dp[n][k] = 1;   
        }
        if (dp[n][k] != 0) return dp[n][k];

        int ifAlone = countways(n - 1, k - 1, dp);   // nth banda jab akela hoga use majboor hoke naya parition banana padega
        int pairup = countways(n - 1, k, dp) * k;    // nth banda jab pair up krega toh woh kisi bhi n-1 bando ke pair me jud skta h  
        int ans = pairup + ifAlone;
        return dp[n][k] = ans;

    }
    public static int countways(int n, int k) {

        int dp[][] = new int[n + 1][k + 1];
        countways(n, k, dp);


        return dp[n][k];
    }
    static char keypad[][] = {
        {
            '1',
            '2',
            '3'
        },
        {
            '4',
            '5',
            '6'
        },
        {
            '7',
            '8',
            '9'
        },
        {
            '*',
            '0',
            '#'
        }
    };
    static int dir[][] = {
        {
            1,
            0
        },
        {
            0,
            1
        },
        {
            -1,
            0
        },
        {
            0,
            -1
        },
        {
            0,
            0
        }
    };

    public static int numKeyPad(int idx, char keypad[][], int k, int dp[][]) {

        if (k == 1) {
            return dp[idx][k] = 10;
        }
        int countways = 0;
        if (dp[idx][k] != 0) return dp[idx][k];
        for (int d = 0; d < 5; d++) {
            int x = (idx / 3) + dir[d][0];
            int y = (idx % 3) + dir[d][1];
            if (x >= 0 && y >= 0 && x < keypad.length && y < keypad[0].length) {
                if (keypad[x][y] != '#' && keypad[x][y] != '*') {
                    countways += numKeyPad(x * 3 + y, keypad, k - 1, dp);
                }

            }

        }


        return dp[idx][k] = countways;
    }
    public static int numKeyPad(int k) {
        int dp[][] = new int[12][k + 1];
        if (k == 1) return 10;
        int countways = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {

                if (keypad[i][j] != '#' && keypad[i][j] != '*') {
                    countways += numKeyPad(i * 3 + j, keypad, k, dp);
                }
            }
        }

        return countways;
    }



    public static int numKeyPad_02(int sr, int sc, int er, int ec, char keypad[][], int k, int dp[][]) {

        int no = keypad[sr][sc] - '0';
        if (k == 1) {
            return dp[no][k] = 1;
        }
        if (dp[no][k] != 0) return dp[no][k];
        int countways = 0;
        for (int d = 0; d < 5; d++) {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
            if (x >= 0 && y >= 0 && x <= er && y <= ec) {
                if (keypad[x][y] != '#' && keypad[x][y] != '*') {
                    countways += numKeyPad_02(x, y, er, ec, keypad, k - 1, dp);
                }

            }
        }


        return dp[no][k] = countways;
    }
    public static int numKeyPad_02(int k) {
        int dp[][] = new int[12][k + 1];
        int m = 3;
        int n = 4;
        if (k == 1) return 10;
        int countways = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (keypad[i][j] != '#' && keypad[i][j] != '*') {

                    countways += numKeyPad_02(i, j, n - 1, m - 1, keypad, k, dp);

                }
            }

        }
        return countways;
    }
    // 7827960514
    public static boolean isPalindromicSubstring(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        return dp[0][n];

    }

     public  String longestPalindromicSubstring(String str){
            int n = str.length();
            int dp[][] = new int[n][n];
          
            if(n==0) return "";
            int si = 0;
            int ei = 0;
            int maxLen  = 0 ; 
            for(int gap= 0 ; gap<n; gap++){
                for(int i = 0 , j = gap ; j<n ; i++ , j++ ){
                    if(gap==0) dp[i][j] = 1;
                
                else if(gap==1 && str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2;
                } 
                else if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]!=0){
                      dp[i][j] = gap+1; 

                }
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    si = i;
                    ei = j;

                }
                }
            }
            return str.substring(si,ei+1);
     }
       public String longestPalindromicSubstring_BTR(String s) {
        if(s.length()==0){
            return "";
        }
         int start = 0;
         int maxLength = 1;
         
         for(int i = 1 ; i<s.length();i++ ){
             int lo = i-1;
             int hi = i+1;
             while(lo>=0 && hi<s.length() && s.charAt(lo) == s.charAt(hi)){
                 
                   int length = hi-lo+1;
                  if(length>maxLength){
                        start = lo;
                       maxLength = length;
                  }
                 lo--;
                 hi++;
             }
             
              lo = i-1;
              hi = i;
              while(lo>=0 && hi<s.length() && s.charAt(lo) == s.charAt(hi)){
                  
                   int length = hi-lo+1;
                 if(length>maxLength){
                        start = lo;
                       maxLength = length;
                  }
                  lo--;
                  hi++;
             }
             
             
         }
        
         for(int i = start; i<start+maxLength;i++){
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
    public static int CountAllPalindromicSubstring(String str) { // leetcode 647
        int n = str.length();
        int dp[][] = new int[n][n];
        int si = 0;
        int ei = 0;
        int maxLen = 0;
        int count = 0;
        if (n == 0) return 1;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) dp[i][j] = 1;

                else if (gap == 1 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 2;
                } else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] != 0) {
                    dp[i][j] = gap + 1;

                }
                count += dp[i][j] != 0 ? 1 : 0;
            }
        }
        return count;
    }

    public int longestPalindromicSubsequence(String str, int si, int ei, int dp[][]) {
        if (si > ei) return 0;

        if (si == ei)
            return dp[si][ei] = 1;

        if (dp[si][ei] != 0)

            return dp[si][ei];

        if (str.charAt(si) == str.charAt(ei)) {
            return dp[si][ei] = longestPalindromicSubsequence(str, si + 1, ei - 1, dp) + 2;
        }

        return dp[si][ei] = Math.max(longestPalindromicSubsequence(str, si + 1, ei, dp), longestPalindromicSubsequence(str, si, ei - 1, dp));

    }
    public int longestPalindromicSubsequence_DP(String str, int si, int ei, int dp[][]) {


        for (int gap = 0; gap < str.length(); gap++) {
            for (si = 0, ei = gap; ei < str.length(); si++, ei++) {
                if (gap == 0) {
                    dp[si][ei] = 1;
                    continue;
                } else
                if (str.charAt(si) == str.charAt(ei)) {
                    dp[si][ei] = dp[si + 1][ei - 1] + 2;
                } else {
                    dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
                }
            }
        }

        return dp[0][str.length() - 1];
    }
    int longestPlaindromeSubseq_DP_02(String str, int si, int ei, int dp[][], boolean isPalindrome[][]) {

        for (int gap = 0; gap < str.length(); gap++) {
            for (si = 0, ei = gap; ei < str.length(); si++, ei++) {

                if (isPalindrome[si][ei]) {
                    dp[si][ei] = ei - si + 1;
                    continue;
                }

                int len = 0;
                if (str.charAt(si) == str.charAt(ei))
                    len = dp[si + 1][ei - 1] + 2;
                else
                    len = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
                dp[si][ei] = len;
            }
        }

        return dp[0][str.length() - 1];
    }

    static long distinct_subsequences(StringBuffer S, StringBuffer T, int n, int m, long dp[][]) {  // leetcode 115
        if (m == 0)
            return dp[n][m] = 1;
        if (m > n)
            return dp[n][m] = 0;

        if (dp[n][m] != 0)
            return dp[n][m];

        if (S.charAt(n - 1) == T.charAt(m - 1))
            return dp[n][m] = distinct_subsequences(S, T, n - 1, m - 1, dp) + distinct_subsequences(S, T, n - 1, m, dp);

        return dp[n][m] = distinct_subsequences(S, T, n - 1, m, dp);
    }

    static int distinct_subsequences_DP(String S, String T, int n, int m, int dp[][]) { 
        int N = n;
        int M = m;
        for (n = 0; n <= N; n++) {
            for (m = 0; m <= M; m++) {
                if (m == 0)
                    dp[n][m] = 1;
                else
                if (m > n)
                    dp[n][m] = 0;

                else
                if (S.charAt(n - 1) == T.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + dp[n - 1][m];
                else
                    dp[n][m] = dp[n - 1][m];
            }
        }
        return dp[N][M];

    }

    public int distinctSubseqII(String str) {   // leetcode 940
        int mod = (int)1e9+7;
        str = "&" + str;
        long dp[] = new long[str.length()];
        int map[] = new int[26]; // to store last occurence
        Arrays.fill(map,-1);
        for(int i = 0 ; i<str.length() ; i++){
            if(i==0) {dp[i] = 1;
            continue;}
            if(map[str.charAt(i) - 'a']== -1){
              
             dp[i] =( dp[i-1] % mod * 2) % mod;
            
            }else{
               dp[i] = dp[i-1]%mod * 2 - dp[map[str.charAt(i) - 'a']-1]%mod + mod;
            }
            map[str.charAt(i)-'a'] = i ;
        }
           
        return (int) (dp[str.length()-1]%mod - 1 + mod) % mod;
}

    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        return DecodeWays(s,0,dp);
    }
   static int DecodeWays(String str,int idx ,int dp[]){
   if(idx == str.length()){
       
       return dp[idx]=1;
   }
    if(str.charAt(idx)== '0' ){
        return dp[idx]= 0 ; 
    }
    int count = 0 ; 
    count+= DecodeWays(str,idx+1,dp);
    if(idx < str.length()-1){
            int no = (str.charAt(idx)-'0')*10 + (str.charAt(idx+1)-'0');
            if(no<=26){
                count+=DecodeWays(str,idx+2,dp);
        }
     }
     return dp[idx]=count;
}



int numDecodingsII_recu(String str, int idx )
{
    int mod = (int)1e9+7;
    if(idx==str.length()){
         return 1;
    } 
     int count = 0 ;
     if(str.charAt(idx) == '*'){
         count = (count + 9 * numDecodingsII_recu(str, idx + 1) ); // 1st character * and choosing * independently
     if(idx < str.length() - 1) // 1st character * and choosing * as two digit no
     {
     if (str.charAt(idx+1) >= '0' && str.charAt(idx+1) <= '6')
         count = (count + 2 * numDecodingsII_recu(str, idx + 2))
     else if (str.charAt(idx+1) >= '7')
         count = (count  + numDecodingsII_recu(str, idx + 2) ) 
     else if (str.charAt(idx+1) == '*')
         count = (count + 15 * numDecodingsII_recu(str, idx + 2)  ) ;
     }

     }
      
     else if (str.charAt(idx) > '0')
 {

     count = (count % mod + numDecodingsII_recu(str, idx + 1) % mod) % mod;
     if (idx < str.length() - 1)
     {
         if (str.charAt(idx+1) != '*')
         {
             int num = (str.charAt(idx) - '0') * 10 + (str.charAt(idx+1) - '0');
             if (num <= 26)
                 count = (count % mod + numDecodingsII_recu(str, idx + 2) % mod) % mod;
         }
         else if (str.charAt(idx) == '1')
             count = (count % mod + 9 * numDecodingsII_recu(str, idx + 2) % mod) % mod;
         else if (str.charAt(idx) == '2')
             count = (count % mod + 6 * numDecodingsII_recu(str, idx + 2) % mod) % mod;
     }
 }
     return  count;
 }

// https://www.geeksforgeeks.org/problems/count-palindromic-subsequences/1
    public static int CountPS(String s, int si, int ei, int dp[][]) {
        if (si > ei) {
            return 0;
        }
        if (si == ei) {
            return dp[si][ei] = 1;

        }
        if (dp[si][ei] != 0) return dp[si][ei];
        int middleString = CountPS(s, si + 1, ei - 1, dp);
        int excStartIndex = CountPS(s, si + 1, ei, dp); // excluding startIndex + excluding both index is inclusive
        int excEndIndex = CountPS(s, si, ei - 1, dp);  //excluding endIndex + excluding both index is inclusive
        if (s.charAt(si) == s.charAt(ei)) { 
                                // including both         // excluding start or end or both                        // not including both
            return dp[si][ei] = (middleString + 1) + (excStartIndex - middleString + excEndIndex - middleString) + middleString;
        }
        return dp[si][ei] = (excStartIndex - middleString) + (excEndIndex - middleString) + middleString;
    }

    public static int CountPS_DP(String s, int si, int ei, int dp[][]) {
        int N = s.length();
        for (int gap = 0; gap < N; gap++) {
            for (si = 0, ei = gap; ei < N; si++, ei++) {

                if (si == ei) {
                    dp[si][ei] = 1;
                    continue;

                }
                int middleString = dp[si + 1][ei - 1];
                int excStartIndex = dp[si + 1][ei];
                int excEndIndex = dp[si][ei - 1];
                if (s.charAt(si) == s.charAt(ei)) {
                    dp[si][ei] = (middleString + 1) + (excStartIndex + excEndIndex - middleString);
                } else
                    dp[si][ei] = excStartIndex + excEndIndex - middleString;

            }

        }

        return dp[0][N - 1];
    }

    public static int longestCommonSubsequence(String text1, String text2, int i, int j, int dp[][]) {
        System.out.println(i + " " + j);
        if (i == text1.length() || j == text2.length()) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != 0) return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = longestCommonSubsequence(text1, text2, i + 1, j + 1, dp) + 1;
        } else
            return dp[i][j] = Math.max(longestCommonSubsequence(text1, text2, i, j + 1, dp), longestCommonSubsequence(text1, text2, i + 1, j, dp));
    }

    public static int longestCommonSubsequence_DP(String text1, String text2, int dp[][]) {
        for (int i = text1.length(); i >= 0; i--) {
            for (int j = text2.length(); j >= 0; j--) {
                if (i == text1.length() || j == text2.length()) {
                    dp[i][j] = 0;

                } else
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);

            }
        }
        return dp[0][0];

    }

    static int max = 0;
    public static int longestCommonSubstring(String text1, String text2, int i, int j, int dp[][]) {
        if (i == text1.length() || j == text2.length()) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        longestCommonSubstring(text1, text2, i + 1, j, dp);
        longestCommonSubstring(text1, text2, i, j + 1, dp);
        if (text1.charAt(i) == text2.charAt(j)) {
            int a = longestCommonSubstring(text1, text2, i + 1, j + 1, dp) + 1;
            max = Math.max(max, a);
            return dp[i][j] = max;
        }
        return 0;
    }

    public static int longestCommonSubstring_DP(String text1, String text2, int i, int j, int dp[][]) {
        for (i = text1.length(); i >= 0; i--) {
            for (j = text2.length(); j >= 0; j--) {
                if (i == text1.length() || j == text2.length()) {
                    dp[i][j] = 0;

                } else
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    max = Math.max(dp[i][j], max);
                }


            }

        }
        return max;
    }

    public int C(int[] A, int[] B) {
        int dp[][] = new int[A.length + 1][B.length + 1];
        for (int i = A.length; i >= 0; i--) {
            for (int j = B.length; j >= 0; j--) {
                if (i == A.length || j == B.length) {
                    dp[i][j] = 0;
                } else if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length; i >= 0; i--) {
            for (int j = nums2.length; j >= 0; j--) {
                if (i == nums1.length || j == nums2.length) {
                    dp[i][j] = (int) - 1e8;
                    continue;
                }

                int val = nums1[i] * nums2[j];
                dp[i][j] = Math.max(Math.max(dp[i + 1][j + 1] + val, val), Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }
        return dp[0][0];
    
    }

//  https://www.geeksforgeeks.org/find-number-of-solutions-of-a-linear-equation-of-n-variables/

public static int linearEquation(int coeff[] , int rhs){
    int dp[] = new int[rhs+1];
    dp[0] =1;
    for(int ele : coeff){
        for(int tar =ele ; tar<=rhs ; tar++ ){
           
            dp[tar] += dp[tar-ele];
        }
    }
    return dp[rhs];
}
// leetcode 322===============================================
  public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
      
        for(int i = 1 ;i<dp.length;i++){
            dp[i] = (int)1e8;
        }
       
        for(int i = 0 ; i<dp.length ; i++){
            for(int ele:coins){
                
                if(i-ele>=0){
                    dp[i] = Math.min(dp[i],dp[i-ele] + 1); 
                }
            }
            
        }
      
        return dp[amount]==(int)1e8? -1 : dp[amount];
       
    }

    public static int targetSum(int coins[] , int idx , int tar , int dp[][]){
        if(idx == coins.length || tar == 0){
       if(tar == 0 ){
           return dp[idx][tar]=1;
       }
       return dp[idx][tar]=0 ;
        } 
        int count = 0;
        
              if(tar-coins[idx]>=0){
              count+=targetSum(coins, idx+1 , tar-coins[idx],dp);
              }
              
              count+=targetSum(coins, idx+1,tar,dp);
          return dp[idx][tar]=count;
    }

   static int targetSum_02(int coins[] , int idx , int tar , int dp[][])
    {   
    if (tar == 0 || idx == 0)
    {
        if (tar == 0)
            return dp[idx][tar] = 1;
        return dp[idx][tar] = 0;
    }

    if (dp[idx][tar] != 0)
        return dp[idx][tar];

    int count = 0;
    if (tar - coins[idx - 1] >= 0)
        count += targetSum_02(coins, idx - 1, tar - coins[idx - 1], dp);

    count += targetSum_02(coins, idx - 1, tar, dp);
    return dp[idx][tar] = count;
}

static int targetSum_DP(int coins[] , int idx , int tar , int dp[][])
    {    int Tar = tar ;
    for(idx = 0 ; idx <= coins.length ; idx++){
    for(tar = 0 ; tar <=Tar ; tar++){
    if (tar == 0 || idx == 0)
    {
        if (tar == 0)
        dp[idx][tar] = 1;
        continue;
    }
    else{
    if (tar - coins[idx - 1] >= 0)
         dp[idx][tar] += dp[idx-1][tar - coins[idx-1]]   ;
         
         }
         dp[idx][tar] += dp[idx-1][tar];

 



    }
}

return dp[coins.length][Tar]; 
}

 static boolean targetSum_DP_02(int coins[] , int idx , int tar , boolean dp[][])
{    int Tar = tar ;
    for(idx = 0 ; idx <= coins.length ; idx++){
    for(tar = 0 ; tar <=Tar ; tar++){
    if (tar == 0 || idx == 0)
    {
        if (tar == 0)
        dp[idx][tar] = true;
        continue;
    }
    else{
    if (tar - coins[idx - 1] >= 0)
         dp[idx][tar]  = dp[idx][tar] || dp[idx-1][tar - coins[idx-1]]   ;
         
         }
         dp[idx][tar]  = dp[idx][tar]||dp[idx-1][tar];

 



    }
}

return dp[coins.length][Tar]; 
   
}

public static int Knapsack01(int wt[] , int p[] , int weight, int n , int dp[][]){
    if(weight == 0 || n == 0 ){
       
        return dp[weight][n] = 0;
    }
    if(dp[weight][n]!=0 ) return dp[weight][n];
    int maxProfit = (int) -1e8;
    if(weight-wt[n-1]>=0)
  maxProfit = Math.max(maxProfit,Knapsack01(wt,p,weight-wt[n-1],n-1,dp) + p[n-1]);
  maxProfit = Math.max(maxProfit,Knapsack01(wt,p,weight,n-1,dp));
  return dp[weight][n] = maxProfit;
}
public static int Knapsack01_DP(int wt[] , int p[] , int weight, int n , int dp[][]){
  int Weight = weight;
   for(weight = 0 ; weight<=Weight ; weight++){
       for(n = 0 ; n <=wt.length ; n++){
           if(weight == 0 || n == 0 ){
       
         dp[weight][n] = 0;
         continue;
    }
   
    int maxProfit = (int) -1e8;
    if(weight-wt[n-1]>=0)
  maxProfit = Math.max(maxProfit,dp[weight-wt[n-1]][n-1]+ p[n-1]);
  maxProfit = Math.max(maxProfit,dp[weight][n-1] ) ;
      dp[weight][n] = maxProfit;

       }
   }
   return dp[Weight][wt.length];
    
}

int unbounded_knapsack(int w[], int p[], int weight)
{
    int dp[] = new int [w.length+1];
    dp[0] = 0;
    for (int i = 0; i < w.length; i++)
        for (int tar = w[i]; tar <= weight; tar++)
            dp[tar] = Math.max(dp[tar], dp[tar - w[i]] + p[i]);

    return dp[w.length];
}
 
    public  boolean canPartiton(int nums[] , int sum , int dp[][], int idx){
     if(idx == 0 || sum==0 ){
         if(sum == 0 ){
              dp[sum][idx]=1;
             return true;
         }
         else{
           dp[sum][idx]= 0;
             return false;
         }
         
     }
    if(dp[sum][idx]!=-1){
        if(dp[sum][idx]==1) return true;
        return false;
    }
     boolean ret = false;
     if(sum- nums[idx-1] >=0)
     ret = ret ||  canPartiton(nums,sum-nums[idx-1] , dp , idx-1);
      ret = ret ||  canPartiton(nums,sum,dp,idx-1);
        dp[sum][idx]= ret==true ?1 : 0;
        return ret;
}

 public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int  i = 0 ; i<nums.length;i++){
          sum+=nums[i];  
        }
        
        int dp[][] =new int[sum+1][nums.length+1];
        for(int i = 0 ;i<dp.length;i++){
            for(int j = 0 ; j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        if(sum%2!=0 ) return false;
        return canPartiton(nums,sum/2,dp,nums.length) ;
    }

     public static  int minDistance(String word1, String word2) {
         int dp[][] = new int[word1.length()+1][word2.length()+1];
        return minDistance(word1,word2,word1.length(),word2.length(),dp);
    }

    public static int minDistance(String word1, String word2 , int i , int  j , int dp[][]){
        if(i==0) return j;
        if(j==0 ) return i;
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            return dp[i][j]=minDistance(word1,word2,i-1,j-1,dp);
        }
        if(dp[i][j] != 0) return dp[i][j];
        
        int insert = minDistance(word1,word2,i,j-1,dp);
         int delete = minDistance(word1,word2,i-1,j,dp);
         int replace = minDistance(word1,word2,i-1,j-1,dp);

         return dp[i][j] = Math.min(insert,Math.min(delete,replace))+1;

    }

    public int minDistanceTabulation(String word1 , String word2){


        for(int i = 0 ; i <= word1.length() ; i ++){
            for(int j = 0 ; j <= word2.length() ; j ++) {
                if(i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = i;
                    continue;
                }
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                int insert = dp[i][j-1];
                int delete = dp[i-1][j];
                int replace = dp[i-1][j-1];
                dp[i][j] = Math.min(insert,Math.min(delete,replace))+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
 

 static int sum = 0;
    public int findTargetSumWays(int[] nums, int S) {
        
        for(int i = 0 ; i<nums.length;i++){
            sum+=nums[i];
        }
       
        
        int dp[][] = new int[nums.length+1][2*sum+1 ];
        for(int  i = 0 ; i<dp.length;i++){
            for(int j = 0 ; j<dp[0].length;j++){
                dp[i][j] = (int)1e8;
            }
        }
        return findTargetSumWays(nums,0,nums.length,dp,S);
      
        
       
    }

    public int findTargetSumWays(int[] nums , int S, int idx , int dp[][] , int tar){
    if(idx == 0 ){
        if(S==tar){
            
            return 1;
        }
        
        return   0;
        
    }
       if(dp[idx][S+sum]!=(int)1e8 ) return dp[idx][S+sum];
        
   
   
    int inc = findTargetSumWays(nums,S+nums[idx-1] , idx-1 ,dp,tar);
      
    int exc= findTargetSumWays(nums,S-nums[idx-1],idx-1, dp,tar);
     
    return dp[idx][S+sum]=inc+exc ;
}


static int LISLeftToRight(int arr[] , int dp[] ){
    int max =  0 ;
    for(int i = 0 ; i<arr.length ; i++){
        dp[i]  = 1 ;
        for(int j = i-1  ; j >= 0 ; j-- ){
            if(arr[j] < arr[i]){
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        max = Math.max(max,dp[i]);
    }
    return max;
}

static int LISRightToleft(int arr[] , int dp[] ){ // lDS
    int max =  0 ;
    for(int i = arr.length-1 ; i>=0 ; i--){
        dp[i]  = 1 ;
        for(int j = i+1  ; j <arr.length  ; j++ ){
            if(arr[j] < arr[i]){
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        max = Math.max(max,dp[i]);
    }
    return max;
}

static int LBS(int arr[] , int dp[] ){
    int LISRightToleft[] = new int[arr.length];
    int LISLeftToRight[] = new int[arr.length];
     LISRightToleft(arr , LISRightToleft);
     LISLeftToRight(arr ,  LISLeftToRight);
     int max = 0 ; 
     for(int i = 0 ; i< arr.length ; i++){
         max = Math.max(max,LISRightToleft[i]+LISLeftToRight[i]-1);
     }
     System.out.println(max);
     return max;
}

static int MaxSumIncreasingSubsequence(int arr[] , int dp[]){
    int max =  0 ; 
    for(int i=0; i<arr.length ; i++){
        dp[i] = arr[i];
        for(int j = i-1 ; j>=0 ; j--){
            if(arr[j]<arr[i]){
                dp[i] = Math.max(dp[i] , dp[i] + arr[j]);
            }
        }
        max = Math.max(max,dp[i]);
    }
    System.out.println(max);
    return max;
}

// minimum no of deletion to make array in sorted order in increasing order.
int minDeletion(int arr[]){
    int dp[] = new int[arr.length];
    int lengthOfLIS = LISLeftToRight(arr, dp);
    return arr.length - lengthOfLIS;    
    }
    
        public int maxEnvelopes(int[][] envelopes) {
      int max = 0 ;
       int dp[] = new int[envelopes.length];
        Arrays.sort(envelopes , (int a[] , int b[])->{
             if(a[0] == b[0]){
                 return b[1] - a[1];
             }
            return a[0] - b[0] ;
        });
        for(int i = 0 ; i<envelopes.length ; i++){
         dp[i] = 1;
         for(int j = i-1 ; j>=0 ; j--){
             if(envelopes[j][1] < envelopes[i][1] ){
                 dp[i]  = Math.max(dp[i] , dp[j] + 1);
                 
             }
           
        }
              max = Math.max(max,dp[i]);
       
    }
        
          return max;
}

// leetcode 673
 public static int findNumberOfLIS(int[] nums) {   //nice question
     
        int dp[] = new int[nums.length];
        int count[] = new int[nums.length];
        int maxCount = 0 ;
        int maxLength = 0 ;
        for(int i = 0 ;  i <nums.length ; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j = i-1 ; j >= 0 ; j--){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i] ){
                    
                      dp[i] = dp[j] + 1; 
                      count[i] = count[j];
                     
                      
                    }
                    else
                     if(dp[j] + 1 == dp[i] ){
                        count[i]+=count[j] ;
                    }
                    


                    
                }
               
            }
            if(dp[i]>maxLength){
                maxLength = dp[i];
                maxCount = count[i];
            }
            else
            if(maxLength == dp[i]){
                maxCount += count[i];
            }
            
           
        }
      
       
       return maxCount;
    }

   public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        return DecodeWays(s,0,dp);
    }

   static int DecodeWays(String str,int idx ,int dp[]){
   if(idx == str.length()){
       
       return dp[idx]=1;
   }
    if(str.charAt(idx)== '0' ){
        return dp[idx]= 0 ; 
    }
    int count = 0 ; 
    count+= DecodeWays(str,idx+1,dp);
    if(idx < str.length()-1){
            int no = (str.charAt(idx)-'0')*10 + (str.charAt(idx+1)-'0');
            if(no<=26){
                count+=DecodeWays(str,idx+2,dp);
        }
     }
     return dp[idx]=count;
}

static int AiBjCk(string str)
{
    int acount = 0;
    int bcount = 0;
    int count = 0;
    for (int i = 0; i < str.length(); i++)
    {
        if (str[i] == 'a')
            acount = acount + (1 + acount);
        else if (str[i] == 'b')
            bcount = bcount + (acount + bcount);
        else
            ccount = ccount + (bcount + ccount);
    }

    return ccount;
}
   
    long numDecodingsII_DP(string &str, int idx, vector<long> &dp)
{
    for (idx = str.length(); idx >= 0; idx--)
    {
        if (idx == str.length())
        {
            dp[idx] = 1;
            continue;
        }

        int count = 0;
        if (str[idx] == '*')
        {
            count = (count % mod + 9 * dp[idx + 1] % mod) % mod;
            if (idx < str.length() - 1 && str[idx + 1] >= '0' && str[idx + 1] <= '6')
                count = (count % mod + 2 * dp[idx + 2] % mod) % mod;
            else if (idx < str.length() - 1 && str[idx + 1] >= '7')
                count = (count % mod + dp[idx + 2] % mod) % mod;
            else if (idx < str.length() - 1 && str[idx + 1] == '*')
                count = (count % mod + 15 * dp[idx + 2] % mod) % mod;
        }
        else if (str[idx] > '0')
        {

            count = (count % mod + dp[idx + 1] % mod) % mod;
            if (idx < str.length() - 1)
            {
                if (str[idx + 1] != '*')
                {
                    int num = (str[idx] - '0') * 10 + (str[idx + 1] - '0');
                    if (num <= 26)
                        count = (count % mod + dp[idx + 2] % mod) % mod;
                }
                else if (str[idx] == '1')
                    count = (count % mod + 9 * dp[idx + 2] % mod) % mod;
                else if (str[idx] == '2')
                    count = (count % mod + 6 * dp[idx + 2]) % mod;
            }
        }
        dp[idx] = count;
    }
    return dp[0];
}

long numDecodingsII_Fast(string &str, int idx, vector<long> &dp)
{
    long a = 0;
    long b = 1;
    long count = 0;
    for (idx = str.length() - 1; idx >= 0; idx--)
    {
        count = 0;
        if (str[idx] == '*')
        {
            count = (count % mod + 9 * b % mod) % mod;
            if (idx < str.length() - 1 && str[idx + 1] >= '0' && str[idx + 1] <= '6')
                count = (count % mod + 2 * a % mod) % mod;
            else if (idx < str.length() - 1 && str[idx + 1] >= '7')
                count = (count % mod + a % mod) % mod;
            else if (idx < str.length() - 1 && str[idx + 1] == '*')
                count = (count % mod + 15 * a % mod) % mod;
        }
        else if (str[idx] > '0')
        {

            count = (count % mod + b % mod) % mod;
            if (idx < str.length() - 1)
            {
                if (str[idx + 1] != '*')
                {
                    int num = (str[idx] - '0') * 10 + (str[idx + 1] - '0');
                    if (num <= 26)
                        count = (count % mod + a % mod) % mod;
                }
                else if (str[idx] == '1')
                    count = (count % mod + 9 * a % mod) % mod;
                else if (str[idx] == '2')
                    count = (count % mod + 6 * a) % mod;
            }
        }

        a = b;
        b = count;
    }
    return count;
}

public int nthUglyNumber(int n) {     
        ArrayList<Integer>arr = new ArrayList<>();
        arr.add(1);
        int twoIdx = 0 ;
        int threeIdx = 0 ;
        int fiveIdx = 0 ;
        while(arr.size()<n){
             int mulby2 = arr.get(twoIdx)*2;
             int mulby3 = arr.get(threeIdx)*3;
             int mulby5 = arr.get(fiveIdx)*5;
             int min = Math.min(mulby2 , Math.min(mulby3, mulby5));
             arr.add(min);
             if(min == mulby2 ) twoIdx++; 
             if(min == mulby3) threeIdx++;
             if(min == mulby5) fiveIdx++;
        }
        return arr.get(arr.size()-1);
    }
    class Ones and Zeroes  {
    public int findMaxForm(String[] strs, int m, int n) {
          int arr[] =  count(strs);
          dp = new int[m+1][n+1][strs.length+1];
         for(int arr1[][] : dp){
               for(int arr2[]:arr1){
                   Arrays.fill(arr2,-1);
               }
             
         }
       return  solve(strs,arr,m, n ,0);
       
    }
    int dp[][][] ;
    public  int  solve(String[]str,int arr[] , int m , int n , int i ){


        if(i>=str.length){
            return 0;
        }
        if(dp[m][n][i]!=-1){
            return dp[m][n][i];
        }
        int zc = str[i].length()-arr[i];
        int oc = arr[i];
        int a1 = 0;
        if(m>=zc && n>=oc){
              a1 = solve(str,arr,m - zc , n - oc  , i+1  )+1;
        }
        
       
        int a2 = solve(str,arr,m , n  , i+1  );
        return  dp[m][n][i]=Math.max(a1,a2);
    }
    public int[] count(String[] str){
        int count[] = new int[str.length];
         int k = 0 ; 
        for(String s : str){
               for(int i = 0 ; i<s.length() ; i++){
                    count[k] += s.charAt(i)-'0';
               } 
            k++;
         }
        return count;
    }
}
//--------------------------------------------------> // To be DOne

    public static void main(String[] args) {
     
  int arr[] = {2,2,2,2};
  int dp[] = new int[arr.length+1];
  findNumberOfLIS(arr);
        
    }
}

