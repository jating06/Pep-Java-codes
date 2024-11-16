import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Question{
     public boolean isLongPressedName(String name, String typed) {
        char Name[] = name.toCharArray();
        char Typed[] = typed.toCharArray();
        int n = Name.length;
        int m = Typed.length;
        int i = 0 ;
        int j = 0 ;
        while(j < m){
            if(i<n && Name[i]==Typed[j]){
                i++;
                j++;
            }
            else if(j==0 || Typed[j]!=Typed[j-1]){
                return false;
            }
            else{
                j++;
            }
        }
        return i==n;
        
    }

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String a = strs[0];
        String b = strs[strs.length-1];
        int i = 0;
        while(i <a.length() && i < b.length() && a.charAt(i) == b.charAt(i)){
            i++;
        }
        return a.substring(0,i); 
    }


    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
 
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
     }

      public int[] RangeAddition(int length, int[][] updates) {
             int arr[] = new int[length];
             for(int i = 0 ; i < updates.length;i++){
                   int si = updates[i][0];
                   int ei = updates[i][1];
                   int inc = updates[i][2];
                   arr[si]+= inc;
                   if(ei+1<arr.length)
                   arr[ei+1]+= (-inc);
             }
             for(int i = 1 ; i<arr.length;i++){
                 arr[i] += arr[i-1];
             }
             return arr;
    }
       public void reverse(int []num , int si , int ei){
        while(si<ei){
            int temp = num[si];
            num[si] = num[ei];
            num[ei] = temp;
            si++;
            ei--;
        }
        
        
    }

    //leetcode 189
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        if(k<0){
            k=k+n;
        }
        if(k>n){
            k = k % n;
        }
          reverse(nums,0,n-k-1);
          reverse (nums,n-k,n-1);
         reverse(nums,0,n-1);
        
    }
        public void swap(char arr[] , int i , int j ){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
   
    public int nextGreaterElement(int n) {
       String s = n+"";
        char arr[] = s.toCharArray();
        int smallElementidx = -1;
        for(int i = arr.length-2; i>=0 ; i--){
            if(arr[i]<arr[i+1]){
                smallElementidx = i;
                break;
            }
        }
        if(smallElementidx ==  -1) return -1;
        
        int largerElement = -1;
        for(int  i = smallElementidx+1 ; i<arr.length;i++){
            if(arr[i] > arr[smallElementidx]){
                largerElement = i;
                
                
            } 
            else{
               break ;
            }
            
            
        }
        
        swap(arr,smallElementidx,largerElement);
        reverse(arr,smallElementidx+1,arr.length-1);
        String ans = new String(arr);
        long longe= Long.parseLong(ans);
        if(longe>Integer.MAX_VALUE){
            return -1;
        }
        int inte = Integer.parseInt(ans);
        
   
         
       
        return inte;
    }
 
     public int maxSubArray(int[] nums) {   //kadens algo
         int cs = 0 ;
         int ms = Integer.MIN_VALUE ;
         for(int  i = 0 ; i<nums.length;i++){
             cs = cs + nums[i];
           
             if(cs>ms){
                 ms = cs;
             }
             
               if(cs<0){
                 cs = 0;
                 
             }
         }
        return ms;
    }
    public int[] sortedSquares(int[] A) {
         int i = 0 ;
         int j = A.length-1;
         int k = A.length-1;
         int ans[]=new int[A.length];
         while(i<=j){
             if(A[i]*A[i]>A[j]*A[j]){
                 ans[k] = A[i]*A[i];
                 i++;
             }
             else {
                 ans[k] = A[j]*A[j];
                 j--;
             }
             k--;
         }
        return ans;
    }

     public int maxArea(int[] height) {
        int i = 0 ; 
        int j = height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int min = Math.min(height[i],height[j]);
            max = Math.max(max,min*(j-i));
            if(height[i]<height[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return max;
    }

    public int removeDuplicates(int[] nums) {
      int index = 1;
      for(int i = 1 ; i<nums.length;i++){
          if(nums[i]!=nums[i-1]){
              nums[index] = nums[i];
              index++;
          }
      }
        return index;
    }

    class Product of Array Except Self {
    public void leftToRight(int[] left,int []nums){
        int product = 1 ;
        for(int i = 0 ; i<left.length;i++){
            left[i]=product;
            product*=nums[i];
        }
    }
    public void RightToLeft(int[] right,int []nums){
        int product = 1 ;
        for(int i = right.length-1 ; i>=0;i--){
            right[i]=product;
            product*=nums[i];
        }
    }
    public int[] productExceptSelf(int[] nums) {
        
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        leftToRight(left,nums);
        RightToLeft(right,nums);
        for(int i = 0 ; i<nums.length;i++){
            nums[i] = left[i]*right[i];
        }
        return nums;
    }
}
class Jump Game II {
   public  int jump(int[] nums) {
      if(nums.length==1 ) return 0;
     int curr_end = nums[0];
     int farthest = nums[0];
     int jumps = 1;
     for(int i = 1 ; i<nums.length;i++){
         if(i==nums.length-1) return jumps;
         farthest = Math.max(farthest,i+nums[i]);
         if(i==curr_end){
             jumps++;
             curr_end = farthest;
         }
         
     }
       return 0;
     
   }
}
 public double FastmyPow(double x, int n) {
        if(n==0 || x==1) return 1;
        double oddPow = 1;
        long pow = n>0?n:-(long)n ;
        while(pow!=1){
            if(pow%2!=0){
                oddPow*=x;
            }
            x = x*x;
            pow = pow/2;
        }
        double ans = oddPow * x * 1.0;
        if(n<0){
            return (1/(ans));
        }
        return ans*1.0;
    }

    public int Fastfib(int N) {
        if(N==0) return 0;
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 0;
        for(int i = 0 ; i<N-1 ; i++){
            int aa = a * 1 + b * 1 ;
            int bb = a * 1 + b * 0 ;
            int cc = c * 1 + d * 1 ; 
            int dd = c * 1 + d * 0 ;
            a = aa ; b =bb ;  c = cc ; d =dd;
            
            
        }
        
        return b;
    }


    public int minFlips(String target) {
        int flips = 0;
        int currentState = '0';
        for(int i = 0 ; i < target.length() ; i ++) {
            if(target.charAt(i) != currentState){
                flips++;
                currentState = target.charAt(i);
            }
        }
        return flips;
    }

     public String optimalDivision(int[] nums) {
        if(nums.length==1) return nums[0]+"";
        if(nums.length==2) return nums[0]+"/"+nums[1];
       StringBuilder ans= new StringBuilder();
        for(int i = 0 ; i<nums.length;i++){
           if(i==0) ans.append(nums[i]+"/"+"(");
           else
               if(i==nums.length-1){
               ans.append(nums[i]+")");
           }   
            else{
                ans.append(nums[i]+"/");
            }
       }
        return ans+"";
        
    }
     public static void swap(int i , int j , int arr[]){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        
    }
    public static void segregate_zeroes_and_ones(int arr[]){
       int firstOneIdx = 0;
        int currentIdx = 0;
        
        while(currentIdx < arr.length){
            if(arr[currentIdx] == 0){
                swap(firstOneIdx,currentIdx,arr);
                firstOneIdx ++;
            }
            currentIdx ++;
        }
    }

    public void Segregate0ans1sand2s(int[] nums) {
        int firstOneIdx = 0;
        int lastUnknownIdx = nums.length-1;
        int currIdx = 0;

        while(currIdx <= lastUnknownIdx){
           if(nums[currIdx] == 0){
            swap(currIdx,firstOneIdx,nums);
            firstOneIdx++;
            currIdx++;
           }
           else if(nums[currIdx] == 1){
            currIdx++;
           }
           else {
              swap(currIdx,lastUnknownIdx,nums);
              lastUnknownIdx--;
           }
        }
  
     }
     
      public int minTotalDistance(int[][] grid) { //best meeting point https://www.lintcode.com/problem/best-meeting-point/description
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();
            for(int i = 0 ; i<grid.length;i++){
                for(int j = 0  ; j<grid[0].length;j++){
                    if(grid[i][j]==1){
                        x.add(i);
                    }
                }
            }
            for(int i = 0 ; i<grid[0].length;i++){
                for(int j = 0  ; j<grid.length;j++){
                    if(grid[j][i]==1){
                        y.add(i);
                    }
                }
            }
            int bmp = 0;
            int bmpXcoordinate = x.get(x.size()/2);
            int bmpYcoordinate = y.get(y.size()/2);
            
             for(int i = 0 ; i<grid.length;i++){
                for(int j = 0  ; j<grid[0].length;j++){
                    if(grid[i][j]==1){
                         int distance = Math.abs(bmpXcoordinate-i) + Math.abs(bmpYcoordinate-j);
                         bmp+=distance;
                    }
                }
            }
            return bmp;
            
    }

    
        public int maximumSwap(int num) {
         char arr[] = (num+"").toCharArray();
        int max = Integer.MIN_VALUE;
        int largeEle = 0;
        int smallEle = 0;
         for(int i = 1 ; i < arr.length;i++){
           
             if(arr[i-1]<arr[i]){
                
                 int j  = i;
                 while(j<arr.length){
                     if(arr[j]>=max){
                         max = arr[j];
                         largeEle = j;
                     }
                     j++;
                 }
                
                 break;
             }
         }
       for(int i = 0 ; i<arr.length;i++){
           if(arr[i]<max){
               smallEle = i;
               break;
           }
       }
        swap(arr,smallEle,largeEle);
        String s = new String(arr);
        return Integer.parseInt(s);
    }
    public int numRescueBoats(int[] arr, int limit) {
         int count = 0 ;
         int i = 0;
         int  j = arr.length-1;
        Arrays.sort(arr);
        
        while(i<=j){
            int sum = arr[i]+arr[j];
          
            if(sum<=limit){
                i++;
               }
            j--;
            count++;
        }
       
        return count;
    }
    public int  MajorityElement(int[] nums) {
        int freq = 1;
        int ele = nums[0];

         for(int i = 1 ; i < nums.length ; i ++){

            if(ele == nums[i]){
                freq ++;
            }
            else {
                freq --;
                if(freq == 0){
                    ele = nums[i];
                    freq = 1;
                }
            }
         }
         return ele;
    }
    
// majorityELement:-boyer moore
     public List<Integer> majorityElement(int[] nums) {
        if(nums.length==0) return new ArrayList<Integer>();
        int ele1 = nums[0];
         int count1 = 1;
         int ele2 = nums[0];
         int count2 = 0;
         for(int i = 1 ; i<nums.length;i++){
             if(ele1==nums[i]){
                 count1++;
             }
             else if(ele2 == nums[i]){
                 count2++;
             }
             else if(count1==0){
                 ele1 = nums[i];
                 count1 = 1;
             }
             else if(count2==0){
                 ele2 = nums[i];
                 count2 = 1;
             }
             else{
                 count1--;
                 count2--;
             }
             
         }
          count1 = 0;
          count2 = 0;
        List<Integer> ans = new ArrayList<>();
        
       for(int i = 0 ; i<nums.length;i++){
           if(nums[i]==ele1){
               count1++;
           }
            if(nums[i]==ele2){
               count2++;
           }
       }
        
        
        if(count1>nums.length/3){
            ans.add(ele1);
        }
        if(ele2 != ele1 && count2>nums.length/3){
            ans.add(ele2);
        }
        return ans;
    }
      public int maxChunksToSorted(int[] arr) { //Max Chunks To Make Sorted I
         int max = Integer.MIN_VALUE;
         int chunks = 0;
        for(int i = 0 ; i<arr.length;i++){
            max = Math.max(arr[i],max);
            if(i == max){
                chunks++;
       }
    }
        return chunks;
}
 public int maxChunksToSortedII(int[] arr) {   //Max Chunks To Make Sorted II
         int maxFromLeft[] = new int[arr.length];
         int minFromRight[] = new int[arr.length];
        int maxSoFar = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        int chunks=1;
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]>maxSoFar){
                maxSoFar = arr[i];
            }
            maxFromLeft[i] = maxSoFar;
        }
        for(int i = arr.length-1;i>=0 ; i--){
            if(arr[i]<minSoFar){
                minSoFar=arr[i];
            }
            minFromRight[i] = minSoFar;
        }
      
        for(int i = 0 ;i<arr.length-1;i++){
            if(maxFromLeft[i]<=minFromRight[i+1]){
                chunks++;
            }
        }
        return chunks;
        
    }



    public int numSubarrayBoundedMax(int[] arr, int min, int max) {
        int subarrays = 0;
        int validSubarraysTillNow = 0;
        int j=0;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]>=min && arr[i]<=max){
                validSubarraysTillNow = i-j+1;
                subarrays+=validSubarraysTillNow;
            }
            else if(arr[i]<min){
                subarrays+=validSubarraysTillNow;
            }
            else if(arr[i]>max){
                validSubarraysTillNow=0;
                j=i+1;
            }
        }
        return subarrays;
    }
      public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0  ;i <nums.length;i++){
            if(nums[i]>max1){
               max3 = max2;
                max2 = max1;  
                max1 = nums[i];
                 }
            else if(nums[i]>max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i]>max3){
                max3 = nums[i];
            }
            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i]<min2){
                min2 = nums[i];
            }
               
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
        
    }
    public int dominantIndex(int[] nums) {
          int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int idx = -1;
       
        for(int i = 0  ;i <nums.length;i++){
            if(nums[i]>max1){
             
                max2 = max1;  
                max1 = nums[i];
                idx = i;
                 }
            else if(nums[i]>max2){
              
                max2 = nums[i];
            }
            
        }
        
        return max1>=2*max2?idx:-1;
    }
     public void wiggleSort(int[] nums) {
    
    for(int i = 0 ; i<nums.length-1;i++){
        if(i%2==0){
          if(nums[i]>nums[i+1]){
              swap(i,i+1,nums);
          }  
        }
        else{
             if(nums[i]<nums[i+1]){
              swap(i,i+1,nums);
          }  
        }
    }

    public void wiggleSortII(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        int j = nums.length-1;
        int res[] = new int[nums.length];
        while(i < nums.length){
            res[i] = nums[j];
            i += 2;
            j --; 
        }
        i = 0;
        while(i < nums.length){
            res[i] = nums[j];
            i+=2;
            j--;
        }

        for(int k = 0 ; k < res.length ; k ++){
            nums[k] = res[k];
        }
    }
       public int findMaxConsecutiveOnes(int[] nums) {
          int lastOccurenceOfZero = -1;
          int length = 0;
          int j = 0;
          int maxLength = 0;
          for(int i = 0 ; i<nums.length;i++){
              if(nums[i]==0){
                  
                   j = lastOccurenceOfZero+1;
                   lastOccurenceOfZero = i;
              }
               length = i-j+1;
              
              maxLength = Math.max(maxLength,length);
          }
          return maxLength;
    }   
        
    }
       public int Max_Consecutive_Ones_III(int[] arr, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int j = 0;
        int length = 0;
        int maxlength = 0;
    
        for(int  i = 0 ; i<arr.length;i++){
            if(arr[i]==1){
                length = i-j+1;
            }
            else if(arr[i]==0 && k>0){
                length = i-j+1;
               
                q.addFirst(i);
                k--;
            }
            else {
                if(q.size()==0){
                    j=i+1;
                    length = 0;
                  
                }
                else{
                int FirstOccurenceofZero = q.removeLast();
                j = FirstOccurenceofZero+1;
                q.addFirst(i);
                length=i-j+1;
                }               
                
                
            }
            
           
            maxlength = Math.max(length,maxlength);
        
        }
        return maxlength;
    }
     public List<Integer> partitionLabels(String S) {
        int alphabets[] = new int[26]; 
        for(int i = 0 ; i<S.length();i++){
            char ch = S.charAt(i);
            alphabets[ch-'a'] = i;
        }
        List<Integer>ans = new ArrayList<>();
        int maximumEnd = 0;
        int j = 0;
        for(int i = 0 ; i<S.length();i++){
             char ch = S.charAt(i);
            maximumEnd = Math.max(maximumEnd,alphabets[ch-'a']);
             if(i==maximumEnd){
                
                 int length = i-j+1;
                 ans.add(length);
                 j=i+1;
                 
             }
        }
        return ans;
    }
      public static int Minimum_Platforms(int arr[],int dep[]){
    // sorting arrival and departure times and looking at my watch and seeing which event will happen first 
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 0;
        
        int i = 0;
        int j = 0;
        int worstCasePlatforms = 0;
        while( i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                platforms ++;
                i ++;
            }
            else {
                platforms --;
                j ++;
            }
            worstCasePlatforms = Math.max(worstCasePlatforms,platforms);
        }
        return worstCasePlatforms;
}
   public void reverse(int []num , int si , int ei){
        while(si<ei){
            int temp = num[si];
            num[si] = num[ei];
            num[ei] = temp;
            si++;
            ei--;
        }
        
        
    }
    
    public void rotate2Dmatrix(int[][] matrix) {
        int n  = matrix.length;
      for(int gap = 0 ; gap<matrix.length;gap++){
          for(int i = 0 , j = gap ; j<n ;i++, j++){
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
        
      }
    
    for(int i = 0 ; i<n;i++){
         reverse(matrix[i],0,matrix.length-1);
    }
}
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for(int i = 1 ; i<=(int)Math.pow(2*n,0.5);i++){
          
           if((n-i*(i-1)/2)%i==0){                            
                count++;
            }
          
        }
        return count;
    }
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE; 
        boolean isZeroEncounter = false;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]==0){
                prefix =1;
                isZeroEncounter=true;
                continue;
            } 
            prefix = prefix*nums[i];
            maxProduct = Math.max(maxProduct,prefix);
            
        }
         for(int i = nums.length-1 ; i>=0;i--){
            if(nums[i]==0){
                suffix =1;
                continue;
            } 
            suffix = suffix*nums[i];
            maxProduct = Math.max(maxProduct,suffix);
           
        }
        
        if(isZeroEncounter){
            return Math.max(0,maxProduct);
        }
        return maxProduct;
        
    }
    
      public int minDominoRotations(int[] A, int[] B) {
        int num1 = A[0];
        int num2 = B[0];
        int Cnum1A=0;
        int Cnum2A=0;
        int Cnum1B=0;
        int Cnum2B=0;
       
      
        for(int i = 0 ; i<A.length;i++){
          if(A[i]!=num1 && Cnum1A!=Integer.MAX_VALUE){
               if(B[i]==num1){
                   Cnum1A++;
              }
              else {
                  Cnum1A = Integer.MAX_VALUE;
                  
              }
          }
          if(A[i]!=num2 && Cnum2A!=Integer.MAX_VALUE){
               if(B[i]==num2){
                   Cnum2A++;
               }
              else {
                  Cnum2A = Integer.MAX_VALUE;
                  
              }
          }
            
       }
         for(int i = 0 ; i<B.length;i++){
          if(B[i]!=num1 && Cnum1B!=Integer.MAX_VALUE){
               if(A[i]==num1){
                   Cnum1B++;
              }
              else {
                  Cnum1B = Integer.MAX_VALUE;
                  
              }
          }
          if(B[i]!=num2){
               if(A[i]==num2 && Cnum2B!=Integer.MAX_VALUE){
                   Cnum2B++;
               }
              else {
                  Cnum2B = Integer.MAX_VALUE;
                  
              }
          }
            
        }
        
      int ans = Math.min(Math.min(Cnum1A,Cnum2A),Math.min(Cnum1B,Cnum2B)) ;
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
     
     static boolean isvowel(char x) 
    { 
        if (x == 'a' || x == 'e' || x == 'i' || 
                          x == 'o' || x == 'u' ||x == 'A' || x == 'E' || x == 'I' || 
                          x == 'O' || x == 'U' ) 
            return true;
        return false;
    }
    public String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
           
           while(i<arr.length && !isvowel(arr[i])){
              
               i++;
           }
           while(j>=0 && !isvowel(arr[j])){
                
               j--;
           }
           
           if(i>j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        String ans = new String(arr);
        return ans;
    }
   
    // leetcode 119
    public List<Integer> getRow(int row) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(row==0) return ans;
        ans.add(1);
        if(row==1) return ans;
        for(int i = 2 ; i<=row ;i++){
            List<Integer>fans = new ArrayList<>();
            fans.add(1);
            for(int j = ans.size()-1 ; j>0 ; j--){
                 fans.add(ans.get(j)+ans.get(j-1));
            }
            fans.add(1);
            
            ans = fans;
        }

        return ans;
    }
      public int partitionDisjoint(int[] nums) {
            // basic intuition is 
            // we check if current element is less than leftMax. If yes , we will add it to leftParition and consider ans till current idx as valid ans.
            // if it is greater than it is already part of rightIdx , so it will not contribute to my leftPartition thats why i am keeping 2 variables to track my max
            int leftMax = nums[0];
            int actualMax = nums[0];
            int ans = 0;
            for(int i = 0 ; i < nums.length ; i ++){
                if(nums[i] < leftMax){
                    ans = i + 1;
                    leftMax = actualMax;
                }
                actualMax = Math.max(actualMax,nums[i]);
            }
            return ans;
        }
    }
  public String multiply(String num1, String num2) {
        char[] str1  = num1.toCharArray();
        char[] str2  = num2.toCharArray();
        int i = str1.length-1;
        int j = str2.length-1;
        int[] ans = new int[str1.length+str2.length];
        
        while(i>=0){
            int d1 = str1[i]-'0';
           
            while(j>=0){ 
            int d2 = str2[j]-'0';
            int carry = ans[i+j+1];
          
            int product = ((d1*d2)+carry);
           
            ans[i+j+1]=product%10;
            ans[i+j]+= product/10; 
                 
             j--;   
                
            }
            
            i--;
            j=str2.length-1;
            
        }
        
        StringBuilder ret = new StringBuilder();
        j = 0;
        while(j<ans.length){ 
            if(ans[j]==0){
                j++;
            }                  //leading zeroes
            else break;
        }
        
        for(  i = j ; i<ans.length;i++){
            ret.append(ans[i]);
        }
        return ret.length()>0?ret+"":"0";
        
    }
      public int maxDistToClosest(int[] seats) {
        int j = 0;
        int max = Integer.MIN_VALUE;
        int distance = 0;
        boolean isFirstOne = false;
        for(int i = 0 ; i <seats.length;i++){
            distance = 0;
            if(seats[i]==1 && isFirstOne==false){
                distance = i;
                j=i;
                isFirstOne = true;
            }
            else if(seats[i]==1){
                 distance = i-j-1;
                 distance = distance%2==0?distance/2:(distance/2)+1;
                 j = i;
            }
          
            max = Math.max(max,distance);
        }
          distance = seats.length-j-1;
          max = Math.max(max,distance);
        return max;
        
    }   
     public boolean Global_and_Local_Inversions(int[] arr) {
        for(int i = 0 ; i<arr.length;i++){
            if(Math.abs(arr[i]-i)>=2){
                return false;
            }
        }
        return true;
     }

     public int[] smallestRange(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int a[], int b[]) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(nums.get(i).get(0), max);
            min = Math.min(nums.get(i).get(0), min);
            pq.add(new int[] { nums.get(i).get(0), 0, i });
        }
        int minLength = max - min;
        int si = min;
        int ei = max;
        while (pq.size() > 0) {
            int top[] = pq.remove();
            if (top[1] + 1 < nums.get(top[2]).size()) {
                int nextEle = nums.get(top[2]).get(top[1] + 1);
                pq.add(new int[] { nextEle, top[1] + 1, top[2] });
                max = Math.max(nextEle, max);
                min = pq.peek()[0];
                int length = max - min;
                if (length < minLength) {
                    minLength = length;
                    si = min;
                    ei = max;
                }
            } else {
                break; // if one list ends then break
            }
        }

        return new int[] { si, ei };
    }

       public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
      for(int i = 0 ; i<nums.length;i++){
          if(nums[i]<=0){
              nums[i] = nums.length+100;
          }
      }
      
      for(int i = 0 ; i<nums.length;i++){
               int idx = Math.abs(nums[i])-1;
             if(idx<nums.length && nums[idx]>0){

                 nums[idx] = nums[idx]*-1;
                
             }
      }
      
        int ans = -1;
       for(int i=0;i<nums.length;i++ ){
            if(nums[i]>0){
                ans = i+1;
                break;
             }
           
       }
        
        return ans<0?nums.length+1:ans;
        
    }
       public boolean isPalindrome(int si ,int ei , String str){
        while(si<=ei){
            if(str.charAt(si)==str.charAt(ei)){
                si++;
                ei--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
         int i = 0; 
         int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                if(isPalindrome(i+1,j,s)||isPalindrome(i,j-1,s)){
                    return true;
                }
                else{
                    return false;
                }
                
            }
        }
        return true;
    }
        class pair{
        int position;
        int speed;
        double time;
        
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==1 ) return 1;
        if(position.length==0 ) return 0;
            pair arr[] = new pair[position.length];
          for(int  i = 0 ; i <arr.length;i++){
              arr[i] = new pair();
              arr[i].position = position[i];
              arr[i].speed =    speed[i];
              arr[i].time =(double) (target-arr[i].position )/ arr[i].speed ;
              
          }
        Arrays.sort(arr,(pair p1, pair p2)->{
            return p1.position - p2.position;
        });
        int fleets = 1;
        double maxSoFarTime =  arr[arr.length-1].time;
        for(int i = arr.length-2 ;i>=0 ; i--){
           
            if(arr[i].time> maxSoFarTime){
                fleets++;
                maxSoFarTime =  arr[i].time;
            }
           
        }
        return fleets;
    }
    public int carFleet_btr(int target, int[] position, int[] speed) {
    
    if(position.length == 0)
        return 0;
    
    HashMap<Integer,Integer>map = new HashMap<>();
    for(int i=0;i<position.length;i++)
        map.put(position[i],speed[i]);
    
    Arrays.sort(position);
    
    float []time = new float[position.length];
    for(int i=0;i<time.length;i++)
        time[i] = (float)(target-position[i])/map.get(position[i]);
    
    int fleet = 1;
    float max_time = time[time.length-1];
    for(int i=time.length-2;i>=0;i--){
        if(time[i]>max_time){
            fleet++;
            max_time = time[i];
        }
    }
    
    return fleet;
}

}
  ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        
        int largerOnRight[] = new int[n];
        int smallerOnLeft[] = new int[n];
        int min = 0;
        int max = n-1;
        smallerOnLeft[0] = -1;
        largerOnRight[n-1]=-1;
        for(int i = 1; i <arr.size();i++){
            if(arr.get(i)<=arr.get(min)){
               min = i;
               smallerOnLeft[i] = -1;
                
            }
            else{
                smallerOnLeft[i] = min;
            }
            
        }
         for(int i = arr.size()-2; i>=0 ; i--){
            if(arr.get(i)>=arr.get(max)){
               max = i;
               largerOnRight[i] = -1;
                
            }
            else{
                largerOnRight[i] = max;
            }
            
        }
        for(int i = 0 ; i<n;i++){
            if(smallerOnLeft[i]!=-1 && largerOnRight[i]!=-1){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(arr.get(smallerOnLeft[i]));
                ans.add(arr.get(i));
                ans.add(arr.get( largerOnRight[i]));
                return ans;
            }
        }
        return new ArrayList<>();
    }
    //leetcode 135
     public int candy(int[] ratings) {
         int ans[] = new int[ratings.length];
        for(int i = 0 ; i<ratings.length;i++){
          if(i-1>=0){
              if(ratings[i-1]<ratings[i]){
                  ans[i]=ans[i-1];
              }
          }
            ans[i]++;
        }
        for(int i = ratings.length-2;i>=0;i--){
            if(i+1<ratings.length && ratings[i+1]<ratings[i] && ans[i]<=ans[i+1]){
                ans[i]=ans[i+1]+1;
            }
        }
        int ret = 0;
        for(int i = 0 ; i<ans.length;i++){
            ret+=ans[i];
        }
        return ret;
        
    }
    
    public int removeElementInPlace(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        
         int k = 0;
        for(int ele : nums){
            if(ele!=val){
                nums[k++] = ele;
            }
        }
        return k;
}
    public void moveZeroes(int[] nums) {
         int k = 0;
         for(int i = 0 ; i<nums.length;i++){
             if(nums[i]!=0){
                 swap(nums,i,k);
                 k++;
             }
         }
    }
        public int maxSumTwoNoOverlap(int[] arr, int l, int M) {
            return Math.max(maxSumTwoNoOverlap_(arr,l,M),maxSumTwoNoOverlap_(arr,M,l));
    
}
     public int maxSumTwoNoOverlap_(int arr[] , int l , int M){
           int ms = Integer.MIN_VALUE;;
             int ps[] = new int[arr.length];
              ps[0] = arr[0];
           for(int i = 1 ; i<arr.length ; i++){
                 ps[i] = arr[i] + ps[i-1];
           }
         int sMMax = 0;
          for(int i = 0 ; i<arr.length ; i++){
                     int sum1 = 0;
                     int sum2 = 0;
              
                   if(i-l>=0){
                        sum1 = ps[i] - ps[i-l]; 
                        sum2+=ps[i-l];
                  }
                 if(i-l-M >=0){
                      sum2-=ps[i-l-M];
                 }
              sMMax = Math.max(sMMax,sum2);
              ms = Math.max(ms,sMMax+sum1);
          }
        return ms;
        
               
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
         HashSet<List<Integer>>ans =  new HashSet<>();

           for(int i = 0 ; i<nums.length-1 ; i++){
               int j = i+1 ; 
               int k = nums.length -1 ;
                             while(j<k){
                    if(nums[j]+nums[k]+nums[i] > 0){
                        k--;
                    }
                   else if(nums[j]+nums[k]+nums[i] < 0){
                        j++;
                    }
                   else{
                       List<Integer>list = new ArrayList<>();
                       list.add(nums[j]);
                       list.add(nums[k]);
                       list.add(nums[i]);
                       
                       ans.add(list);
                       j++;
                       k--;
                   }
               }
           }
        List<List<Integer>>ret = new ArrayList<>(ans);
        return ret;
    }

   public int search(int[] arr, int target) {
         int i = 0 ; 
         int j = arr.length-1;
         while(i<=j){
              int mid = (i+j)/2; 
              if(arr[mid]==target){
                  return mid ; 
              }
             else
              if(arr[i]<arr[mid]){
                  
                   if(arr[i] == target){
                       return i ; 
                   }
                  else 
                   if(target>arr[i] && target<arr[mid]){
                        j = mid-1;
                   }
                   else{
                       i = mid + 1 ;
                   }
                  
              }
             else{
                 if(arr[j] == target){
                       return j ; 
                   }
                  else 
                   if(target>arr[mid] && target<arr[j]){
                        i = mid + 1;
                   }
                   else{
                       j = mid-1;
                   }
                 
             }
             
             
         }
        return -1;
        
    }
}
//  leetcode 567
class IsPermutationInanotherString {
    public boolean checkInclusion(String s1, String s2) {
           int n = s1.length() ; 
           int i = 0 ; 
           int j = i+n ; 
           int arr1[] = new int[26];
           int arr2[] = new int[26];
           if(s1.length() > s2.length()){
                return false;
           }
         for(int k  = 0 ; k < n ; k ++ ){
             char ch = s2.charAt(k) ; 
             arr2[ch-'a'] ++ ; 
         }
         for(int k  = 0 ; k < n ; k ++ ){
             char ch = s1.charAt(k) ; 
             arr1[ch-'a'] ++ ; 
         }
         while(j<s2.length() ){
              char chi = s2.charAt(i);
              char chj = s2.charAt(j);
             
              if(isSame(arr1,arr2 )){
                  return true;
              }
              arr2[chi-'a']--;
              arr2[chj-'a']++;
              i++; 
              j++;
            
         }
        return isSame(arr1,arr2);
           
         
    }
    
    public boolean isSame(int arr1 []  , int arr2[]){
         for(int i = 0 ; i< 26 ; i++){
             if(arr1[i]!=arr2[i]){
                 return false;
             }
         }
        return true;
    }

}



class CompressString {
   public int compress(char[] arr) {
      int i = 0;
      int j = 1;
      char curr = arr[0];
      int freq = 1;
      while (i < arr.length && j < arr.length) {
         if (arr[j] != curr) {
            char ncurr = arr[j];
            arr[i] = curr;

            String s = freq + "";
            int t = 0;
            if (freq != 1) {
               while (freq != 0) {
                  i++;
                  arr[i] = s.charAt(t);
                  t++;
                  freq = freq / 10;

               }
            }

            i++;
            curr = ncurr;
            freq = 1;

         } else {

            freq++;
         }
         j++;
      }

      arr[i] = curr;
      String s = freq + "";
      int t = 0;
      if (freq != 1) {
         while (freq != 0) {
            i++;
            arr[i] = s.charAt(t);
            t++;
            freq = freq / 10;

         }
      }

      i++;

      return i;
   }
}


 // leetcode 1551
    public int minOperationsToMakeArrayEqual(int n) {
           int mid = -1; 
          int sum = 0 ; 
         for(int  i = 0  ; i<n ; i++){
             sum += (2*i + 1);
          }
        mid = sum/n;
        int op = 0 ; 
        for(int i = 1 ; i<= mid  ; i+=2){
            op+= (mid-i);
        }
        return op;
    }
    class Solution {
    public int scheduleCourse(int[][] courses) {
         Arrays.sort(courses, (a,b) -> {
            return a[1] - b[1];
        });
          class pair {
               int duration ; 
               int end ; 
               pair(int duration , int end){
                   this.duration = duration ; 
                   this.end = end;
               }
          }
         PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b)->{
             return b-a;
         });
        int ans = 0 ;
        int maxans = 0 ;
        int time = 0;
        for(int i = 0 ; i<courses.length ; i++){
                
               if(time + courses[i][0] <= courses[i][1]){
                    time+=courses[i][0];
                    pq.add(courses[i][0]);
               }
               else if(pq.size() > 0 && pq.peek() > courses[i][0]){
                   
                  time = time +  courses[i][0] - pq.remove();
                   pq.add(courses[i][0]);
               }
          
        }
        
        return pq.size();
       
    }
}



public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int rec = 0; int lastPoint = -1;
        for(int point[] : points){
            if(point[0] > lastPoint){
               rec++;
               lastPoint = point[0] + w;
            }
        }
        return rec;
    }
