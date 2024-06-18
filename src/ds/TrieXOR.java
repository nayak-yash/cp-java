package ds;

public class TrieXOR {
    private TrieNode root;

    public TrieXOR() {
        root = new TrieNode();
    }

    // Add a number to the Trie
    public void add(int num) {
        TrieNode current = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }
            current = current.children[bit];
            current.count++;
        }
    }

    // Delete a number from the Trie
    public void delete(int num) {
        TrieNode current = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            current = current.children[bit];
            current.count--;
        }
    }

    // Find the maximum XOR for a given number
    public int findMax(int num) {
        TrieNode current = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = bit ^ 1;
            if (current == null) break;
            if (current.children[oppositeBit] != null && current.children[oppositeBit].count > 0) {
                maxXor |= (1 << i);
                current = current.children[oppositeBit];
            } else {
                current = current.children[bit];
            }
        }
        return maxXor;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[2];
    int count;  // Keep track of the number of times this node is used to manage deletions.

    public TrieNode() {
        children[0] = null;
        children[1] = null;
        count = 0;
    }
}