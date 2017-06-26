package dec;

public class A1 extends A {
    public A1(Mum mum) {
        super(mum);
    }

    public void doSomething() {
        super.doSomething();

        this.doAnotherThing();
    }

    public void doAnotherThing() {
        System.out.println("A1");
    }
}
