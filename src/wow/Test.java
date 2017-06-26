package wow;

public class Test {
    public static void main(String[] args) {
        Pantheon sargeras = new PantheonService();

        Observer orrGallon = new ObserverService();

        Observer orrGallon1 = new ObserverService();

        Observer orrGallon2 = new ObserverService();

			/*
			 * 万神殿添加了3个观察者
			 */
        sargeras.addObserver(orrGallon);
        sargeras.addObserver(orrGallon1);
        sargeras.addObserver(orrGallon2);

        sargeras.SendMessage("Formatting the planet Azeroth", "argus");//万神殿向观察者发出'格式化艾泽拉斯星球信息'；

        System.out.println("******************************");

        sargeras.removeObserver(orrGallon2);//删除了一名观察者

        sargeras.SendMessage("Omega duplicate code", "delano");//重复代码欧米伽
    }
}	
