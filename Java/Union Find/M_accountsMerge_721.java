class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n){
        this.parent = new int[n];
        this.rank = new int[n];
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

    public boolean union(int x1, int x2){
        int p1 = find(x1), p2 = find(x2);
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
        return true;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);

                if (!map.containsKey(email)){
                    map.put(email, i);
                }
                else{
                    dsu.union(i, map.get(email));
                }
            }
        }

        HashMap<Integer, List<String>> merged = new HashMap<>();
        for (String email : map.keySet()){
            int group = map.get(email);
            int lead = dsu.find(group);

            if (!merged.containsKey(lead)){
                merged.put(lead, new ArrayList<>());
            }
            merged.get(lead).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int account : merged.keySet()){
            List<String> group = merged.get(account);
            Collections.sort(group);
            group.add(0, accounts.get(account).get(0));
            result.add(group);
        }
        return result;
    }
}
