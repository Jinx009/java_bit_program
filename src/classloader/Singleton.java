package classloader;

public class Singleton {
    public static void main(String[] args) {
        S s = S.getInstance();

        System.out.println(s.count1);
        System.out.println("**********");
        System.out.println(s.count2);
        System.out.println("***********");
        System.out.println(s.count3);
    }
}

class S {
    private static S s = new S();

    public static int count1;
    public static int count2 = 0;
    public int count3;

//	private static S s = new S();

    public S() {
        count1++;
        count2++;
        count3++;
    }

    public static S getInstance() {
        return s;
    }
}
