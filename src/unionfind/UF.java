package unionfind;

/**
 * Create by SunnyDay on 2020/08/30
 * 并查集通用接口设计 ，UF：并查集，是union find 的简写。
 */
public interface UF {
    /**
     * 并查集中元素个数
     */
    int getSize();

    /**
     * 两元素是否有交集
     */
    boolean isConnected(int p, int q);

    /**
     * p,q 合并
     * */
    void unionElements(int p,int q);
}
