package wow;

import java.util.ArrayList;
import java.util.List;

public class PantheonService implements Pantheon {
    private List<Observer> list = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void SendMessage(String msg, String observerName) {
        for (Observer o : list) {
            o.execution("已经发送至" + o);
            System.out.println(observerName + "需要执行：" + msg);
        }
    }

}
