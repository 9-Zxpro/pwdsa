package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DisjointSet {
    int[] parent;
    int[] size;
    DisjointSet(int nodes) {
        parent = new int[nodes+1];
        size = new int[nodes+1];
        for(int i = 0; i<=nodes; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findRep(int v) {
        if(parent[v] == v) return v;
        return parent[v] = findRep(parent[v]);
    }
    public void unionBySize(int v1, int v2) {
        int u = findRep(v1);
        int v = findRep(v2);
        if(u == v) return;
        if(size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        } else {
            parent[v] = u;
            size[u] += size[v];
        }

    }
}
public class KruskalAlgo {
    static BufferedReader br;
    static PrintWriter ot;
    static int spanningTree(int V, List<List<int[]>> adj) {
        List<Pair> l = new ArrayList<>();
        int mst = 0;
        for(int i = 0; i<V; i++) {
            for(int j = 0; j < adj.get(i).size(); j++){
                int v = adj.get(i).get(j)[0];
                int w = adj.get(i).get(j)[1];
                l.add(new Pair(i, v, w));
            }
        }

        Collections.sort(l);
        DisjointSet ds = new DisjointSet(l.size());
        for (Pair p : l) {
            if (ds.findRep(p.u) != ds.findRep(p.v)) {
                mst += p.w;
                ds.unionBySize(p.u, p.v);
            }
        }
        return mst;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t--> 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(KruskalAlgo.spanningTree(V, list));
        }
        ot.close();
    }
}

//To provide inputs use the below format
//        1     --t
//        3 3   --V E
//        0 1 5 --u v w
//        1 2 3
//        0 2 1