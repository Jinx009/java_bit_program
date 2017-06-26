package learn13;

public class Test1 {
    public static int com(int number) {
        int result = 1;

        for (; number > 0; number--) {
            result *= number;
        }
        return result;
    }

    public int com1(int number) {
        if (1 == number) {
            return 1;
        } else {
            return number * com1(number - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Test1.com(6));

        System.out.println("***********************");

        Test1 t = new Test1();

        System.out.println(t.com1(6));
    }
}
