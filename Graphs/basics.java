 class basics {
     public static class Edge {
         int v;
         int w;

         Edge(int v, int w) {
             this.v = v;
             this.w = w;
         }
     }
     public static void addEdge(ArrayList < Edge > [] gp, int u, int v, int w) {
         gp[u].add(new Edge(v, w));
         gp[v].add(new Edge(u, w));
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
         System.out.println();

     }
 }