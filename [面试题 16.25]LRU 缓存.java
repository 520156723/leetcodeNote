//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 74 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    HashMap<Integer, LRUNode> map;
    LRUNode head;
    LRUNode tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        LRUNode node = map.get(key);
        if(node == null)
            return -1;
        removeAndInsert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (head == null) {
            head = new LRUNode(key, value);
            tail = head;
            map.put(key, head);
            return;
        }
        LRUNode node = map.get(key);
        if (node != null) {
            node.value = value;
            removeAndInsert(node);
        }else {
            LRUNode newNode = new LRUNode(key, value);
            if (capacity == 1) {
                map.remove(tail.key);
                head = newNode;
                tail = newNode;
            }else {
                if (map.size() >= capacity) {
                    map.remove(tail.key);
                    tail = tail.pre;
                    tail.next = null;
                }
                newNode.next = head;
                head.pre = newNode;
                newNode.pre = null;
                head = newNode;
            }
            map.put(key, newNode);
        }
    }

    public void removeAndInsert(LRUNode node){
        if(node == head){
            return;
        } else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.next = head;
        head.pre = node;
        node.pre = null;
        head = node;
    }

    class LRUNode{
        int key;
        int value;
        LRUNode pre;
        LRUNode next;

        LRUNode(){ }
        LRUNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
