package learn9;

public class ExceptionTest1 {
    public void getHello() throws Exception {
        System.out.println("One");

        throw new Exception();
    }

    public static void getException(String mgs) throws Exception {
        if (mgs == "success") {
            throw new MyException("有异常！");
        } else {
            System.out.println("Exeption");
        }
    }

    public static void main(String[] args) throws Exception {
        ExceptionTest1 test = new ExceptionTest1();

        try {
            test.getHello();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("end");
        }

        ExceptionTest1.getException("success");
    }
}
