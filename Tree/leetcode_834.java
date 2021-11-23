class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
          ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count,1);
        n=N;
       for(int i = 0 ; i<N ; i++){
           graph.add(new ArrayList<>());
       }
        
         for(int edge[] : edges){
             graph.get(edge[0]).add(edge[1]);
             graph.get(edge[1]).add(edge[0]);
             
         }
         dfs1(graph  , new boolean[N] , 0 , 1 , 0);
         dfs2(graph,new boolean[N],0);
       
        return ans;
    }
    int ans[] ;
    int count[] ;
    int n ;
    public void dfs1(ArrayList<ArrayList<Integer>> graph  , boolean vis[] ,int start , int dis , int os){
         vis[start] = true;
         for(int e : graph.get(start)){
             if(!vis[e]){
                 
                 dfs1(graph,vis,e,dis+1,os);
                 ans[os]+=dis;
                 count[start]+=count[e]; 
             }
         }
         
    }
    public void dfs2(ArrayList<ArrayList<Integer>> graph , boolean vis[] , int par ){
        vis[par] = true;
         for(int child : graph.get(par)){
             if(!vis[child]){
                 
                 ans[child]  = ans[par] + (n-count[child]) - count[child];
                 dfs2(graph,vis,child);
                 
             }
         }
    }
}