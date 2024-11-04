class Seive{
public  void printAllPrimes(int N){
     
    boolean primes[] = new boolean[N+1];
    Arrays.fill(primes,true);
    for(int i = 2 ; i * i <= N ; i ++){
       for(int j = i * i ;j <= N ; j += i){
         primes[j] = false;
       }
    }
    
    for(int i = 2 ; i < primes.length ; i ++){
      System.out.println(i + " " + primes[i]);
    }
    
    
  }
}

class Main

{    //segemented seieve
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.next());
		while(t-->0){
			int n = s.nextInt();
			int m = s.nextInt();
			boolean arr[] = new boolean[m+1];
            Arrays.fill(arr,true);
            ArrayList<Integer>primes = new ArrayList<>();
			for(int i = 2 ; i <=(int)Math.pow(m,0.5);i++){
				if(arr[i]==true){
                    primes.add(i);
					int j = 2;
					int k = i;
					while(k*j<=m){
                      
                        arr[k*j] = false;
                        j++;
					}
				}
			}
             boolean ans[] = new boolean[m-n+1];
      for(int i = 0; i<primes.size();i++){
         int loLim = (n/ primes.get(i))* primes.get(i);
         
         if(loLim  <  n ){
             loLim += primes.get(i);
         }
         if(loLim ==  primes.get(i)){
             loLim+= primes.get(i);
         }
        
         for(int j = loLim; j<=m;j+= primes.get(i)){
            ans[j-n] = true;
         }
         
      }
      
      for (int i = n; i<m; i++) 
            if (ans[i - n] == false) 
                System.out.println(i);
  
      System.out.println();
   
      
      }
     
    
    }
}




1 - 30




