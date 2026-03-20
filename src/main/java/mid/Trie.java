package mid;

/**
 * 实现Trie（前缀树）
 */
public class Trie {
    private boolean isEnd;
    private Trie[] next;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Trie();
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));//true
        System.out.println(trie.search("app"));//false
        System.out.println(trie.startsWith("app"));//true
        trie.insert("app");
        System.out.println(trie.search("app"));//true
    }
}
