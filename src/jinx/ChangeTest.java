package jinx;

public class ChangeTest {


    private static String getData(String index, String _d) throws Exception{
        int _index = Integer.parseInt(index,16);
        Integer a = Integer.valueOf(_d, 16);
        String b = Integer.toBinaryString(a);
        String[] arr = b.split("");
        String c = "";
        Integer e = Integer.parseInt(b, 2);
        if (_index>8) {
            for (String d : arr) {
                if (d.equals("1")) {
                    c += "0";
                } else {
                    c += "1";
                }
            }
            e = (Integer.parseInt(c, 2) + 1) * -1;
        }else{
            e = Integer.valueOf(String.valueOf(Integer.parseInt(_d, 16)));
        }
        return String.valueOf(Double.valueOf(e)/1000);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getData("0","085F"));
    }

}
