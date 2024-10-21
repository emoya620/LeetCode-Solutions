class TrieNode {
    HashMap<Character, TrieNode> children;
    String word;

    public TrieNode() {
        this.children = new HashMap<>();
        this.word = null;
    }
}

class Solution {
    char[][] curBoard;
    ArrayList<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode cur = root;
            for (char c : word.toCharArray()){
                if (!cur.children.containsKey(c)){
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }

        this.curBoard = board;
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (root.children.containsKey(board[r][c])){
                    backtracking(r, c, root);
                }
            }
        }
        return this.result;
    }

    public void backtracking(int r, int c, TrieNode parent){
        char curChar = this.curBoard[r][c];
        TrieNode cur = parent.children.get(curChar);

        if (cur.word != null){
            this.result.add(cur.word);
            cur.word = null;
        }

        this.curBoard[r][c] = '0';
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for (int i = 0; i < 4; i++){
            int newRow = r + dirs[i][0];
            int newCol = c + dirs[i][1];

            if (Math.min(newRow, newCol) < 0 || newRow >= this.curBoard.length || newCol >= this.curBoard[0].length){
                continue;
            }
            if (cur.children.containsKey(this.curBoard[newRow][newCol])){
                backtracking(newRow, newCol, cur);
            }
        }
        this.curBoard[r][c] = curChar;
        
        if (cur.children.isEmpty()){
            parent.children.remove(curChar);
        }
    }
}
