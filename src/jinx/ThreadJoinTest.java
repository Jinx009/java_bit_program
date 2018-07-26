package jinx;

public class ThreadJoinTest extends Thread{
    private boolean test;
    public ThreadJoinTest(String name,boolean test){
        super(name);
        this.test = test;
    }
    public void run(){
        try {
            if(test){
                join();
            }else{
//                a
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(getName()+"is complated！");
    }


    public static void main(String[] args){
        ThreadJoinTest threadJoinTest = new ThreadJoinTest("jinx",true),
                       threadJoinTest2 = new ThreadJoinTest("jinx007",false);
        threadJoinTest.start();
        threadJoinTest2.start();

    }



}
