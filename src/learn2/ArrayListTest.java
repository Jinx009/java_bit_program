package learn2;

public class ArrayListTest {
    public static void main(String[] args) {
        int[] a = new int[4];

        System.out.println(a[0]);

        boolean[] b = new boolean[3];

        System.out.println(b[0]);

        Student[] s = new Student[4];

        for (int i = 0; i < s.length; i++) {
            s[i] = new Student();

            if (i % 2 == 0) {
                s[i].name = "lisi";
            } else {
                s[i].name = "zhangsan";
            }
        }
        for (int j = 0; j < s.length; j++) {
            System.out.println(s[j].name);
        }
    }
}

class Student {
    String name;
}
