  public boolean backspaceCompare(String S, String T) {
        int hashCount = 0;
     
        int i = S.length()-1;
       
        StringBuilder ans1=new StringBuilder();
        StringBuilder ans2=new StringBuilder();
        while(i>=0){
            char ch = S.charAt(i);
            if(ch=='#'){
                hashCount++;
               
            }
            else if(hashCount>0){
               hashCount--;
            }
            else{
                ans1.append(ch);
            }
            i--;
        }
        hashCount = 0;
        i = T.length()-1;
          while(i>=0){
            char ch = T.charAt(i);
              
            if(ch=='#'){
                hashCount++;
               
            }
            else if(hashCount>0){
                  hashCount--;
            }
            else{
                ans2.append(ch);
            }
            i--;
        }
    
        return ans1.toString().equals(ans2.toString());
        
    }
    static int minBracketReversals(String str){
        int unbalancedOpen = 0 ;
		int unbalancedClosed = 0;
         
		for(int i = 0 ; i <str.length();i++){
		   
		    if(str.charAt(i)=='['){
		        
		        unbalancedOpen++;
		    }
		    else if(str.charAt(i)==']' && unbalancedOpen>0){
		        
		        unbalancedOpen--;
		    }
		    else{
		        unbalancedClosed++;
		    }
		}
	
		
		int ans = 0;
	  if(unbalancedOpen%2==0 && unbalancedClosed%2==0 ){
	      ans = (unbalancedOpen)/2+(unbalancedClosed)/2  ;
	  }
	  
	  else if (unbalancedOpen%2!=0 && unbalancedClosed%2!=0 ){
	      ans = (unbalancedOpen)/2+(unbalancedClosed)/2 + 2   ;
	  }
	  else {
	      ans = -1;
	  }
	 return ans;

}
//https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing/0
 int minAdjacentSwaps(String str){
        int unbalancedOpen = 0 ;
		int unbalancedClosed = 0;
        int imbalance = 0;
        int ans = 0;
		for(int i = 0 ; i <str.length();i++){
		   
		    if(str.charAt(i)=='['){
		        
		        unbalancedOpen++;
		        if(imbalance>0){
		           ans+= imbalance;
		           imbalance--;
		        }
		    }
		    else if(str.charAt(i)==']'){
		        
		        unbalancedClosed++;
		        imbalance = unbalancedClosed - unbalancedOpen;
		        
		    }
		    
		}
	
		
	
	 return ans;
}

//https://www.geeksforgeeks.org/length-longest-balanced-subsequence/
static int LongestBalancedParenthesissubsequence(String s, int n) 
    { 
      
        int invalidOpenBraces = 0; 
  
     
        int invalidCloseBraces = 0; 
  
    
        for (int i = 0; i < n; i++) { 
            if (s.charAt(i) == '(') { 
  
                invalidOpenBraces++; 
            } 
            else { 
                if (invalidOpenBraces == 0) { 
  
                
                    invalidCloseBraces++; 
                } 
                else { 
  
                    invalidOpenBraces--; 
                } 
            } 
        } 
        return ( 
            n - (invalidOpenBraces 
                 + invalidCloseBraces)); 
    } 
    public static  void Generate_Binary_Numbers(int n ){
        class pair{
            String binary;
            int no ;
            pair( String binary, int no ){
                this.no = no;
                this.binary = binary;
            }
        }
        LinkedList<pair> q = new LinkedList<>();
        q.addFirst(new pair("1",1));
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                pair top = q.removeLast();
               
                 if(top.no<=n){
                     System.out.print(top.binary+" ");
                 }
                 else{
                     System.out.println();
                     return;
                 }
                  q.addFirst(new pair(top.binary+"0",top.no*2));
                 q.addFirst(new pair(top.binary+"1",top.no*2 + 1 ));
                
                 
                
            }
        }
    }
    //https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0
    public static void firstNegativeInWindowSizeK(int arr[],int k){
        int i = arr.length-1;
        int j = i-k+1;
        int t = arr.length-1;
        while(t>=j){
               if(arr[t]<0){
                   i = t;
               }
               t--;
        }
        int[] ans = new int[arr.length - k +1];

        while(j>=0 && i>=0){
            
            if(arr[j]<0){
                i = j;
            }
            if(i>=j && i<=j+k-1 && arr[i]<0){
                
                ans[j] = arr[i];
            }
            else {
                ans[j] = 0; 
            }
            j--;
        }
        for( i = 0;  i<ans.length;i++){
            
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        
    }
    //https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays/0
      public static void Max_sum_in_sub_arrays(long arr[]){
              if(arr.length==1) {
             System.out.println(arr[0]);
              return ;
            }
          int i = 0;
          int j = 1;
          long Maxsum = 2*Integer.MIN_VALUE;
          while(j<arr.length){
              long sum = (arr[i]+arr[j]);
             
              Maxsum = Math.max(sum,Maxsum);
              i++;
              j++;
          }
          System.out.println(Maxsum);
    }
    //leetcode 134
     public int canCompleteCircuit(int[] gas, int[] cost) {
            int currentGas = 0;
            int start = 0;
           int totalGas=0;;
          for(int i = 0; i<gas.length;i++){
              currentGas+= gas[i]-cost[i];
              if(currentGas<0){
                 
                  currentGas = 0;
                  start = i+1;
                  
              }
              totalGas+=gas[i]-cost[i];
          }
        if(totalGas<0) return -1;
       
        return start;
    }
     public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0  ){
            return 0;
        }
            int arr[] = new int[matrix[0].length];
        int max = 0;
          for(int i = 0  ; i<matrix.length ; i++){
              for(int j = 0 ; j<matrix[0].length;j++){
                   int ele = matrix[i][j]-'0';
                    if(ele==0){
                        arr[j] = 0;
                    }
                  else{
                      arr[j]+=1;
                  }
              }
              int area = largestRectangleArea(arr);
              max = Math.max(area,max);
          }
        return max;
    }

    //leetcode 388
    public int lengthLongestPath(String input) {
        int max = 0; 
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(String str : input.split("\n")){
          int level = str.lastIndexOf('\t')+1;
          int length = str.length() - level;
          while(st.size() - 1 > level){
              st.pop();
          }
  
          if(str.contains(".")){
            int len = st.peek() + length;
            max = Math.max(len,max);
          }
          else{
            st.push(length + st.peek()+1);
          }
        }
        return max;
      }
   