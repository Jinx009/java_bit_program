package learn8;

import org.junit.Test;

import junit.framework.TestCase;

public class JunitTest extends TestCase {
    public void test() {
        System.out.println("Test");
    }

    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void hello() {
        System.out.println("hello");
    }
}
