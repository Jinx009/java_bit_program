package dec;

public class A2 extends A {
    public A2(Mum mum) {
        super(mum);
    }

    public void doSomething() {
        super.doSomething();

        this.doAnotherThing();
    }

    public void doAnotherThing() {
        System.out.println("A2");
    }
}
