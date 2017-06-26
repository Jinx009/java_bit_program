package wow;

public interface Pantheon {
    /*
     * 万神殿所拥有的方法
     */
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void SendMessage(String msg, String observerName);
}
