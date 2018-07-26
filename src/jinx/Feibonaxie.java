package jinx;

public class Feibonaxie {


    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int[]  i = new int[20];
                for(int j = 0;j<20;j++){
                    if(j<2){
                        i[j] = 1;
                    }else{
                        i[j] = i[j-2]+i[j-1];
                    }
                    System.out.println(i[j]);
                }
            }
        }).start();
    }

}
