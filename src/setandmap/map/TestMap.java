package setandmap.map;

/**
 * Create by SunnyDay on 2019/03/07
 */
public class TestMap {
    public static void main(String[] args) {
        LinkedListMap<Integer,String> map = new LinkedListMap();
        System.out.println("map起始容量" + map.getSize());
        System.out.println(map.isEmpty());
        map.add(1, "tom");


        map.add(2, "kate");
        map.add(3, "john");
        map.add(1, "tom");
        map.add(1,"jerry");

        System.out.println("map isEmpty ? "+map.isEmpty());
        System.out.println("存元素个数"+map.getSize());
        System.out.println("含有键2？"+map.contains(2));

        System.out.println("map.get(1):"+map.get(1));
        map.set(3,"aaa");
        System.out.println("map.get(3)"+map.get(3));

        System.out.println("remove"+map.remove(2));


    }
}
