package trie;

import java.util.TreeMap;

/**
 * Create by SunnyDay on 2020/08/24
 */
public class Trip {

    private class Node {
        private boolean isWord;// 除了叶子节点，中间的节点也可能为单词的结尾。
        private TreeMap<Character, Node> next;// 当前节点的下一节点。

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

}
