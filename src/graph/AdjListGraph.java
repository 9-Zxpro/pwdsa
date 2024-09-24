package graph;

import java.util.LinkedList;

class AdjImplement{
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public AdjImplement(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int i = 0; i<V; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addNode(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices: ").append(V).append(", Edges: ").append(E).append("\n");
        for(int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for(int n : adj[v]) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
public class AdjListGraph {

    public static void main(String[] args) {
        AdjImplement adjList = new AdjImplement(7);
        adjList.addNode(1, 2);
        adjList.addNode(1, 5);
        adjList.addNode(2, 5);
        adjList.addNode(2, 4);
        adjList.addNode(2, 6);
        adjList.addNode(4, 5);
        adjList.addNode(5, 3);
        adjList.addNode(3, 6);
        
        System.out.println(adjList);
    }
}
