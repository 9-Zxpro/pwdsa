package graph;


class Implement {
    private final int V;
    private int E;
    private final int [][]adjMatrix;

    Implement(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
        ++E;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices ").append(E).append(" Edges.\n");
        for(int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for(int e : adjMatrix[v]) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
public class Graph {
    public static void main(String[] args) {
        Implement g = new Implement(5);
        g.addEdge(1,2);
        g.addEdge(3,2);
        g.addEdge(4,2);
        g.addEdge(0,4);
        g.addEdge(0,3);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(3,4);

        System.out.println(g);
    }
}
