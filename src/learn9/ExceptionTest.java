package learn9;

public class ExceptionTest {
    public static void main(String[] args) {
        int c = 0;

        try {
            int a = 3;

            int b = 0;

            c = a / b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("-----------------------");
            System.out.println(e);
            System.out.println("-----------------------");
            System.out.println(e.getLocalizedMessage());
            System.out.println("-----------------------");
            e.printStackTrace();
            System.out.println("-----------------------");
        } finally {
            System.out.println(c);
            System.out.println("-----------------------");
        }
        System.out.println(c);
    }
}
