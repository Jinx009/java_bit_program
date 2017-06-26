package learn12;

import java.util.Observable;
import java.util.Observer;

public class TwoObservers {
    public static void main(String[] args) {
        BeingWatched b = new BeingWatched();

        Watcher01 w1 = new Watcher01();

        Watcher02 w2 = new Watcher02();

        b.addObserver(w1);
        b.addObserver(w2);

        b.count(9);

    }
}

class BeingWatched extends Observable {
    void count(int number) {
        for (; number >= 0; number--) {
            this.setChanged();

            this.notifyObservers(number);
        }
    }
}

class Watcher01 implements Observer {

    public void update(Observable o, Object arg) {
        System.out.println("Watcher01 is " + ((Integer) arg).intValue());
    }

}

class Watcher02 implements Observer {

    public void update(Observable o, Object arg) {
        if (((Integer) arg).intValue() <= 5) {
            System.out.println("Watcher02 is" + ((Integer) arg).intValue());
        }
    }

}