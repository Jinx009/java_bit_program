package jinx;

import java.io.IOException;

import javax.mail.MessagingException;

/**
 * 邮件发送工具实现类
 *
 * @author shadow
 * @create 2013/07/12
 */
public class MailUtil {

    public static void main(String[] args) throws MessagingException, IOException{

        Mail.sendMail("hehe","wow4464@qq.com");
    }

}
