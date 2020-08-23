package unionfind;

/**
 * @Description
 * @Date 2020/5/17 21:00
 **/
public class Redundant_connection_684 {
    public static void main(String[] args) {
        int[][] edges =  {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        for (int i : findRedundantConnection(edges)) {
            System.out.println(i);
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int k) {
            if (k != parent[k]) {
                parent[k] = find(parent[k]);
            }
            return parent[k];
        }

        public boolean union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            if (root1 == root2) {
                return false;
            }
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root1] = root2;
                rank[root1]++;
            }
            return true;
        }
    }
}
