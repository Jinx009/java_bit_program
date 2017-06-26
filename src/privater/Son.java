package privater;

public class Son extends Dad {
    private void print1() {
        System.out.println("222");
    }

    @Override
    public void print() {
        super.print();
    }

    public static void main(String[] args) {
        Son s = new Son();

        s.print1();
        s.print();
    }

}
