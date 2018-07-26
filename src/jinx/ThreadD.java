package jinx;

public class ThreadD {

  public static void main(String[] args){
      new Thread(){
          public void run(){
             System.out.println("123");
          }
      }.start();
  }

}
