package jinx;

public class SerialNumberGenerator {

    private static volatile int SerialNumber = 0;
    public static int nextSerialNumber(){
        return SerialNumber++;
    }

}
