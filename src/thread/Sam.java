package thread;

public class Sam {
    private int number;

    public static void main(String[] args) {

    }

    public synchronized void in() {
        if (0 != number) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number++;

        System.out.println(number);

        notify();
    }

    public synchronized void su() {
        if (0 == number) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number--;

        System.out.println(number);

        notify();
    }
}
