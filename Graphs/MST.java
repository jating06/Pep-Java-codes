import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable < Pair > {
        int vtx;
        int nbr;
        int wt;

        public Pair(int vtx, int nbr, int wt) {
            this.vtx = vtx;
            this.nbr = nbr;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
  
    public static void primsAlgo(){   ///
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }



        PriorityQueue < Pair > pq = new PriorityQueue < > ();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[graph.length];
        while (pq.size() > 0) {
            Pair rp = pq.remove();
            if (visited[rp.vtx] == true) {
                continue;
            }
            visited[rp.vtx] = true;
            if (rp.nbr != -1)
                System.out.println("[" + rp.vtx + "-" + rp.nbr + "@" + rp.wt + "]");
            for (Edge e: graph[rp.vtx]) {
                int nbr = e.nbr;
                if (visited[nbr] == false) {
                    pq.add(new Pair(nbr, rp.vtx, e.wt));
                }
            }
        }

    }

class pair_
{
public:
    int src;
    int par;
    int w;
    int wsf;

    pair_(int src, int par, int w, int wsf)
    {
        this->src = src;
        this->par = par;
        this->w = w;
        this->wsf = wsf;
    }

    // bool operator<(pair_ &o)
    // {
    //     return this.wsf > o.wsf; // default min PQ.
    //     //   return o.wsf > this.wsf   // max PQ.
    // }
};

struct dijikstraComp
{
public:
    bool operator()(pair_ &p1, pair_ &p2)
    {
        return p1.wsf > p2.wsf; // default min PQ.
        //   return p2.wsf > p1.wsf   // max PQ.
    }
};



    public static void dijikstraAlgo(int src)
{
	ArrayList < Edge > [] dijikstraGraph=new ArrayList[N];
    for (int i = 0; i < N; i++) {
	    dijikstraGraph[i] = new ArrayList < Edge > ();
	}

    PriorityQueue<pair_> pq=new PriorityQueue<>((pair_ a,pair_ b)->{
		return a.wsf - b.wsf;  // default -> min PQ.  (this - other)
		// return b.wsf - a.wsf;  // max PQ.
	});

	boolean[] vis=new boolean[N];
	pq.add(new pair_(src,-1,0,0));

	while(pq.size()!=0){
		int size=pq.size();

		while(size-- > 0){
			pair_ rvtx = pq.poll();
			if(vis[rvtx.src]) continue;
			
			if(rvtx.par!=-1) addEdge(dijikstraGraph, rvtx.src, rvtx.par, rvtx.w);

			vis[rvtx.src]=true;
			for(Edge e: graph[rvtx.src]){
				if(!vis[e.v])
				   pq.add(new pair_(e.v, rvtx.src, e.w, rvtx.wsf + e.w));
			}
		}
	}

	display(dijikstraGraph);
}



}