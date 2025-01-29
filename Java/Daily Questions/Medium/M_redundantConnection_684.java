class UnionFind {
    HashMap<Integer, Integer> parent;
    HashMap<Integer, Integer> rank;

    public UnionFind(int n){
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();        
        for (int i = 1; i <= n; i++){
            parent.put(i,i);
            rank.put(i,0);
        }
    }

    public int find(int x){
        if (x != parent.get(x)){
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1), p2 = find(n2);
        if (p1 == p2){
            return false;
        }

        if (rank.get(p1) < rank.get(p2)){
            parent.put(p1, p2);
        }
        else if (rank.get(p1) > rank.get(p2)){
            parent.put(p2, p1);
        }
        else{
            parent.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uFind = new UnionFind(n);

        for (int[] edge : edges){
            if (!uFind.union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[]{};
    }
}
