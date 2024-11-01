 import java.util.*;
 class DirectedGraph {
     public static class Edge {
         int v;
         int w;

         Edge(int v, int w) {
             this.v = v;
             this.w = w;
         }
     }
     public static void display(ArrayList < Integer > [] gp) {
         for (int i = 0; i < gp.length; i++) {
             System.out.print(i + "--> ");
             for (int e: gp[i]) {
                 System.out.print(e + " ");
             }
             System.out.println();
         }
     }
     public static void addEdge(int u, int v) {
         graph[u].add(v);
     }
     public static ArrayList < Integer > ans =new ArrayList<>();
     public static void topologicalSort_(int src, boolean vis[]) {

         vis[src] = true;
         for (int e: graph[src]) {
             if (!vis[e]) {
                 topologicalSort_(e, vis);

             }

         }
         ans.add(src);
     }
     public static void topologicalSort() {
         ans = new ArrayList < > ();
         boolean vis[] = new boolean[N];
         for (int i = 0; i < graph.length; i++) {
             if (!vis[i])
                 topologicalSort_(i, vis);
         }
         Collections.reverse(ans);
         System.out.println(ans);
     }

     public static void KhansAlgo() {
         ArrayList < Integer > ans = new ArrayList < > ();
         int indegree[] = new int[N];
         for (int i = 0; i < N; i++) {
             for (int e: graph[i]) {
                 indegree[e]++;
             }
         }
         LinkedList < Integer > q = new LinkedList < > ();
         for (int i = 0; i < indegree.length; i++) {
             if (indegree[i] == 0) {
                 q.addLast(i);
             }
         }
         while (q.size() > 0) {
             int size = q.size();
             while (size-- > 0) {
                 int top = q.removeFirst();
                 ans.add(top);
                 for (int e: graph[top]) {
                     if (--indegree[e] == 0) {
                         q.addLast(e);
                     }
                 }
             }
         }
         if (ans.size() != N) {
             System.out.println("cycle");
             return;
         }
         System.out.println(ans);
     }
     public boolean CourseSchedule(int numCourses, int[][] prerequisites) {

         graph = new ArrayList[numCourses];
         for (int i = 0; i < prerequisites.length; i++) {

             addEdge(prerequisites[i][1], prerequisites[i][0]);

         }
         ArrayList < Integer > ans = new ArrayList < > ();
         int indegree[] = new int[N];
         for (int i = 0; i < N; i++) {
             for (int e: graph[i]) {
                 indegree[e]++;
             }
         }
         LinkedList < Integer > q = new LinkedList < > ();
         for (int i = 0; i < indegree.length; i++) {
             if (indegree[i] == 0) {
                 q.addLast(i);
             }
         }
         while (q.size() > 0) {
             int size = q.size();
             while (size-- > 0) {
                 int top = q.removeFirst();
                 ans.add(top);
                 for (int e: graph[top]) {
                     if (--indegree[e] == 0) {
                         q.addLast(e);
                     }
                 }
             }
         }
         if (ans.size() != N) {
             System.out.println("cycle");
             return false;
         }
         return true;

     }

     public static boolean topologicalSortCycle(int src, int vis[]) {

         if (vis[src] == 1) return true;

         if (vis[src] == 2) return false;

         vis[src] = 1;
         boolean ret = false;
         for (int e: graph[src]) {

             ret = ret || topologicalSortCycle(e, vis);



         }
         vis[src] = 2;
         ans.add(src);

         return ret;
     }
     public static void topologicalSortCycle_() {
         int vis[] = new int[graph.length];
         ans = new ArrayList < > ();
         boolean res = false;
         for (int i = 0; i < vis.length; i++) {
             if (vis[i] == 0) {
                 res = res || topologicalSortCycle(i, vis);
             }
         }
         if (res) {
             System.out.println("Cycle");
         } else {
             System.out.println(ans);
         }
     }
     public static void DFS_SCC(int src , boolean[]vis,ArrayList<Integer>asf,ArrayList<Integer>[] ngraph){
          vis[src]=true;
         for(int e : ngraph[src] )
         {
        
         if(!vis[e]){
             DFS_SCC(e,vis,asf,ngraph);
         }
         
         
         }
         asf.add(src);
     }
     // kosaraju algorithm
     public static void SCC(){
         boolean vis[] = new boolean[N];

         for(int i=0;i<vis.length;i++){
             if(!vis[i]){
                 topologicalSort_(i,vis);
             }
         }
           ArrayList<Integer>[] ngraph=new ArrayList[N];
            for(int i=0;i<N;i++)
           ngraph[i]=new ArrayList<>();

         for(int i=0;i<N;i++){
             for(int e : graph[i]){
                 ngraph[e].add(i);
             }
               

         }
       
         ArrayList<ArrayList < Integer>>fAns=new ArrayList<>();
         ArrayList<Integer>IAns;
         vis = new boolean[N];
         Collections.reverse(ans);
         for(int i=0;i<ans.size();i++){
             if(!vis[ans.get(i)])
             
             {  
                 IAns=new ArrayList<Integer>(); 
                  DFS_SCC(ans.get(i),vis,IAns,ngraph);
                  
                 fAns.add(IAns);

             }
            
         }
         
      System.out.println(fAns);

     }
     
       public int longestIncreasingPath(int[][] matrix) {
          
        if (matrix.length == 0 || matrix[0].length == 0)
        return 0;
           
            int n = matrix.length;
           int m =matrix[0].length;
        int  dirA[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        int indegree[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               for(int d=0;d<dirA.length;d++){
                   int r = i+ dirA[d][0];
                   int c = j+ dirA[d][1];
                   if(r>=0 && c>=0 && r<n&& c<m && matrix[r][c]>matrix[i][j]){
                      indegree[r][c]++;
                   }
               }
            }
        }
         int length=0;
        LinkedList<Integer>que = new LinkedList < > ();
        for(int i=0;i<indegree.length;i++){
            for(int j=0 ; j<indegree[0].length;j++){
                if(indegree[i][j]==0){
                    que.addLast(i*m+j);
                }
            }
        }
           
        while(que.size()!=0){
            int size = que.size();
            while(size-- > 0){
                int top = que.removeFirst();
                int i = top / m ;
                int j = top % m ;
                for(int d=0 ; d<dirA.length; d++){
                    int r = i + dirA[d][0];
                    int c = j + dirA[d][1];
                    if(r>=0 && c>=0 && r<n&& c<m  && matrix[r][c] > matrix[i][j] &&
                       --indegree[r][c] == 0 ){
                          que.addLast(r*m+c);
                    }
                }
            }
            length++;
        }
        return length;


    }


    public static int numBusesToDestination(int[][] routes, int S, int T) {
       if (routes.length == 0)
			return -1;
         HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();
         for(int i= 0 ; i<routes.length; i++){
             for(int route : routes[i]){
                 hm.putIfAbsent(route,new ArrayList<>());
                 hm.get(route).add(i);
             }
         }
         int buses = 0;
         HashSet<Integer> busStand = new HashSet < > ();
         boolean bus[]=new boolean[routes.length];
         LinkedList<Integer>que = new LinkedList < > ();
         que.addLast(S);
         busStand.add(S);
         while(que.size()>0){
             int size = que.size();
             while(size -- >0){
            int stand = que.removeFirst();
            if(stand==T){
                return buses;
            }
            for(int Bus : hm.get(stand) ){
               
                if(bus[Bus]){
                    continue;
                }
                bus[Bus]=true;
                for(int BUS_Stand : routes[Bus] ){
                    
                    if(!busStand.contains(BUS_Stand)){  // true mark krwa dia
                      busStand.add(BUS_Stand);
                      que.addLast(BUS_Stand);
                    }
                }

            }
             
             }
             buses++;
         }

         return -1;
          
        
         
    }
    public static void bellmanFord_2D(graph,int src , int dest){
        int dp [][] =new int[graph.length][graph.length+1];
        boolean isNegativeCycle;
         for(int j = 0 ;j <=k ;j++) {
       for(int i=0 ;i<n; i++){
            if(j==0){
               dp[i][j]=Integer.MAX_VALUE;
               if(i==src){
                   dp[i][j]=0;
               }
           }
       }
    }
        for(int j = 1 ;j<=dp.length ;j++){
          
               for(int i=0;i<n;i++) dp[i][j]=dp[i][j-1];
               for(int[] e : graph){
                   int  u =e[0] ,  v =e[1], w =e[2]
                    if(dp[u][j-1]==Integer.MAX_VALUE){
                    continue;
                }
               temp = dp[v][j]; 

                     dp[v][j] = Math.min(dp[v][j],dp[u][j-1]+w)  ;
                     if(j == graph.length && dp[v][j]!=temp){
                         isNegativeCycle=true;
                     }
               }
               
                 
            
        }

    }

    // void bellmanFord_1D(vector<vector<int>> &graph_, int src)
// {
//     int INF = 1e8;
//     int n = graph_.size();
//     vector<int> dp(n, INF);
//     dp[src] = 0;
//     bool isNegativeCycle = false;

//     for (int i = 1; i <= n; i++)
//     {
//         for (vector<int> &e : graph_)
//         {
//             int u = e[0], v = e[1], w = e[2];
//             if (dp[u] == INF)
//                 continue;
//             int temp = dp[v];
//             dp[v] = min(dp[v], dp[u] + w);
//             if (i == graph_.size() && dp[v] != temp)
//                 isNegativeCycle = true;
//         }
//     }
// }
    public static int find(e)

     public static int N = 6;
     public static ArrayList < Integer > [] graph;
     public static void main(String args[]) throws Exception {
         graph = new ArrayList[N];
         for (int i = 0; i < N; i++) {
             graph[i] = new ArrayList < Integer > ();
         }
         addEdge(0, 1);
         addEdge(1, 2);
         addEdge(2, 0);
         addEdge(2,3);
         addEdge(3,4);
         addEdge(4,5);
         addEdge(5,3);
       

        
      

         


     }
 }