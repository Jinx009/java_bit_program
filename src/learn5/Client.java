package learn5;

/*
 * 外部使用类：欲租房者
 */
public class Client {
    public static void main(String[] args) {
        ProxySubject sub = new ProxySubject();

        sub.request();
    }
}
