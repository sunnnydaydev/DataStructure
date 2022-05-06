# HashTabble基础
###### 啥是哈希函数？
数组的查询、修改时间复杂度为O(1),若是物体的属性间存在映射关系，则可以借鉴数组的优势把“键”转化为数组的索引这就是哈希函数要做的事情。

###### 从生活中的“键”转化为索引引起的思考
假如一个班级有30名学生，学号为1-30。这时可以以学号减一作为数组的索引即可顺利存储30名学生的信息，这样的从“键”转化为索引的方式还是相对简单的。

不过大多数情况下我们处理的数据都比较复杂，如我们对居民的信息感兴趣，居民的唯一识别标识可能是身份证号（18位的数字）由于身份证的数字太大了超出了整数的范围我们不能直接使用这个数字作为数组的索引，实际上这也是一个很大的数字就算使用这个作为数组的索引那需要申请的空间极大，且17位及其以下的内存不使用都造成了极大的浪费。

更有甚者，某些唯一标识和数字都没有啥直接关系，最常见的就是字符串喽。还是以学生的信息为栗子，假如就以学生的姓名为“键”来标识学生的信息。这时这个“键”是一个字符串，此时<font color = red>如何设计一个哈希函数将字符串转化为数字？这就是设计哈希表时需要我们考虑的首个问题~

以学生学号为索引设计出的哈希函数得到的索引唯一，索引数字范围足够小非常方便使用数组做存储；但是更多的数据类型如字符串、日期、浮点数等我们很难的保证每一个“键”通过我们设计的哈希函数的转化对应不同的索引。也就是说两个不同的键通过我们设计的哈希函数转化后产生了相同的索引，我们称之为<font color =red>“哈希冲突”这也是我们设计哈希表时需要解决的第二个问题~

###### 时间与空间的思考
哈希表充分体现出了算法设计领域的经典思想：以空间换时间。上述身份证的栗子，假如我们能够申请18个9的这样的很大的空间，那么对用户的信息查询时间复杂度就是O(1)。在假设一种极端情况，我们只能申请1个数组空间，那么所有的数据转化为索引时都会产生哈希冲突，这时假如我们使用链表这种数据结构来存储数据那么查询也是个O(n)的时间复杂度。

上述就是两种极端的情况，一个是空间极大这时时间消耗很小，一个是空间很小占用时间比较大，而哈希表则是时间与空间的平衡~


# 哈希函数的设计
###### 哈希函数的设计遵循基准
- 一致性：如果a==b那么hash(a)==hash(b)
- 高效性：计算高效简便。
- 均匀性：获取的索引分布约均匀越好

###### 那么如何设计哈希函数呢？

这个要根据具体问题具体分析，因为哈希函数的设计在很多特殊的领域有很多特殊的做法。<font color = red>本文就以java int整数为索引设计哈希函数：

- 小范围正整数可直接做数组索引使用，小范围负整数可以考虑区间偏移，比如区间[-100,100]之间的数，可以把负数都映射到[100,200]中。

- <font color = red>大范围整数如Long类型，常见的做法是取模取余法。比如身份证号是一个18位的数，那么如何将其变为小点的int整数呢？这时可以取其后4位数字，以取模的方式即可得到后几位数字。不过通常取模一个素数，取模一个素数有利于解决索引的分布不均匀、更好利用大整数所有数字信息。这背后是由大量数学理论验证的我们可以不必深挖，但是可以以栗子验证其均匀性，哈希冲突概率小：

| 一组数字 | 非素数选4 | 素数选7 |
| :------: | :-------: | :-----: |
|    10    |     2     |    3    |
|    20    |     0     |    6    |
|    30    |     2     |    2    |
|    40    |     0     |    4    |
|    50    |     2     |    1    |

- 字符串如何进行哈希函数的设计呢？其实字符串也是可以看做大整形数字来处理的，每个字符都可看做数字，26个字母就可看成26进制数。如：

十进制100  可写为1 * 10^2^ + 0 * 10^1^  + 0 * 10^0^  

同理字符串也是类似如单词“code”可写为  c * 26^3^ +  o * 26^2^ +  d * 26^1^ +  e * 26^0^    c,o,d,e 用26进制定义好的对应数字即可。这时哈希函数就设计出来了：

hash（code） = （ c * 26^3^ +  o * 26^2^ +  d * 26^1^ +  e * 26^0^ ）% M  这里的M为一个素数。

###### Java中的HashCode

java中提供了一个hashCode方法，方便我们得到一个类的hash值。对于已有的类可直接通过hashCode方法获取。对于自定义类可重写hashCode方法获取。
```java
/**
 * Create by SunnyDay on 2022/05/06 17:55
 */
public class Student {
    private int age;
    private String name;
    private String sex;

    // 主要用于计算hash值
    @Override
    public int hashCode() {
        int M = 31;
        int hash = 0;
        hash = hash * M + age;
        hash = hash * M + name.hashCode();
        hash = hash * M + sex.hashCode();
        return hash;
    }
    // hash 冲突时可利用这个判断对象是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (obj.getClass() != this.getClass()) return false;

        Student another = (Student) obj;
        return this.age == another.age && 
                this.name.equals(another.name) && 
                this.sex.equals(another.sex);
    }
}
```

不过java的hashCode方法返回的值是一个32位int值，是一个有符号的整形数字，意味着这个值可能是一个负数。要把一个负数转化为一个数组中的索引这个工作需要我们在自己的哈希表中来完成。事实上java的hashCode的设计也是比较合理的，因为我们设计哈希表时通常需要模一个素数，这个素数通常是一个哈希表的大小。没有哈希表我们就得不到素数。因此在定义类时不能直接得到所以。这就是java hashCode的设计考虑。


# HashTab的实现
首先思考下如何设计HashTab，我们需要解决两个问题：

###### hash 函数的设计

这里可以通过java的hashCode方法得一个hash值，不过这个值可能为负数，需要我们手动处理，这时结合数组的容量即可设计出HashTab中的hash值。

- 首先通过java的hashCode方法得到一个hash值。
- 其次对hash值进行非负处理（java的hashCode方法返回一个整数可能为负）
- 最后对结果进行取模得到均匀分布的数值

###### hash冲突的解决

取模运算即使素数选择的再好也会有hash冲突的case，这时需要解决hash冲突，最常用的解决方案就是链表地址法。



![在这里插入图片描述](https://img-blog.csdnimg.cn/9c22d16557a84b4ea46fabadf11cde47.png)

###### 第一版：基础实现
HashMap中Java8之前每个位置对应的就是一个链表，但是Java8开始，当Hash冲突到达一定的程度后链表就会转化为红黑树。

链表地址法底层并不一定要我们写个链表节点亲自实现，由于TreeMap底层就是红黑树实现。所以嘛我们可以直接来用写一版~

```java
/**
 * Create by SunnyDay on 2022/05/06 14:23
 * custom hashTable base on TreeMap.
 */
public class MyHashTable<K, V> {
    private TreeMap<K, V>[] hashTable; //TreeMap base on red black tree.
    private int M;//capacity 
    private int size;

    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    /**
     * default constructor，default capacity is 97.
     */
    public MyHashTable() {
        this(97);
    }

    /**
     * calculate index
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    /**
     * add element.
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }

    }

    /**
     * delete element.
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V element = null;
        if (map.containsKey(key)) {
            element = map.remove(key);
            size--;
        }
        return element;
    }

    /**
     * Detect whether the target element exists.
     */
    public boolean containKey(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * query the target element.
     */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}
```
时间复杂度分析：总共M个地址，假如有N个元素则。

若是使用普通链表实现，每个地址是链表的平均时间复杂度 O(N/M)，最坏情况下时间复杂度 O(N)

不过上述使用TreeMap实现，每个地址是平衡树的平均时间复杂度为O(log(N/M) )，最坏情况下时间复杂度 O(logN)

###### 第二版：数组动态空间处理
前面说过HashTab的时间复杂度是O(1)级别的，这里看来时间复杂度与数组的元素个数存在关系的。可见M与N存在关系的，M是一个数组容量定值。当N趋近无穷大时，N/M的值也是趋近无穷的。时间复杂度是不可能趋近O(1) 的。不过我们可以对空间进行扩容来动态扩充。

由于链地址法的链表不存在容量满的说法，所以我们不能像ArrayList那样方式进行扩容，不过我们可以以这样一个标准：

- 平均每个地址承载大于一定程度时就扩容。如：N/M >= upperTol 时就扩容 （N：元素总数，M数组容量，upperTol容量上限）
- 平均每个地址承载小于一定程度时就缩容。如：N/M  <  lowerTol  时就缩容 （N：元素总数，M数组容量，lowerTol容量下限）

```java
/**
 * Create by SunnyDay on 2022/05/06 14:23
 * custom hashTable base on TreeMap.
 */
public class MyHashTable<K, V> {

    // about resize
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashTable; //TreeMap base on red black tree.
    private int M;
    private int size;

    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    /**
     * default constructor，default capacity is 97.
     */
    public MyHashTable() {
        this(initCapacity);
    }

    /**
     * calculate index
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    /**
     * add element.
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            //size就是N，与size/M >= upperTol 等价，这里改除法为乘法。
            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }

    }

    /**
     * delete element.
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V element = null;
        if (map.containsKey(key)) {
            element = map.remove(key);
            size--;
            // M / 2 >0 即可 。由于我们hashTab有初始容积则可写为M / 2 >= initCapacity
            if (size <= lowerTol * M && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }
        return element;
    }

    /**
     * Detect whether the target element exists.
     */
    public boolean containKey(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * query the target element.
     */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {
        // new array.
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++) {
            // TreeMap element in old  array.
            TreeMap<K, V> map = hashTable[i];

            // element put into newHashTable
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        // reset pointer
        this.hashTable = newHashTable;
    }
}
```

可见平均每个地址冲突的概率都在O(lowerTol)到O(upperTol) 之间。由于lowerTol、upperTol由我们控制，则平局时间复杂度可以控制在小数字内，时间复杂度趋近O(1)。


###### 第三版：数组动态空间优化
上述中扩容每次M*2得到的是一个偶数，这样就造成了索引分布不均匀的case，这里还是可以优化的：吧容量动态设置为素数。

```java

/**
 * Create by SunnyDay on 2022/05/06 14:23
 * custom hashTable base on TreeMap.
 */
public class MyHashTable<K, V> {

    // int 范围内素数
    private final int capacity[] = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843,
            50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    // about resize
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable; //TreeMap base on red black tree.
    private int M;
    private int size;

    public MyHashTable() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }


    /**
     * calculate index
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    /**
     * add element.
     */
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            // 避免越界
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }

    }

    /**
     * delete element.
     */
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V element = null;
        if (map.containsKey(key)) {
            element = map.remove(key);
            size--;

            if (size <= lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return element;
    }

    /**
     * Detect whether the target element exists.
     */
    public boolean containKey(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * query the target element.
     */
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {
        // new array.
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;

        for (int i = 0; i < oldM; i++) {
            // TreeMap element in old  array.
            TreeMap<K, V> map = hashTable[i];

            // element put into newHashTable
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        // reset pointer
        this.hashTable = newHashTable;
    }
}


```

# 小结
###### 收获
哈希表均摊时间复杂度O(1)
哈希表失去了元素的顺序性。

###### 其他Hash冲突的解决方案

开放地址法：牵涉到负载率的概念，负载率选取的好时间复杂度也是O(1)

- 线性探测法（每次+1）
- 平方探测法（每次+2平方）
- 二次哈希法

再哈希法：

Coalesced Hashing：结合链地址法和开放地址法。