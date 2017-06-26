package dec;

public class A extends Son {
    private Mum s;

    public A(Mum mum) {
        this.s = mum;
    }

    public void doSomething() {
        s.doSomething();
    }
}
