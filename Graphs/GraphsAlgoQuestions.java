class GraphsAlgoQuestions {
 public int networkDelayTime(int[][] times, int n, int k) {   // using dijkistras
  class pair {
   int src;
   int wsf;
   pair(int src, int wsf) {
    this.src = src;
    this.wsf = wsf;
   }
  }
  PriorityQueue < pair > pq = new PriorityQueue < > ((pair a, pair b) -> {
   return a.wsf - b.wsf;
  });

  int time = 0;
  int vis[] = new int[n + 1];
  for (int i = 0; i < vis.length; i++) {
   vis[i] = -1;
  }
  ArrayList < pair > [] graph = new ArrayList[n + 1];
  for (int i = 0; i <= n; i++) graph[i] = new ArrayList < pair > ();
  for (int i = 0; i < times.length; i++) {
   int u = times[i][0];
   int v = times[i][1];
   int w = times[i][2];
   graph[u].add(new pair(v, w));
  }

  pq.add(new pair(k, 0));

  while (pq.size() > 0) {
   int size = pq.size();
   while (size--> 0) {
    pair top = pq.remove();

    if (vis[top.src] != -1) {
     continue;
    }
    vis[top.src] = top.wsf;
    for (pair p: graph[top.src]) {

     if (vis[p.src] == -1) {


      pq.add(new pair(p.src, p.wsf + top.wsf));
     }
    }
   }

  }
  for (int i = 1; i <= n; i++) {
   if (vis[i] == -1) {
    return -1;
   }
   time = Math.max(time, vis[i]);
  }
  return time;
 }


        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { //using dijkistras

       class pair {
       int src;
       int wsf;
       int k;
       pair(int src, int wsf,int k) {
        this.src = src;
        this.wsf = wsf;
        this.k = k;
   }
  }
   k = k+1;
    boolean vis[] = new boolean[n];
   ArrayList < pair > [] graph = new ArrayList[n];
  for (int i = 0; i < n; i++) graph[i] = new ArrayList < pair > ();
  for (int i = 0; i < flights.length; i++) {
   int u = flights[i][0];
   int v = flights[i][1];
   int w = flights[i][2];
   graph[u].add(new pair(v, w,0));
  }
  

    
    PriorityQueue < pair > q = new PriorityQueue < > ((pair a, pair b) -> {
   return a.wsf - b.wsf;
  });
         q.add(new pair(src,0,k));

  while(q.size()>0){
      int size = q.size();
      while(size -- > 0){
          pair top = q.remove();
           
            if(top.k==0 && top.src!=dst){
                continue; 
            }
            if(top.k>=0 && top.src==dst){
                return top.wsf;
            }
          for(pair p : graph[top.src]){ 
                
                q.add(new pair(p.src,p.wsf+top.wsf,top.k-1));
          }

      }
      
  }
  return -1;
}

   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { 
       int INF = 100000000;
        k++;
   int dp[][] =new int[n][k+1];
  
    for(int j = 0 ;j<=k ;j++) {
       for(int i=0 ;i<n; i++){
            if(j==0){
               dp[i][j]=INF;
                 if(i==src ){
                   dp[i][j]=0;
               }
              
           }
           
       }
    }
   for(int j = 1 ;j<=k ;j++) {
       
       for(int i=0;i<n;i++) dp[i][j]=dp[i][j-1];
            for(int [] arr : flights){
                int u =arr[0], v = arr[1],w=arr[2];
               
                if(dp[u][j-1]==INF){
                    continue;
                }
                dp[v][j]=Math.min(dp[v][j],dp[u][j-1]+w); 
           }
   }
       for(int i=0;i<dp.length;i++){
           for(int j=0;j<dp[0].length;j++){
               System.out.print(dp[i][j]+" ");
           }
           System.out.println();
       }
      return dp[dst][k] == INF ? -1 : dp[dst][k];
   }


}