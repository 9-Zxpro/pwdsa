package graph;

import java.util.*;


public class Dijkstra {


    static int[] dijkstra(int S, List<List<Pair>> graph, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(S, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().v;
            for (Pair p : graph.get(u)) {
                int v = p.v;
                int w = p.w;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();//No of vertices
        int E = sc.nextInt();//No of edges
        int S = sc.nextInt();//source
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            //vertices are 0 based indexing
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        int[] ans = dijkstra(S, graph, V);
        for(int x : ans) {
            System.out.print( x +" ");
        }
    }
}
// 9 14 0 //V E S
// 0 1 4 //u v w
// 0 7 8
// 1 2 8
// 1 7 11
// 2 3 7
// 2 8 2
// 2 5 4
// 3 4 9
// 3 5 14
// 4 5 10
// 5 6 2
// 6 7 1
// 6 8 6
// 7 8 7

