package unionfind;

/**
 * Create by SunnyDay on 2020/08/31
 * 第二版本的并查集：底层还是数组实现，但是采用树的思想。每个元素看成树的节点,孩子指向父亲。
 *
 * 查询，合并的时间复杂度o（h），h为树的深度。
 *
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        // // 初始化元素对应的集合，使每个元素所在集合都不同
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }


    /**
     * 并查集中元素个数
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 两元素是否有交集
     *
     * @param p 元素p
     * @param q 元素q
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p,q 合并
     *
     * @param p 元素p
     * @param q 元素q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    /**
     * 查询过程，查找元素p所对应的集合编号值。
     * 由子节点开始向上遍历，直到找到父节点。
     *
     * @param p 元素p
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index is illegal !");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
}
