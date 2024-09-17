class unionFindQuestions {
 
 public static class Edge {
		int v = 0;
		int w = 0;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static int N = 7;
    public static ArrayList < Edge > [] graph;
   

	public static void addEdge(ArrayList < Edge > [] gp, int u, int v, int w) {
		gp[u].add(new Edge(v, w));
		gp[v].add(new Edge(u, w));
	}

	public static void display(ArrayList < Edge > [] gp) {

		for (int i = 0; i < gp.length; i++) {
			System.out.print(i + "-> ");

			for (Edge e: gp[i]) {
				System.out.print("(" + e.v + ", " + e.w + "), ");
			}
			System.out.println();
        }
        
        System.out.println();
	}
 int par[];
 int setSize[];
 public static int findPar(int vtx) {
  if (par[vtx] == vtx)
   return vtx;
  return par[vtx] = findPar(par[vtx]);
 }

 public static void mergeSet(int p1, int p2) {
  if (setSize[p1] < setSize[p2]) {
   par[p1] = p2;
   setSize[p2] += setSize[p1];
  } else {
   par[p2] = p1;
   setSize[p1] += setSize[p2];
  }
 }

 public int[] findRedundantConnection(int[][] edges) {
  par = new int[edges.length + 1];
  setSize = new int[edges.length + 1];
  for (int i = 0; i < edges.length; i++) {
   par[i] = i;
   setSize[i] = 1;
  }

  for (int i = 0; i <= edges.length; i++) {
   int p1 = findPar(edges[i][0]);
   int p2 = findPar(edges[i][1]);

   if (p1 != p2) {
    mergeSet(p1, p2);

   } else {
    int arr[] = {
     edges[i][0],
     edges[i][1]
    };
    return arr;
   }



  }
  return new int[2];
 }

 public int findCircleNum(int[][] M) {
  int n = M.length;
  int m = M[0].length;
  par = new int[n];
  setSize = new int[n];
  for (int i = 0; i < n; i++) {
   par[i] = i;
   setSize[i] = 1;
  }
  int count = n;
  for (int i = 0; i < n; i++) {
   for (int j = 0; j < m; j++) {
    if (i != j && M[i][j] == 1) {
     int p1 = findPar(i);
     int p2 = findPar(j);
     if (p1 != p2) {
      mergeSet(p1, p2);
      count--;
     }
    }
   }
  }

  return count;
 }
 public static boolean isSimilar(String s1, String s2) {
  int count = 0;
  for (int i = 0; i < s1.length(); i++) {
   if (s1.charAt(i) != s2.charAt(i))
    count++;
   if (count > 2) {
    return false
   }
  }
  return true;
 }  
 public int numSimilarGroups(String[] A) {  //leetcode 839
  int n = A.length;

  par = new int[n + 1];
  setSize = new int[n + 1];
  for (int i = 0; i < n; i++) {
   par[i] = i;
   setSize[i] = 1;
  }
  int count = n;
  for (int i = 0; i < A.length; i++) {
   for (int j = i + 1; j < A.length; j++) {
    if (isSimilar(A[i], A[j])) {
     int p1 = findPar(i);
     int p2 = findPar(j);
     if (p1 != p2) {
      par[p2] = p1;
      count--;
     }
    }
   }
  }
  return count;
 }
}
string smallestEquivalentString(string A, string B, string S)
{ 
    int n =A.length();
 par = new int[26];
 setSize=new int[26];
 for(int i=0;i<26;i++){
     par[i] = i;
 }

 for(int i=0;i<A.length();i++){
     int p1 = findPar(A.charAt(i)-'a');
     int p2 = findPar(B.charAt(i)-'a');
     if(p1<p2 && p1!=p2){
         par[p2]=p1;
     }
     else if(p2<p1 && p1!=p2) {
         par[p1]=p2;
     }
 }
 String ans ="";
 for(int i=0;i<S.length();i++){
     int par = findParent(S.charAt(i)-'a');
     ans += (char)(par+'a');
 }



}

int numIslands(char[][] grid)
{    
    int n  = grid.length;
    int m = grid[0].length;
     par = new int[n*m];
     setSize = new int[n*m];

    int noOfOnces = 0;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
        {
            par[i*m+j]=i*m+j;
        
            if (grid[i][j] == '1')
                noOfOnces++;
        }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == '1')
            {
                if (j + 1 < m && grid[i][j + 1] == '1')
                {
                    int p1 = findPar(i * m + j);
                    int p2 = findPar(i * m + j + 1);
                    if (p1 != p2)
                    {
                        par[p1] = p2;
                        noOfOnces--;
                    }
                }

                if (i + 1 < n && grid[i + 1][j] == '1')
                {
                    int p1 = findPar(i * m + j);
                    int p2 = findPar((i + 1) * m + j);
                    if (p1 != p2)
                    {
                        par[p1] = p2;
                        noOfOnces--;
                    }
                }
            }
        }
    }

    return noOfOnces;
}

public static kruskalsAlgo(int [][]arr){
 ArrayList<Edge>[]KGraph= new ArrayList[N];
 par = new int[arr.length];
 setSize =new int[arr.length];
 for (int i = 0; i < arr.length; i++) {
	     	KGraph[i] = new ArrayList < Edge > ();
}
Arrays.sort(arr,(int a[], int b[])->{
 return a[2]-b[2];
});
for(int [] ar : arr){
    int p1 = findPar(ar[0]);
    int p2 = findPar(ar[1]);
    if(p1!=p2){
        par[p1]=p2;
        addEdge(KGraph,ar[0],ar[1],ar[2]);
    }

}

display(KGraph);

}
  public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
  ArrayList<Integer[]>Pipes = new ArrayList<>();
   for(int i=0 ;i<pipes.length ;i++){
        Pipes.add(pipes[i]);
   }
   for(int i=1;i<=wells.length;i++){
       int arr []= {0,i,wells[i-1]};
       Pipes.add(arr);
   }
Collections.sort(Pipes,(int []a ,int []b )->{
return a[2]-b[2];
});
int cost = 0 ;
for(int [] ar : Pipes){
    int p1 = findPar(ar[0]);
    int p2 = findPar(a[1]);
    if(p1!=p2){
        par[p1]=p2;
        cost+=ar[2];
    }
}
  
  return cost;
  }

public static int MrPresident(){
    
    
    Scanner s = new Scanner(new InputStreamReader(System.in));
   List<Integer[]>graph = new ArrayList<>();
     List<Integer[]>Ngraph = new ArrayList<>();
     long n,m,k;
    n=s.nextLong();
    m=s.nextLong();
    k=s.nextLong();
    while(m-- > 0 ){
       
       int u= s.nextInt();
       int v = s.nextInt();
       int w = s.nextInt();
       Integer ar []= {u,v,w};
       graph.add(ar);
    } 
    par=new int[graph.size()+1];
    int MstCost= 0;
    Collections.sort(graph,(Integer a[] , Integer []b )->{
        return a[2]-b[2];
    });
    for(int i=1 ;i<=n ; i++){
        par[i]=i;
    }
    for(Integer []ar : graph){
        int p1 = findPar(ar[0]);
        int p2 = findPar(ar[1]);
        if(p1!=p2){
            par[p1]=p2;
             Ngraph.add(ar);
             MstCost+=ar[2];
        }

    }
    int gcc=0;
    for(int i=1;i<=n;i++){
        if(par[i]==i){
        gcc++;

        }
    }
    if(gcc>1){
        return -1;
    }
   
    
     int superRoads=0;
    for(int i=Ngraph.size()-1;i>=0;i--){
      
      if(MstCost<=k)
      {
          break;
      }
      Integer arr[]=  Ngraph.get(i);
      MstCost=MstCost-arr[2]+1;
      superRoads++;
      

    }
     if(MstCost >k){
        return -1;
    }
    
     return superRoads;

}

 public int minMalwareSpread(int[][] graph, int[] initial) {
par = new int[graph.length];
for(int i=0;i<graph.length;i++){
    par[i]=i;
}        
for(int i=0;i<graph.length;i++){
for(int j=0;j<graph[0].length;j++){
    int p1 = findPar(i);
    int p2 = findPar(j);
    if( i!=j && graph[i][j]==1){
        par[p1]=p2;
    }
}
}
Arrays.sort(intitial )
int NoOfInfectedPerCountry[]=new int[graph.length];
for(int patient : initial){
      NoOfInfectedPerCountry[par[patient]]++;
}
int population[]=new int[graph.length];
for(int i=0;i<graph.length;i++){
    population[par[i]]++;
}
int ans = initial[0];
int maxPopulation=0;
for(int patient : initial){
    if(NoOfInfectedPerCountry[par[patient]]==1 && population[par[patient]]>maxPopulation){
        maxPopulation = population[par[patient]];
        ans = patient ;
    }
}
return patient;

}



lli dfs_JourneyToMoon(vector<vector<int>> &graph, int src, vector<bool> &vis)
{
    vis[src] = true;
    int count = 0;
    for (int e : graph[src])
        if (!vis[e])
            count += dfs_JourneyToMoon(graph, e, vis);

    return count + 1;
}

lli JourneyToMoon_UsingDFS()
{
    int n, p;
    cin >> n >> p;
    vector<vector<int>> graph(n, vector<int>());
    while (p-- > 0)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    vector<bool> vis(n, 0);
    vector<lli> countrySize;

    int WorldPopulation = n;
    lli ans = 0;

    for (int i = 0; i < n; i++)
        if (!vis[i])
            countrySize.push_back((dfs_JourneyToMoon(graph, i, vis)));

    for (int ele : countrySize)
    {
        ans += ele * (WorldPopulation - ele);
        WorldPopulation -= ele;
    }
    return ans;
}

lli JourneyToMoon_UnionFind()
{
    int n, p;
    cin >> n >> p;

    for (int i = 0; i < n; i++)
        par.push_back(i);
    while (p-- > 0)
    {
        int u, v;
        cin >> u >> v;

        int p1 = findPar(u);
        int p2 = findPar(v);

        par[p1] = min(p1, p2);
        par[p2] = min(p1, p2);
    }

    vector<lli> countrySize(n, 0);

    int WorldPopulation = n;
    for (int i = 0; i < n; i++)
        countrySize[findPar(i)]++;

    lli ans = 0;
    for (int i = 0; i < n; i++)
    {
        if (par[i] == i)
        {
            ans += countrySize[i] * (WorldPopulation - countrySize[i]);
            WorldPopulation -= countrySize[i];
        }
    }

    return ans;
}  