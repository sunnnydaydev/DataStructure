package unionfind;

/**
 * Create by SunnyDay on 2020/08/31
 * 第6版本的并查集：基于rank的基础上优化，压缩路径。
 * 相对基于5的优化更加减少树的深度。
 *
 * 代码改动：基于rank优化基础上修改find方法即可。采用宏观递归思想。递归性能
 * 相对5差些。
 */
public class UnionFind6 implements UF {

    private int[] parent;

    private int[] rank; //rank[i] 表示以i为根的集合，所表示树的层数。

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;// 初始时根节点就是自身，默认所有元素都处于不同集合，集合只有1个元素。树深度为1；
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

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;  // 将树深度少的添加到树深度多的上
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {//==时
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
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
        if (p != parent[p]) {
            parent[p] = find(parent[p]);// 路径压缩
        }
        return parent[p];
    }
}
