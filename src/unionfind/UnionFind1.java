package unionfind;

/**
 * Create by SunnyDay on 2020/08/30
 */
public class UnionFind1 implements UF {

    private int id[];

    public UnionFind1(int size) {
        id = new int[size];
        // 初始化元素对应的集合，使每个元素所在集合都不同
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 并查集中元素个数
     */
    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 两元素是否有交集
     *
     * @param p
     * @param q
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * p,q 合并
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        // 遍历整个元素，使集合id，pid的都改为qid。
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    /**
     * @param p 元素p
     *          查找元素p所对应的集合编号
     *          <p>
     *          特点：查询特别快 时间复杂度o(1)
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("index is illegal !");
        }
        return id[p];
    }
}
