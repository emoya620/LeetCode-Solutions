class UnionFind {
    private HashMap<Integer, Integer> parent;
    private HashMap<Integer, Integer> rank;
    private int numComponents;

    public UnionFind(int n) {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
        this.numComponents = n;

        for (int i = 0; i < n; i++){
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int x) {
        if (x != parent.get(x)){
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public boolean isSameComponent(int x, int y) {
        return (find(x) == find(y));
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
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
            parent.put(p2, p1);
            rank.put(p1, rank.get(p1) + 1);
        }
        this.numComponents--;
        return true;
    }

    public int getNumComponents() {
        return this.numComponents;
    }
}
