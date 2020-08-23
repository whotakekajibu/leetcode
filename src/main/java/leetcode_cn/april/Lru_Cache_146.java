package leetcode_cn.april;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/4/25 20:15
 **/
public class Lru_Cache_146 {

    public static void main(String[] args) {
        Lru_Cache_146 cache = new Lru_Cache_146(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private int capacity;
    private int count = 0;
    private Map<Integer, DLinkedNode> map;
    DLinkedNode head, tail;

    public Lru_Cache_146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new DLinkedNode();
        head.msg = "head";
        tail = new DLinkedNode();
        tail.msg = "tail";
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode pickNode = map.get(key);
        if (pickNode == null) {
            return -1;
        }

        moveToFirst(pickNode);
        return pickNode.val;
    }

    public void moveToFirst(DLinkedNode pickNode) {
        DLinkedNode pre = pickNode.pre;
        DLinkedNode next = pickNode.next;
        pre.next = next;
        next.pre = pre;

        pickNode.pre = head;
        pickNode.next = head.next;
        head.next.pre = pickNode;
        head.next = pickNode;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToFirst(node);
            return;
        }
        if (count == capacity) {
            DLinkedNode pre = tail.pre;
            if (pre == head) {
                return;
            }
            pre.pre.next = tail;
            tail.pre = pre.pre;
            map.remove(pre.key);
            pre = null;
            count--;
        }
        node = new DLinkedNode(key, value);
        map.put(key, node);

        node.next = head.next;
        head.next = node;
        node.pre = head;
        node.next.pre = node;

        count++;
    }

    class DLinkedNode {
        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int key;
        public int val;
        public String msg;
        public DLinkedNode pre;
        public DLinkedNode next;
    }
}
