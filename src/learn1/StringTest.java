package learn1;

public class StringTest {
    public static void main(String[] args) {
        String str = "ccc";

        String str1 = "ccc";

        boolean bo = (str.equals(str1));

        boolean b = (str == str1);

        String str2 = new String("aaa");

        String str3 = "aaa";

        boolean bo1 = (str2.equals(str3));

        boolean b1 = (str2 == str3);

        String str4 = new String("bbb");

        String str5 = new String("bbb");

        boolean bo2 = (str4.equals(str5));

        boolean b2 = (str4 == str5);

        System.out.println(b);

        System.out.println(b1);

        System.out.println(b2);

        System.out.println(bo + "-----");

        System.out.println(bo1 + "-----");

        System.out.println(bo2 + "-----");

        Object obj = new Object();

        Object obj1 = new Object();

        boolean ob = (obj == obj1);

        boolean ob1 = (obj.equals(obj1));

        boolean ob2 = (obj.equals(obj));

        System.out.println(ob + "///");

        System.out.println(ob1 + "///");

        System.out.println(ob2 + "///");

        Student student = new Student("zhangsan");

        Student student1 = new Student("zhangsan");

        boolean ob3 = (student.equals(student1, student));

        System.out.println(ob3 + "****");

        Teacher te = new Teacher("lisi");

        Teacher te1 = new Teacher("lisi");

        boolean ob4 = (te.equals(te1));

        System.out.println(ob4 + "---");

        Book book = new Book("java");

        Book book1 = new Book("java");

        boolean bb = (book.autor == book1.autor);

        boolean bb1 = (book.name == book1.name);

        boolean bb2 = (book.autor.equals(book1.autor));

        boolean bb3 = (book.name.equals(book1.name));

        System.out.println(bb);

        System.out.println(bb1);

        System.out.println(bb2);

        System.out.println(bb3);
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public boolean equals(Student student, Student student1) {
        if (student.name.equals(student1.name)) {
            return true;
        } else {
            return false;
        }
    }
}

class Teacher {
    String name;

    public Teacher(String name) {
        this.name = name;
    }
}

class Book {
    public static String name = "ring";

    String autor;

    public Book(String autor) {
        this.autor = autor;
    }
}
