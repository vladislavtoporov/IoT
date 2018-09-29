import java.util.*;

class MyGraph {
    private int n;
    private List<Integer>[] adj;

    public MyGraph(int n) {
        this.n = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void dfs(int v) {
        boolean[] visited = new boolean[n];
        dfs(v, visited);
    }

    public void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer n : adj[v]) {
            if (!visited[n])
                dfs(n, visited);
        }
    }

    public void bfs(int v) {
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (Integer n : adj[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        MyGraph graph = new MyGraph(4);


        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 0);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 1);

        graph.dfs(2);
        System.out.println();
        graph.bfs(2);
    }
}
