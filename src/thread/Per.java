package thread;

public class Per extends Thread {
    private Sam sam;

    public Per(Sam sam) {
        this.sam = sam;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sam.in();
        }
    }
}
