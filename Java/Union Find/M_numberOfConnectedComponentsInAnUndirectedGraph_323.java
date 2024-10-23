class UnionFind {
    private int[] parent;
    private int[] rank;
    private int numComponents;

    public UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        this.numComponents = n;

        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1), p2 = find(n2);
        if (p1 == p2){
            return false;
        }

        if (rank[p1] < rank[p2]){
            parent[p1] = p2;
        }
        else if (rank[p1] > rank[p2]){
            parent[p2] = p1;
        }
        else{
            parent[p1] = p2;
            rank[p2]++;
        }
        this.numComponents--;
        return true;
    }

    public int getNumComponents(){
        return this.numComponents;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uFind = new UnionFind(n);

        for (int[] edge : edges){
            uFind.union(edge[0], edge[1]);
        }
        return uFind.getNumComponents(); 
    }
}
