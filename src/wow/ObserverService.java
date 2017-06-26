package wow;

public class ObserverService implements Observer {

    @Override
    public void execution(String action) {
        System.out.println(action);
    }
}
