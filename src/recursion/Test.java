package recursion;


/**
 * Create by SunnyDay on 2019/02/14
 */
public class Test {
    public static void main(String[] args) {
        // 测试
        int arr[] = {1, 2, 3,4};
        System.out.println(Sum(arr));


    }

    /**
     * int数组求和
     * @param arr 目标数组
     * */
    public static int Sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum+arr[i];
        }
        return sum;
    }
}
