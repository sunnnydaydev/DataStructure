package hashtab;

/**
 * Create by SunnyDay on 2022/05/06 17:55
 */
public class Student {
    private int age;
    private String name;
    private String sex;

    @Override
    public int hashCode() {
        int M = 31;
        int hash = 0;
        hash = hash * M + age;
        hash = hash * M + name.hashCode();
        hash = hash * M + sex.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (obj.getClass() != this.getClass()) return false;

        Student another = (Student) obj;
        return this.age == another.age &&
                this.name.equals(another.name) &&
                this.sex.equals(another.sex);
    }
}
