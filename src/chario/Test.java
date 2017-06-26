package chario;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
    public static void main(String[] args) throws Exception {
        Person p = new Person("num1", "Medivh", 1);

        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");

        p.write(raf);

        Person p2 = new Person();

        raf.seek(0);

        p2.read(raf);

        System.out.println(p2.age + "   " + p2.id + "     " + p2.name);
    }
}

class Person {
    String name;
    int age;
    String id;

    public Person() {

    }

    public Person(String id, String name, int age) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public void write(RandomAccessFile raf) throws IOException {
        raf.write(age);
        raf.writeUTF(id);
        raf.writeUTF(name);
    }

    public void read(RandomAccessFile raf) throws IOException {
        this.age = raf.read();
        this.id = raf.readUTF();
        this.name = raf.readUTF();
    }
}
