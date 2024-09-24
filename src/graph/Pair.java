package graph;

public class Pair implements Comparable<Pair>{
    int u;
    int v;
    int w;
    Pair(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Pair o) {
        return w-o.w;
    }
}