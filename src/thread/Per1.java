package thread;

public class Per1 extends Thread {

    private Sam sam;

    public Per1(Sam sam) {
        this.sam = sam;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sam.su();
        }
    }
}
