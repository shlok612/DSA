
class Solution {
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges)
            adj.get(e[1]).add(e[0]);

        int[] vis = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0 && !dfs(i, adj, vis, ans))
                return new int[0];
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean dfs(int u, ArrayList<ArrayList<Integer>> adj,
                int[] vis, ArrayList<Integer> ans) {
        vis[u] = 1; // currently in DFS path

        for (int v : adj.get(u)) {
            if (vis[v] == 1) return false; // cycle
            if (vis[v] == 0 && !dfs(v, adj, vis, ans))
                return false;
        }

        vis[u] = 2; // completely processed
        ans.add(u);
        return true;
    }
}
