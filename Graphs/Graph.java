import java.util.*;

class Graph {

    public static class Edge {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void display(ArrayList < Edge > [] gp) {
        for (int i = 0; i < gp.length; i++) {
            System.out.print(i + "-->");
            for (Edge e: gp[i]) {
                System.out.print(" (" + e.v + "," + e.w + ") ");
            }
            System.out.println();
        }
    }

    public int shortestPathBinaryMatrix(int[][] graph) {
        int dirA[][] = { /*8 direction*/}
         
        int n = graph.length;
        int m = graph[0].length;
        if (n == 0)
            return -1;
        if (m == 0)
            return -1;

        if (graph[0][0] == 1 || graph[n - 1][m - 1] == 1)
            return -1;

        int level = 1;
        LinkedList < Integer > q = new LinkedList < > ();
        q.addLast(0);
        graph[0][0] = 1;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int top = q.removeFirst();
                int r = top / m;
                int c = top % m;
                if (r == n - 1 && c == m - 1) {
                    return level;
                }
                for (int i = 0; i < dirA.length; i++) {
                    int x = r + dirA[i][0];
                    int y = c + dirA[i][1];

                    if (x >= 0 && x < n && y >= 0 && y < m && graph[x][y] != 1) {
                        q.addLast(x * m + y);
                        graph[x][y] = 1;
                    }
                }
            }
            level++;


        }

        return -1;

    }

    public static void wallsAndGates(int[][] graph) {
        int dirA[][] = {//4directions};
        int n = graph.length;
        int m = graph[0].length;
        if (n == 0)
            return;
        if (m == 0)
            return;

        LinkedList < Integer > q = new LinkedList < > ();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (graph[i][j] == 0)
                    q.push((i * m + j));

        int level = 1;

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int top = q.removeFirst();
                int r = top / m;
                int c = top % m;

                for (int i = 0; i < dirA.length; i++) {
                    int x = r + dirA[i][0];
                    int y = c + dirA[i][1];

                    if (x >= 0 && x < n && y >= 0 && y < m && graph[x][y] == 2147483647) {
                        q.addLast(x * m + y);
                        graph[x][y] = level;
                    }
                }
            }
            level++;


        }


    }

    public int orangesRotting(int[][] graph) {

        int n = graph.length;
        int m = graph[0].length;
        if (n == 0 || m == 0)
            return -1;

        int dirA[][] = {
            {
                -1, 0
            },
            {
                0,
                -1
            },
            {
                0,
                1
            },
            {
                1,
                0
            }
        };


        LinkedList < Integer > q = new LinkedList < > ();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (graph[i][j] == 2)
                    q.addLast((i * m + j));

        int level = 0;

        while (q.size() > 0) {

            int size = q.size();
            while (size-- > 0) {
                int top = q.removeFirst();
                int r = top / m;
                int c = top % m;

                for (int i = 0; i < dirA.length; i++) {
                    int x = r + dirA[i][0];
                    int y = c + dirA[i][1];

                    if (x >= 0 && x < n && y >= 0 && y < m && graph[x][y] == 1) {
                        q.addLast(x * m + y);
                        graph[x][y] = 2;
                    }
                }
            }
            level++;


        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (graph[i][j] == 1)
                    return -1;


        if (level > 0) {
            return level - 1;
        }
        return level;
    }
    public int[][] 01Matrix(int[][] graph) {
         int dirA[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
              int n = graph.length;
        int m = graph[0].length;
        if (n == 0)
        return graph;
        if (m == 0)
        return graph;
          
     LinkedList<Integer> q=new LinkedList<>();
    
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (graph[i][j] == 0)
                q.push((i * m + j));
        
        
        
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (graph[i][j] == 1)
                graph[i][j]=2147483647;
 
 
         int level=1;
       
        while(q.size()>0){
            int size=q.size();
            while(size-- > 0){
                int top = q.removeFirst();
                int r = top/m;
                int c = top % m; 
                
                for(int i = 0 ; i < dirA.length ; i++  ){
                int x = r + dirA[i][0];
                int y = c + dirA[i][1];
                
                if(x >= 0 && x < n && y >= 0 && y < m  && graph[x][y]==2147483647){
                    q.addLast( x * m + y );
                    graph[x][y] = level;
                }
            }
            }
            level++; 
       

        }
        return graph;
    }


    public static class pair {
        int edge;
        String str;
        pair(int edge, String str) {
            this.edge = edge;
            this.str = str;
        }
    }
    public static void bfs(int src, boolean[] vis, int dest) {
        LinkedList < pair > q = new LinkedList < > ();
        q.addLast(new pair(src, src + " "));
        while (q.size() != 0) {
            pair p = q.removeFirst();
            if (vis[p.edge] == true) {
                System.out.println("cycle:" + p.str);
                continue;
            }
            if (p.edge == dest) {
                System.out.println("dest:" + p.str);
            }

            vis[p.edge] = true;
            for (Edge e: graph[p.edge]) {
                if (!vis[e.v]) {
                    q.addLast(new pair(e.v, p.str + e.v + " "));
                }

            }
        }
    }

    public static void bfs_02(int src, boolean[] vis, int dest) {
        LinkedList < Integer > q = new LinkedList < > ();
        int level = 0;
        int cycle = 0;
        q.addLast(src);

        while (q.size() != 0) {

            int size = q.size();

            while (size > 0) {
                size--;
                int top = q.removeFirst();
                if (vis[top]) {

                    cycle++;
                    System.out.println("cycle: " + top + " Cylce No: " + cycle);
                    continue;
                }
                if (top == dest) {
                    System.out.println(dest + "--->" + level);
                }

                vis[top] = true;

                for (Edge e: graph[top]) {
                    if (!vis[e.v])
                        q.addLast(e.v);



                }

            }
            level++;
        }

    }


    public static void bfs_03(int src, boolean[] vis, int dest) {
        LinkedList < Integer > q = new LinkedList < > ();
        int level = 0;
        int cycle = 0;
        q.addLast(src);
        vis[src] = true;
        while (q.size() != 0) {

            int size = q.size();

            while (size > 0) {
                size--;
                int top = q.removeFirst();

                if (top == dest) {
                    System.out.println(dest + "--->" + level);
                }



                for (Edge e: graph[top]) {
                    if (!vis[e.v]) {
                        vis[e.v] = true;
                        q.addLast(e.v);
                    }
                }

            }
            level++;
        }

    }
    public static class BpPair {
        int edge;
        int color;
        BpPair(int edge, int color) {
            this.edge = edge;
            this.color = color;
        }
    }

    public static boolean isBipartite_(int src, int[] vis) {
        LinkedList < BpPair > q = new LinkedList < > ();
        q.addLast(new BpPair(src, 0));

        while (q.size() != 0) {

            int size = q.size();

            while (size > 0) {

                size--;
                BpPair top = q.removeFirst();
                if (vis[top.edge] != -1) {

                    if (vis[top.edge] != top.color) {
                        return false;
                    }

                }


                vis[top.edge] = top.color;

                for (Edge e: graph[top.edge]) {
                    if (vis[e.v] == -1)
                        q.addLast(new BpPair(e.v, (top.color + 1) % 2));



                }

            }

        }
        return true;

    }

    public static void isBipartite() {
        int[] vis = new int[N];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            if (vis[i] == -1)
                System.out.println(isBipartite_(i, vis));
        }
    }
    public static void addEdge(ArrayList < Edge > [] gp, int u, int v, int w) {
        gp[u].add(new Edge(v, w));
        gp[v].add(new Edge(u, w));
    }

    public static int findEdge(int v1, int v2) {
        int vtx = -1;

        int i = 0;
        for (Edge e: graph[v1]) {
            if (e.v == v2) {
                vtx = i;
                break;
            }
            i++;
        }

        return vtx;
    }
    public static void allPath(boolean vis[], int src, int dest, int w, String ans) {
        if (src == dest) {
            System.out.println(ans + " " + "@" + w);
            return;
        }
        vis[src] = true;
        for (Edge e: graph[src]) {
            if (vis[e.v] == false) {
                allPath(vis, e.v, dest, w + e.w, ans + src + " ");

            }

        }
        vis[src] = false;

    }

    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);
        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int vtx) {
        while (graph[vtx].size() != 0) {
            Edge e = graph[vtx].get(graph[vtx].size() - 1);
            removeEdge(vtx, e.v);
        }
    }

    public static void preOrder(int src, boolean[] vis) {
        vis[src] = true;
        System.out.print(src + " ");
        for (Edge e: graph[src])
            if (!vis[e.v])
                preOrder(e.v, vis);

        vis[src] = false;
    }
    public static void hamintonianPath(int src, int osrc, boolean[] vis, int count, string ans) {

        if (count == vis.size() - 1) {
            int idx = findEdge(src, osrc);
            if (idx != -1)
                System.out.println("cycle: " + ans);
            else
                System.out.println("path: " + ans);
            return;
        }

        vis[src] = true;
        for (Edge e: graph[src]) {
            if (!vis[e.v]) {
                hamintonianPath(e.v, osrc, vis, count + 1, ans + to_string(src) + " ");
            }
        }

        vis[src] = false;
    }

    public static int GCC_dfs(int src, boolean[] vis) {
        vis[src] = true;
        int count = 0;

        for (Edge e: graph[src])
            if (!vis[e.v])
                count += GCC_dfs(e.v, vis);

        return count + 1;
    }

    public static int GCC() {
        boolean[] vis = new boolean[N];
        int count = 0;
        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                count++;
                maxSize = Math.max(maxSize, GCC_dfs(i, vis));
            }
        }
        System.out.println(maxSize);
        return count;
    }
    public static int low [] = new int[7];
    public static int dis [] = new int[7];
    public static int  AP []= new int[7];
    public static boolean vis [] = new boolean[7]; 
    public static int count = 0 ;
    public static int rootCalls=0;
    public static void APandBridgeshelper(int src , int par){
           low[src] = dis[src] = count++;
           vis[src]=true;
        for(Edge e : graph[src]){
          int child = e.v;
                 
          if(!vis[child]){
                     if(par==-1){
                         rootCalls++;
                     }
              APandBridgeshelper(child,src);
               if(dis[src] <= low[child] ){
                   
                 AP[src]++;                      //(low,disc)
                                                 //( milne ka tym,bhejne ka tym )
               }
               if(dis[src] < low[child]){
                   System.out.println("Bridge bw " + src + " " + child);
               }
               low[src]=Math.min(low[child],low[src]);
          }
          else if(child!=par){
              low[src]=Math.min(low[src],dis[child]);
          }
          
        }
    }
    public static void APandBridges(){
        int src = 0;
        APandBridgeshelper(0,-1);
        if(rootCalls==1){
            AP[src]--;
        }
        for(int i =0;i<AP.length;i++){
            if(AP[i]>0){
                System.out.println("Ap @ "+ i);
            }
        }
    }
    class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
          ArrayList<Integer>[]graph = new ArrayList[n];
        for(int i = 0 ; i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ;i<connections.size();i++ ){
            int u = connections.get(i).get(0);
             int v = connections.get(i).get(1);
            graph[u].add(v);
              graph[v].add(u);
        }
        low = new int[n];
        disc = new int[n];
        vis = new boolean[n];
        Ap = new int[n];
        dfs(0,-1,graph);
        if(rootCalls==1){
            Ap[0]--;
        }
        
       
       if(Ap[0]==0){
          for(int i = 0 ; i<list.size();i++){
              List<Integer>l = list.get(i);
              for(int j = 0 ; j<l.size();j++){
                  if(l.get(j)==0){
                      list.remove(i);
                  }
              }
              
          }
       }
        
    
        return list;
       
    }
     int low[];
     int disc[];
    boolean vis[];
    int countTime = 0;
    int rootCalls = 0;
    int Ap[];
    List<List<Integer>> list = new ArrayList<>();
        
    public  void dfs(int src , int par ,ArrayList<Integer>[]graph ){
         vis[src] = true;
        low[src]=disc[src] = countTime++;
        for(int e : graph[src]){
            if(!vis[e]){
                if(par==-1){
                    rootCalls++;
                }
                dfs(e,src,graph);
                if(disc[src]<low[e]){
                    Ap[src]++;
                    List<Integer> l = new ArrayList<>();
                    l.add(src);
                    l.add(e);
                    list.add(l);
                    
                }
                low[src]  = Math.min(low[src],low[e]);
            }
            else if(e!=par){
                low[src]  = Math.min(low[src],disc[e]);
                
            }
        }
    }
}


    public static int N = 7;
    public static ArrayList < Edge > [] graph;

    public static void main(String args[]) throws Exception {
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList < Edge > ();
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 3);
        addEdge(graph, 5, 6, 8);
         APandBridges();
    }
}