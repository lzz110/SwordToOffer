package HashAndSetClass;
import java.util.LinkedList;    // 导入链表类
/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/16 15:42
 */


// 定义一个简单的哈希表类
public class SimpleHashTable<K, V> {
    // 定义一个数组，用来存储键值对
    private LinkedList<Entry<K, V>>[] array;
    // 定义数组的长度
    private int capacity;

    // 定义一个构造方法，初始化数组和长度
    public SimpleHashTable(int capacity) {
        this.capacity = capacity;
        array = new LinkedList[capacity];
    }

    // 定义一个哈希函数，用来将键转换为索引
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // 定义一个键值对类，用来封装键和值
    private static class Entry<K, V> {
        // 定义键和值的属性
        private K key;
        private V value;

        // 定义一个构造方法，初始化键和值
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // 重写equals()方法，比较两个键值对是否相等
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) obj;
            return key.equals(entry.key);
        }

        // 重写hashCode()方法，计算键值对的哈希码
        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    // 定义一个插入方法，用来将键值对存储到数组中
    public void put(K key, V value) {
        // 计算键的索引
        int index = hash(key);
        // 检查数组中该索引是否已经有链表存在
        if (array[index] == null) {
            // 如果没有，则创建一个新的链表
            array[index] = new LinkedList<>();
        }
        // 遍历链表，查找是否已经有相同的键存在
        for (Entry<K, V> entry : array[index]) {
            // 如果有，则更新值，并返回
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        // 如果没有，则创建一个新的键值对，并插入到链表中
        array[index].add(new Entry<>(key, value));
    }

    // 定义一个查找方法，用来根据键查找值
    public V get(K key) {
        // 计算键的索引
        int index = hash(key);
        // 检查数组中该索引是否有链表存在
        if (array[index] == null) {
            // 如果没有，则返回null
            return null;
        }
        // 遍历链表，查找是否有相同的键存在
        for (Entry<K, V> entry : array[index]) {
            // 如果有，则返回值
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        // 如果没有，则返回null
        return null;
    }

}
