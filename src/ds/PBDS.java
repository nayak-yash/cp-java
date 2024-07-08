package ds;

public class PBDS<K extends Comparable<K>, V> {
    private AVLTree<K, V> avlTree;

    public PBDS() {
        avlTree = new AVLTree<>();
    }

    // Insert a key-value pair into the PBDS
    public void insert(K key, V value) {
        avlTree.insert(key, value);
    }

    // Remove a key-value pair from the PBDS
    public void erase(K key) {
        avlTree.erase(key);
    }

    // Find the value associated with a given key
    public V find(K key) {
        return avlTree.find(key);
    }

    // Get the size of the PBDS
    public int size() {
        return avlTree.size();
    }

    // Check if the PBDS is empty
    public boolean isEmpty() {
        return avlTree.size() == 0;
    }

    // Get the key at a given index (0-based)
    public K getKeyAtIndex(int index) {
        return avlTree.getKeyAtIndex(index);
    }

    public int rank(K key) {
        return avlTree.rank(key);
    }
}

class AVLTree<K extends Comparable<K>, V> {
    public AVLTreeNode<K, V> root;

    public int size() {
        return size(root);
    }

    private int size(AVLTreeNode<K, V> node) {
        return node == null ? 0 : node.size;
    }

    public V find(K key) {
        return find(root, key);
    }

    private V find(AVLTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return find(node.left, key);
        } else if (cmp > 0) {
            return find(node.right, key);
        } else {
            return node.value;
        }
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private AVLTreeNode<K, V> insert(AVLTreeNode<K, V> node, K key, V value) {
        if (node == null) {
            return new AVLTreeNode<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }
        return balance(node);
    }

    public void erase(K key) {
        root = erase(root, key);
    }

    private AVLTreeNode<K, V> erase(AVLTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = erase(node.left, key);
        } else if (cmp > 0) {
            node.right = erase(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                AVLTreeNode<K, V> temp = minValueNode(node.right);
                node.key = temp.key;
                node.value = temp.value;
                node.right = erase(node.right, temp.key);
            }
        }
        if (node == null) {
            return null;
        }
        return balance(node);
    }

    private AVLTreeNode<K, V> minValueNode(AVLTreeNode<K, V> node) {
        AVLTreeNode<K, V> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private int height(AVLTreeNode<K, V> node) {
        return node == null ? 0 : node.height;
    }

    private int balanceFactor(AVLTreeNode<K, V> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLTreeNode<K, V> balance(AVLTreeNode<K, V> node) {
        if (balanceFactor(node) > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        } else if (balanceFactor(node) < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private AVLTreeNode<K, V> rotateRight(AVLTreeNode<K, V> y) {
        AVLTreeNode<K, V> x = y.left;
        AVLTreeNode<K, V> T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.size = size(y.left) + size(y.right) + 1;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private AVLTreeNode<K, V> rotateLeft(AVLTreeNode<K, V> x) {
        AVLTreeNode<K, V> y = x.right;
        AVLTreeNode<K, V> T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.size = size(x.left) + size(x.right) + 1;
        y.size = size(y.left) + size(y.right) + 1;
        return y;
    }

    public K getKeyAtIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getKeyAtIndex(root, index);
    }

    private K getKeyAtIndex(AVLTreeNode<K, V> node, int index) {
        int leftSize = size(node.left);
        if (index < leftSize) {
            return getKeyAtIndex(node.left, index);
        } else if (index > leftSize) {
            return getKeyAtIndex(node.right, index - leftSize - 1);
        } else {
            return node.key;
        }
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(AVLTreeNode<K, V> node, K key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            return 1 + size(node.left) + rank(node.right, key);
        } else {
            return size(node.left);
        }
    }

    public String toString() {
        var sb = new StringBuilder();
        printInOrder(root, sb);
        return sb.toString();
    }

    private void printInOrder(AVLTreeNode<K, V> node, StringBuilder sb) {
        if (node != null) {
            printInOrder(node.left, sb);
            sb.append(node.key).append(": ").append(node.value);
            printInOrder(node.right, sb);
        }
    }
}

class AVLTreeNode<K extends Comparable<K>, V> {
    K key;
    V value;
    AVLTreeNode<K, V> left, right;
    int height;
    int size;

    AVLTreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.height = 1;
        this.size = 1;
    }
}
