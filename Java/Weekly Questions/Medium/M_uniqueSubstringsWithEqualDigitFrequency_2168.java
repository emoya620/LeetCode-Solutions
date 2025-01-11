class Solution {
    // Time Complexity: O(n^2) | Space Complexity: O(n^2)
    public int equalDigitFrequency(String s) {
        TrieNode root = new TrieNode();
        int totalValidSubstrings = 0;

        for (int start = 0; start < s.length(); start++) {
            TrieNode currentNode = root;
            int[] digitFrequency = new int[10];
            int uniqueDigitsCount = 0;
            int maxDigitFrequency = 0;

            for (int end = start; end < s.length(); end++) {
                int currentDigit = s.charAt(end) - '0';

                if (digitFrequency[currentDigit]++ == 0) {
                    uniqueDigitsCount++;
                }
                maxDigitFrequency = Math.max(
                    maxDigitFrequency,
                    digitFrequency[currentDigit]
                );

                if (currentNode.children[currentDigit] == null) {
                    currentNode.children[currentDigit] = new TrieNode();
                }
                currentNode = currentNode.children[currentDigit];

                if (
                    uniqueDigitsCount * maxDigitFrequency == end - start + 1 &&
                    !currentNode.isVisited
                ) {
                    totalValidSubstrings++;
                    currentNode.isVisited = true;
                }
            }
        }
        return totalValidSubstrings;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[10];
        boolean isVisited;
    }
}
