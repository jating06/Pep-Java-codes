
    public int numRabbits(int[] arr) {
         HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            if(!hs.containsKey(arr[i])){
                hs.put(arr[i],1);
            }
            else{
                hs.put(arr[i],hs.get(arr[i])+1);
            }
        }
        int noOfRabits=0;;
        for(int groupSize:hs.keySet()){
             int groupCount = hs.get(groupSize);
             groupSize++;
             
             int numberOfGroupsReqd = (int)Math.ceil((double)groupCount/groupSize);
            
            noOfRabits+=(numberOfGroupsReqd*groupSize);
            
        }
        
        return noOfRabits;
    }
        // Subarray Sum Equals K

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        hs.put(0,1);
        int ps = 0;
        int noOfSubrrays=0;
        for(int i = 0 ; i<nums.length;i++){
            ps+=nums[i];
            if(hs.containsKey(ps-k)){
                noOfSubrrays+=hs.get(ps-k);
            }
            if(hs.containsKey(ps)){
                hs.put(ps,hs.get(ps)+1);
            }
            else{
                hs.put(ps,1);
            }
        }
        return noOfSubrrays;
    }

    //https://www.geeksforgeeks.org/problems/equal-0-1-and-23208/1
    public static int countSubarrWithEqualZeroAndOneAndTwo(String str){
         int pcZero = 0;
         int pcOne = 0;
         int pctwo = 0;
         HashMap<String,Integer>hs = new HashMap<>();
         hs.put("0*0",1);
         int subarrays = 0;
         for(int i = 0; i<str.length();i++){
             int no = str.charAt(i)-'0';
             if(no==1){
                 pcOne++;
             }
             else if(no==2){
                 pctwo++;
             }
             else{
                 pcZero++;
             }
             String s = (pcZero-pcOne)+"*"+(pcZero-pctwo); 
             if(hs.containsKey(s)){
               subarrays+= hs.get(s);
               hs.put(s,hs.get(s)+1);
             }
             else{
                 hs.put(s,1);
             }
         }
         return subarrays;
    }
   
     public static void chechAP(int arr[]){
        int min = Integer.MAX_VALUE;  
        int secondmin = Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i]<min){
                secondmin = min;
                min = arr[i];
            }
            else
            if(arr[i]<secondmin){
                secondmin = arr[i];
             }
        }
        int a = min; // an = a + (n-1) *d      a is min and d is (secondmin - min)
        int d = secondmin-min;
       
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i<arr.length;i++){
            hs.add(arr[i]);
        }
        while(hs.size()>0){
          if(!hs.contains(a)){
             System.out.println("NO");
             return;
          }
          hs.remove(a);
          a = a+d;
          
        }
       System.out.println("YES"); 
    }
        public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
         for(int i = 0  ; i<deck.length;i++){
              if(hm.containsKey(deck[i])){
                  hm.put(deck[i],hm.get(deck[i])+1);
              }
             else{
                 hm.put(deck[i],1);
             }
         }
       
        int val = 0;
        int gcd = -1;
        for(int keys : hm.keySet()){
           val = hm.get(keys);
            
            if(gcd==-1){
              gcd = val;
            }
             gcd  = gcd(val,gcd); 
            
            if(gcd<2){
              
                return false;
            }
            
        }
        return true;
    }


public boolean canReorderDoubled(int[] arr) {
    HashMap<Double,Integer> hm = new HashMap<>();
    double[] arr = Arrays.stream(nums).asDoubleStream().toArray();
    for(double no : arr){
        hm.put(no,hm.getOrDefault(no,0)+1);
    }
    Arrays.sort(arr);
    for(double no : arr){
        int freq = hm.get(no);

        if(freq > 0){
            if(no > 0){
               if(hm.containsKey(2*no) && hm.get(2*no) >= freq){
                  hm.put(2*no , hm.get(2*no) - freq );
                  hm.put(no,0);
               }
               else{
                   return false;
               }
            }
            else {
                if(hm.containsKey(no/2) && hm.get(no/2) >= freq){
                  hm.put(no/2 , hm.get(no/2) - freq );
                  hm.put(no,0);
               }
               else{
                   return false;
               }
            }
        }
    }
    return true;
    }
     public static void Morning_Assembly(int arr[]){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i<arr.length;i++){
            hm.put(arr[i],1);
        }
        int length=0;
        int maxLength = 0;
        for(int i = 0 ; i<arr.length;i++){
           
            int ele = arr[i];

            if(hm.containsKey(ele+1)){
              hm.put(ele+1,hm.get(ele)+1);
                
            }
           
            
             maxLength = Math.max(hm.get(ele),maxLength);
        }
      
        System.out.println(arr.length-maxLength);
    }
    
    public static void Rearrange_characters(String str){    //for k characters cant be same use queue
         class pair{
            char ch ;
            int freq ;
            pair(char ch , int freq){
                this.ch = ch;
                this.freq = freq;
            }
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0 ;i<str.length();i++){
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((pair a , pair b )->{
            return b.freq - a.freq;
            
        });
        for(char ch : hm.keySet()){
            pq.add(new pair(ch,hm.get(ch)));
        }
        StringBuilder ans = new StringBuilder();
        pair ignore = pq.remove ();
        ans.append(ignore.ch);
        
        while(pq.size()>0){
            pair top = pq.remove();
           
            ans.append(top.ch);
            ignore.freq--;
            if(ignore.freq!=0){
                 
                 pq.add(ignore); 
            }
            
            ignore = top;
            
            
            
            
        }
        
        if(ans.length()==str.length()){
            System.out.println("1");
        }
        else
        {
            System.out.println("0");
        }
    }


class FreqStack {
         int maxFreq = 0;
         HashMap<Integer,Stack<Integer>> freqStack = new HashMap<>();
         HashMap<Integer,Integer> hm = new HashMap<>();
    public FreqStack() {
        
    }
    
    public void push(int x) {
        hm.put(x,hm.getOrDefault(x,0)+1);
        int freq = 0;
        if(freqStack.containsKey(hm.get(x))){
             freq = hm.get(x);
            freqStack.get(freq).push(x);
        }
        else{
              freq = hm.get(x);
            freqStack.put(hm.get(x),new Stack<>());
            freqStack.get(freq).push(x);
            
        }
        maxFreq = Math.max(maxFreq,freq);
    }
    
    public int pop() {
        
        if(!freqStack.containsKey(maxFreq)){
            return -1;
        }

        int ret = -1;
       if(freqStack.get(maxFreq).size()>0){
            ret = freqStack.get(maxFreq).pop();
           if(hm.containsKey(ret)){
               hm.put(ret,hm.get(ret)-1); 
           }
           else{
               return -1;
           }
       }
       if(freqStack.get(maxFreq).size()==0){
         
           freqStack.remove(maxFreq);
             maxFreq--;
       }
        
        return ret;
    }
}
public static void largest_subarray_with_contiguous_elements_non_Repeated(int arr[]){ 
    int maxLength = 0;
    for(int  i  = 0 ; i<arr.length-1;i++){
        int min = arr[i];
        int max = arr[i];
        for(int j = i+1;j<arr.length;j++){
          if(j-i+1 == max-min+1){
              min = Math.min(min,arr[j]);
              max = Math.max(max,arr[j]);
              maxLength = Math.max(maxLength,j-i+1);
          }

        }
    }
    System.out.println(maxLength);
} 
public static void largest_subarray_with_contiguous_elements_Repeated(int arr[]){ 
    int maxLength = 0;
    for(int  i  = 0 ; i<arr.length-1;i++){
        int min = arr[i];
        int max = arr[i];
        HashSet<Integer>hs =new HashSet<Integer>();
        for(int j = i+1;j<arr.length;j++){
            if(hs.contains(arr[j])){
                break;
            }
            hs.add(arr[j]);
          if(j-i+1 == max-min+1){
              min = Math.min(min,arr[j]);
              max = Math.max(max,arr[j]);
              maxLength = Math.max(maxLength,j-i+1);
          }

        }
    }
    System.out.println(maxLength);
} 
public int[] maxSlidingWindow(int[] nums, int k) {
        int leftMax[] = new int[nums.length];
        int rightMax[]  = new int[nums.length];
        int ans[] = new int[nums.length-k+1];
        for(int i = 0 ; i <nums.length;i++){
            if(i%k==0){
                leftMax[i] = nums[i];
            }
            else{
                 leftMax[i] = Math.max(leftMax[i-1],nums[i]);
            }
        }
         for(int i = nums.length-1 ; i >=0;i--){
            if(i==nums.length-1){
                rightMax[i] = nums[i];
              
            }
             else
             if((i+1)%k==0){
                rightMax[i] = nums[i];
            }
            else{
                 rightMax[i] = Math.max(rightMax[i+1],nums[i]);
            }
        }
        for(int i = 0 ; i<ans.length;i++){
            ans[i] = Math.max(rightMax[i],leftMax[i+k-1]);
        }
        return ans;
    }
      public boolean isIsomorphic(String s, String t) {
          HashMap<Character,Character> hm = new HashMap<>();
          HashSet<Character> hs = new HashSet<>();
         if(s.length()!=t.length()) return false;
        for(int i = 0 ; i < s.length();i++){
         char ch1  = s.charAt(i);
         char ch2 =  t.charAt(i);
          if(hs.contains(ch2)){
                
              if(hm.containsKey(ch1)){
                    
                  if(hm.get(ch1)!=ch2){
                      
                  return false;
              }
             
          }
               else if(!hm.containsKey(ch1)){
                  return false;
                  
              }
         }
            else{
                if(hm.containsKey(ch1)){
                    return false;
                }
                else{
                    hm.put(ch1,ch2);
                    hs.add(ch2);
                }
            }
    }
       
        return true;
}
  public int trapRainWaterII(int[][] arr) {
        class pair{
            int height = 0;
            int coordinate = 0;
            pair(int height,int coordinate){
                this.height = height;
                this.coordinate = coordinate;
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((pair a , pair b)->{
            return a.height - b.height;
        });
        int n = arr.length;
        int m = arr[0].length;
        int visited[][] = new int[n][m];
        int dirA[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 1 ; i<n-1 ;i++){
            pq.add(new pair(arr[i][0],i*m));
            pq.add(new pair(arr[i][m-1],i*m + m-1));
            visited[i][0] = 1;
            visited[i][m-1]=1;
        }
        for(int i = 0 ; i<m; i++){
            pq.add(new pair(arr[0][i],i));
            pq.add(new pair(arr[n-1][i],(n-1)*m + i));
            visited[0][i] = 1;
            visited[n-1][i] = 1;
        }
       int totalWater = 0;
     
        while(pq.size()>0){
            pair top = pq.remove();
            
            int r = top.coordinate/m;
            int c = top.coordinate%m;
        
            for(int d = 0 ; d < 4;d++){
                int row = r+dirA[d][0];
                int col = c+dirA[d][1];
                if(row<n && col<m && row>=0 && col>=0 &&  visited[row][col]==0){
                    
                    int tower = arr[row][col];
                    
                     visited[row][col] = 1;
                    if(tower<top.height){
                        System.out.println(tower+" "+row+" "+col);
                        totalWater += (top.height-tower);
                        pq.add(new pair(top.height,row*m+col));
                         
                    }
                    else{
                        pq.add(new pair(arr[row][col],row*m+col));
                       
                    }
                }
                
            }
        }
        
       return totalWater;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue < Integer > pq = new PriorityQueue < > (Collections.reverseOrder());
        int totalfuel = startFuel;
        int n = stations.length;
        int stop = 0;
        for (int i = 0; i < n; i++) {
            int RefuelingPoint = stations[i][0];
            int petrol = stations[i][1];
            while (pq.size() > 0 && totalfuel < RefuelingPoint) {
                totalfuel += pq.remove();
                stop++;
            }
            pq.add(petrol);


            if (totalfuel < RefuelingPoint) {
                return -1;
            }
            if (totalfuel >= target) {
                return stop;
            }


        }

        while (pq.size() > 0 && totalfuel < target) {
            totalfuel += pq.remove();
            stop++;
        }

        if (totalfuel >= target) {
            return stop;
        }
        return -1;
    }
    
       public boolean isReflected(int[][] points) {   //Line Reflection on lintcode
          
          HashSet<String>hs= new HashSet<>();
          int rightBoundary = Integer.MIN_VALUE;
          int leftBoundary = Integer.MAX_VALUE ;
          
          for(int i = 0 ; i<points.length;i++){
              int x = points[i][0];
              int y = points[i][1];
            
              if(x>rightBoundary){
                  rightBoundary = x;
              }
               
                  if(x<leftBoundary){
                      leftBoundary = x;
                  }
              
              hs.add(x+"*"+y);
          }
          double mirror = (leftBoundary+rightBoundary)/(double)2;
          
         for(int i = 0 ; i<points.length; i++){
              
             String s = points[i][0]+"*"+points[i][1];
             String reflection = ((int)(2*mirror-points[i][0]))+"*"+points[i][1];
            
             
             if(hs.contains(s)){
                 if(hs.contains(reflection)){
                     hs.remove(s);
                     hs.remove(reflection);
                 }
                 else{
                     return false;
                 }
             }
         }
          
          return true;
    }
      public int bulbSwitch(int n) {
        int bulbs = 0;
        for(int i = 1 ; i<=(int)Math.pow(n,0.5);i++){
            if(i*i<=n){
                bulbs++;
            }
        }
        return bulbs;
        
    }
     public static void Pairs_Divisible_by_k(int arr[]){
        int k = 4;
        
        for(int i = 0 ; i <arr.length;i++){
            arr[i] = arr[i]%k;
            if(arr[i]<0){
                arr[i]+=k;
            }
        }
        int pair = 0;
      
        HashMap<Integer,Integer> hm = new HashMap<>();
         
        for(int i = 0 ; i < arr.length;i++){
           
            if(arr[i]==0){
                if(hm.containsKey(0)){
                    pair+=hm.get(0);
                    hm.put(0,hm.get(0)+1);
                }
                else{
                  hm.put(0,1);  
                }
                continue; 
            }
            else
            
            if(hm.containsKey(4-arr[i])){
                
                pair+=hm.get(4-arr[i]);
               
               
                
            }
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else{
                hm.put(arr[i],1);
            }
           
        }
     
        System.out.println(pair);
        
    }
    /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
    public  List<Interval> void EmployeeFreeTime(List<List<Interval>> arr){
        static class employee{
            int st ;
            int et ;
            int empno;
            int empSlot;
            employee(int st , int et , int empno , int empSlot){
                this.st = st;
                this.et = et;
                this.empno = empno;
                this.empSlot = empSlot;
            }
        }
        PriorityQueue<employee> pq = new PriorityQueue<>((employee a , employee b) ->{
            if(a.st == b.st) return a.et - b.et;
            return a.st-b.st;
        });
        for(int i = 0 ; i<arr.size() ; i++){
             Interval Interval = arr.get(i).get(0);
             int st = Interval.get(0);
             int et = Interval.get(1);
             int empno = i;
             int empSlot = 0;
             pq.add(new employee(st,et,empno,empSlot));

        }
        List<Interval> ans = new ArrayList<Interval>(); 
        int endTime = 0;
        while(pq.size() > 0){
            employee e = pq.remove();
            if(endTime == 0){
                endTime = e.et;
            }
            else if(e.st > endTime){
                   ans.add(new Interval(endTime,e.st));
            }
            if(e.empSlot+1<arr.get(empno).size()){
                 Interval Interval = arr.get(empno).get(e.empSlot+1);
                int st = Interval.get(0);
             int et = Interval.get(1);
             int empno = e.empno;
             int empSlot = e.empSlot+1;
                 pq.add(new employee(st,et,empno,empSlot));
            }
        }
        return ans; 
    }
    	public static void Pairs_of_Non_Coinciding_Points () {
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
        
		while(t-->0){
		     HashMap<Integer,Integer>x = new HashMap<>();
		     HashMap<Integer,Integer>y = new HashMap<>();
		      HashMap<String,Integer>point = new HashMap<>();
		      int n = s.nextInt();
		      int pairs = 0;
		      for(int i = 0 ; i<n;i++){
		          int xi  = s.nextInt();
		          int yi = s.nextInt();
		          if(x.containsKey(xi)){
		                pairs+= x.get(xi);
		              x.put(xi,x.get(xi)+1); 
		            
		          }
		          else{
		              x.put(xi,1);
		          }
		          
		          if(y.containsKey(yi)){
		                pairs+= y.get(yi);
		              y.put(yi,y.get(yi)+1); 
		          }
		          else{
		              y.put(yi,1);
		          }
		           if(point.containsKey(xi+"*"+yi)){
		              pairs -= point.get(xi+"*"+yi)*2;
		          }
		          else{
		              point.put(xi+"*"+yi,1);
		          }
		          
		      }
		      System.out.println(pairs);
		      
		}
	}
    	public static void Digit_multiplier () {
         Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
        
		while(t-->0){
        int n = s.nextInt();
        if(n==1){
            System.out.println("1");
            continue;
        }
        String ans = "";
        for(int i = 9 ; i>=2;i--){
            while(n%i==0){
                ans = i+ans;
                n=n/i;
        }
		    
		}
	
		if(ans.length()==0 || n!=1){
		    ans="-1";
		}
		System.out.println(ans);
	}
	}




     public static boolean Allsame(HashMap<Character,Integer>hs){
           int freq = 0;
           for(char ch : hs.keySet()){
               if(freq == 0){
                   freq = hs.get(ch);
               }
               else if(hs.get(ch)==0){
                   continue;
               }
               else if(freq!=hs.get(ch)){
                   return false;
               }
           }
           return true;
     }
    public static boolean Check_if_frequencies_can_be_equal(String s){
         HashMap<Character,Integer>hs =new HashMap<>();
		
		 for(int i  = 0 ; i<s.length();i++){
		     char ch = s.charAt(i);
		     hs.put(ch,hs.getOrDefault(ch,0)+1);
		 }
		 if(Allsame(hs)){
		     return true;
		 }
		  for(char ch : hs.keySet()){
		   hs.put(ch,hs.get(ch)-1);
		   if(Allsame(hs)){
		       return true;
		   }
		   else{
		       hs.put(ch,hs.get(ch)+1);
		   }
		      
		  }
		  return false;
  
		 
		 
    }
      public static void Simple_fraction(int num , int den){ // leetcode 166   //solved in gfg
         String BeforeFraction = "";
         String Decimal = "";
         int n = num/den;
         
         
         
         BeforeFraction+= n;
         HashMap<Integer,Integer> hs = new HashMap<>();
         num = num%den;
          
        int pos = 0;
         
        while(num!=0){
            num = num*10;
            if(hs.containsKey(num)){
                pos = hs.get(num);
                break;
            }
            else{
                hs.put(num,pos);
                Decimal+=(num/den);
                pos++;
                num = num%den;
            }
        }
        
    
         if(num!=0){
             String s1 = "."+Decimal.substring(0,pos);
             String s2 = Decimal.substring(pos);
            
            System.out.println(BeforeFraction+s1+"("+s2+")");
         }
        
         else
         if(num==0 && Decimal.length()>0){
            System.out.println(BeforeFraction+"."+Decimal);
         }
         else{
              System.out.println(BeforeFraction);
         }
         
    }
     public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer>hm1 =  new HashMap<>();
        HashMap<Character,Integer>hm2 =  new HashMap<>();
        for(int i = 0  ; i<p.length();i++){
            hm1.put(p.charAt(i),hm1.getOrDefault(p.charAt(i),0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        int j = 0;
        int i = 0;
        int MatchCount = 0 ;
        while(i<s.length() ){
            
            char ch = s.charAt(i);
           if(hm2.containsKey(ch)){
               hm2.put(ch,hm2.get(ch)+1);
               
           } 
           else{
               hm2.put(ch,1);
           }
            if(hm1.containsKey(ch)&&hm2.get(ch)<=hm1.get(ch)){
                  
                MatchCount++;
            }
             if(MatchCount==p.length()){
              
                    ans.add(j);
                }
        
            if(i-j+1==p.length()){
                
               
                char c = s.charAt(j);
                hm2.put(c,hm2.get(c)-1);
                if(hm1.containsKey(c) && hm2.get(c)<hm1.get(c)){
                   
                    MatchCount--;
                }
                j++;
            }
           i++;
         
       }
        
         return ans;
    }
     public String minWindow(String s, String p) {
        HashMap<Character,Integer>hm1 =  new HashMap<>();
        HashMap<Character,Integer>hm2 =  new HashMap<>();
        for(int i = 0  ; i<p.length();i++){
            hm1.put(p.charAt(i),hm1.getOrDefault(p.charAt(i),0)+1);
        }
        int i = 0;
        int j = 0 ;
        int minLength = Integer.MAX_VALUE;
        int matchCount = 0;
        int k = p.length();
        String ans = "";
        while(i<s.length()){
           
            char ch = s.charAt(i);
            if(hm2.containsKey(ch)){
                hm2.put(ch,hm2.get(ch)+1);
            }
            else{
                hm2.put(ch,1);
            }
            if(hm1.containsKey(ch)&& hm2.get(ch)<=hm1.get(ch)){
                matchCount++;
            }
             
            if(matchCount==k){
                 
                while(matchCount==k){
                    
                    String s1 = s.substring(j,i+1);
                  
                  
                    if(ans.length()==0){
                         ans = s1;
                    }
                    else if( s1.length()<ans.length()){
                        ans = s.substring(j,i+1);
                    }
                   
                 char c = s.charAt(j);
                   
                         hm2.put(c,hm2.get(c)-1);
                    
               
                if(hm1.containsKey(c) &&hm2.get(c)<hm1.get(c)){
                     
                    matchCount--;
                }
                j++;
                }
                
            }
            i++;
        }
        return ans;
    }
     public static void Smallest_subarray_with_all_occurrences_of_a_most_frequent_element(int arr[]){
        class pair{
            int si ;
            int ei ;
            int freq;
            pair(int si , int ei , int freq){
                this.si = si;
                this.ei = ei;
                this.freq = freq;
                
            }
        }
        int ansSI = 0;
        int ansEI = 0;
        HashMap<Integer,pair>hm =  new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        for(int i= 0 ; i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int si = hm.get(arr[i]).si;
                int freq =hm.get(arr[i]).freq+1;
                
                if(freq>=maxFreq){
                    if(freq == maxFreq){
                        
                    if(i-si+1<minLength){
                     ansSI = si;
                    ansEI = i;
                    minLength = i-si+1;
                    }
                    
                    }
                    else{
                      ansSI = si;
                    ansEI = i;  
                    minLength = i-si+1;
                    }
                    
                    maxFreq = freq;
                   
                }
               
                
                hm.put(arr[i],new pair(si,i,freq));
            }
            else{
                hm.put(arr[i],new pair(i,i,1));
            }
            
        }
        
        for(int i = ansSI; i<=ansEI;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
      boolean areKAnagrams(String s1, String s2, int k)
     {
       HashMap<Character,Integer> hm1 = new HashMap<>();
       HashMap<Character,Integer> hm2 = new HashMap<>();
       for(int i = 0 ; i<s1.length();i++){
           char ch = s1.charAt(i);
           hm1.put(ch,hm1.getOrDefault(ch,0)+1 );
       }
       int discrepency = 0;
       int i = 0;
       int j = 0;
       if(s1.length()!=s2.length() ){
           return false;
       }
       while(i<s2.length()){
           char ch = s2.charAt(i);
           hm2.put(ch,hm2.getOrDefault(ch,0)+1);
           if(!hm1.containsKey(ch)){
               discrepency++;
           }
           else if(hm1.containsKey(ch) && hm2.get(ch)>hm1.get(ch)){
               discrepency+=hm2.get(ch)-hm1.get(ch);
           }
           i++;
       }
      
       return discrepency<=k;
     }
     public static void length_of_longest_substring_without_repeating_characters(String str){
        int i = 0;
        int j = 0;
        boolean flag = false;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        while(i<str.length()  ){
            char ch = str.charAt(i);
            if(hm.containsKey(ch) ){
                flag = true;
                hm.put(ch,hm.get(ch)+1);
            }
            else{
                 hm.put(ch,1);
            }
           
            while(flag==true && j<i ){
                char c = str.charAt(j);
              
                  hm.put(c,hm.get(c)-1 );
                if(hm.get(c)==1){
                    flag = false;
                    j++;
                    break;
                    
                } 
                else if(hm.get(c)==0){
                    hm.remove(c);
                }
                
                  j++;
                
                
            }
            
          
                    int length = i-j+1;
                    
                    maxLength = Math.max(length,maxLength);
                
            
          i++;
            
        }
        System.out.println(maxLength);
    }
    class RandomizedSet {
      ArrayList<Integer> list = new ArrayList<>();
     HashMap<Integer,Integer> hs = new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    public void swap(int x , int y){
        int val1 = list.get(x);
        int val2 = list.get(y);
        list.set(x,val2);
        list.set(y,val1);
    }
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hs.containsKey(val)) return false;
        list.add(val);
        hs.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
            if(!hs.containsKey(val)) return false;
          int index = hs.get(val);
         hs.put(list.get(list.size()-1),index);
        
        swap(index,list.size()-1);
        hs.remove(val);
        list.remove(list.size()-1);
        return true;
        
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
         Random rand = new Random();
       int r = rand.nextInt(1000);
        return list.get(r%list.size());
         
    }
}
