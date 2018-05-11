package jinx;

public class Six {

    public static void main(String[] args){
        for(int i = 0;i<300;i++){
            String str = Integer.toHexString(i);
            if(str.length()==1){
                System.out.println("000118050300000"+str);
            }
            if(str.length()==2){
                System.out.println("00011805030000"+str);
            }
            if(str.length()==3){
                System.out.println("0001180503000"+str);
            }
            if(str.length()==4){
                System.out.println("0001180503000"+str);
            }
        }
    }

}
