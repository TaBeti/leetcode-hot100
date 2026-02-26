package mid;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 */
public class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity = 0;
    private Node dummy = new Node(0, 0);
    private Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    private int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    private void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);
        if (keyToNode.size() > capacity) {
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) return null;
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));//1
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));//-1
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));//-1
        System.out.println(lruCache.get(3));//3
        System.out.println(lruCache.get(4));//4
    }
}
