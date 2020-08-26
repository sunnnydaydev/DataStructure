package trie;

import java.util.TreeMap;

/**
 * Create by SunnyDay on 2020/08/24
 * 默认设计为字符（Character）类型，这里不使用泛型。因为英文最为广泛。每个分隔单元就是一个字符
 */
public class Trip {

    /**
     * 节点的设计：每个单词的字母就是一个节点
     */
    private class Node {
        /**
         * 当前节点是否为单词的结尾。除了叶子节点，中间的节点也可能为单词的结尾。
         * 例如：panda，前三个pan 也是一个单词。
         */
        private boolean isWord;
        /**
         * 当前节点的下一节点。
         * 一般来说我们只考虑大写或者小写的话，设计一个trie时每个单词节点后面可能有26个节点，
         * 此时应该设计为  Node next[26]，但是这26个节点并不一定存在值，所以不用使用数组申请
         * 固定的空间。可以使用映射来申请。即：
         * TreeMap<Character, Node> next
         * 表示当前字符对应的下一节点。
         */
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trip() {
        root = new Node();
        size = 0;
    }

    /**
     * trie 中存储的单词数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 向trie 中添加单词
     *
     * @param word 要添加的单词字符串
     */
    public void add(String word) {
        Node current = root;//树、链表的遍历都要从头开始。所以创建头结点的副本。
        //遍历单词的每个字符，作为节点加入trie
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {// 当前字符对应的下节点未存储在trie中时，存入。
                current.next.put(c, new Node());
            }
            current = current.next.get(c);//节点往下遍历
            //最后一个单词时，标志结束。
            if (!current.isWord) {
                current.isWord = true;
            }

        }
    }
}
