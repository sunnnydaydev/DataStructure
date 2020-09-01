package unionfind;

/**
 * Create by SunnyDay on 2020/08/31
 * 第三版本的并查集：基于size的优化，减少树的深度。
 */
public class UnionFind3 implements UF {

    private int[] parent;

    private int[] sz; //sz[i] 表示以i为根的集合中元素的个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;// 初始时根节点就是自身，默认所有元素都处于不同集合，集合只有1个元素。
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

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;  // 将元素个数少的添加到元素个数多的上
            sz[qRoot] += pRoot;// 合并元素个数
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += qRoot;
        }

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
