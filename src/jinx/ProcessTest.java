package jinx;

public class ProcessTest {

        private static void ps() {
            try {
                String[] cmd = { "sh", "-c", "ps -ef|grep tomcat" };
                Process p = Runtime.getRuntime().exec(cmd);
                p.waitFor();
                p.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public static void main(String[] args){
            ps();
        }

}
