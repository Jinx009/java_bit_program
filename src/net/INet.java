package net;

import java.net.InetAddress;

public class INet {
    public static void main(String[] args) throws Exception {
//			InetAddress address = InetAddress.getLocalHost();
//			
//			System.out.println(address.toString());
//			
//			InetAddress address1 = InetAddress.getByName("www.baidu.com");
//			
//			System.out.println(address1.toString());
        InetAddress ia = InetAddress.getByName("blog.csdn.org");

        System.out.println(ia.toString());
    }
}
