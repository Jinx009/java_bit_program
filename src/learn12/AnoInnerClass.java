package learn12;

import java.util.Date;

/*
 * 匿名内部类
 * 要想实现匿名内部类，那么这个内部类必须是继承了某个类或者实现了某个接口
 */
public class AnoInnerClass {
    public static void main(String[] args) {
        AnoInner an = new AnoInner();

        String time = an.getDate(new Date() {
                                     private static final long serialVersionUID = 1L;

                                     public String toLocaleString() {
                                         return "hell Medivh";
                                     }
                                 }
        );

        System.out.println(time);
    }
}

class AnoInner {
    @SuppressWarnings("deprecation")
    public String getDate(Date date) {
        return date.toLocaleString();
    }
}