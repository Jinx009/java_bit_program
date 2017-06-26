package learn5;

public class ProxySubject extends AbstractSubject {
    private RealSubject subject;

    /*
     * 代理类：房产中介(帮租房者联系房主)
     * (non-Javadoc)
     * @see com.medivh.learn5.AbstractSubject#request()
     * 代理中可以调用真实要调用的request方法，同时还可以附加新的方法。真实需要操作的是RealSubject，却是在ProxySubject中执行。
     */
    public void request() {
        this.before();

        if (null == subject) {
            subject = new RealSubject();
        }

        subject.request();

        this.after();
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
