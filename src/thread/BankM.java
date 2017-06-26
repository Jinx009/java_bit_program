package thread;

public class BankM {
    public static void main(String[] args) {
        Bank b = new Bank();

        Thread t = new One(b);

        Thread t1 = new One(b);

        t.start();

        t1.start();
    }
}

class Bank {
    private int money = 1000;

    public synchronized int getMoney(int number) {
        if (number < 0) {
            return -1;
        } else if (number > money) {
            return -2;
        } else if (money < 0) {
            return -3;
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            money -= number;

            System.out.println("剩了" + money + "块。");

            return number;
        }
    }
}

class One extends Thread {
    private Bank bank;

    public One(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        System.out.println(bank.getMoney(800));
    }
}