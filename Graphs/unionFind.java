class unionFind{
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
         graph[u].add(Edge(v,w));
         graph[v].add(Edge(u,w));
     }
     int par[]=new int[N];
     int setSize[]=new int[N];
     public static int findParent(int vtx){
         if(vtx==par[vtx]){
             return vtx;
         }
         return par[vtx]=find(par[vtx]);
     }
    
    public static void mergeSet(int l1, l2){
        if(setSize[l1]>setSize[l2]){
            par[l2]=l1;
            setSize[l1]+=setSize[l2]
        }
        else{
            par[l1]=l2;
            setSize[l2]+=setSize[l1]
        }
    }
    
    public static void main(String[] args){

    }
}