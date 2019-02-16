package recursion;

/**
 * Create by SunnyDay on 2019/02/14
 */
public class Sum {
    // 用户角度
    public static int sum(int[] arr){
        return sum(arr ,0);
    }
    /**
     * 计算arr[l到n-1]这个区间内所有数字和
     * @param arr 数组
     * @param l 索引区间
     *
     *          思路：不断缩短数组的大小
     * */
    private static int sum(int[] arr,int l){
        if (l==arr.length){ return 0; }
        int x = sum(arr,l+1);
        return arr[l]+x;
    }
}
