//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1209 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {//哈希表 + 双向链表
    int capacity;
    LRUNode head;//链表头
    LRUNode tail;//链表尾
    HashMap<Integer, LRUNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeAndInsert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (head == null) {//第一次加入元素，未初始化过head、tail
            head = new LRUNode(key, value);
            tail = head;
            map.put(key,head);
            return;
        }
        LRUNode node = map.get(key);
        if (node == null) {//没有则添加
            LRUNode newNode = new LRUNode(key, value);
            if(capacity == 1){//特殊情况
                map.remove(tail.key);
                head = newNode;
                tail = newNode;
            }else {
                if(map.size() == capacity){//溢出
                    map.remove(tail.key);
                    tail = tail.pre;
                    tail.next = null;
                }
                //头插
                newNode.next = head;
                head.pre = newNode;
                newNode.pre = null;
                head = newNode;
            }
            map.put(key, newNode);//map中也加入新结点
        }else {//有则修改
            node.value = value;
            removeAndInsert(node);
        }
    }

    public void removeAndInsert(LRUNode node){//删除该结点，并且插入头
        if (node == head) {
            return;
        }else if(node == tail){
            tail = tail.pre;
            tail.next = null;
        }else {//中间位置
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        //插入头
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }
}

class LRUNode{//双向链表
    int key;
    int value;
    LRUNode pre;
    LRUNode next;

    public LRUNode(){}
    public LRUNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
