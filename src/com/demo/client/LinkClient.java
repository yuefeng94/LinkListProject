package com.demo.client;

import com.demo.factory.LinkFactory;
import com.demo.link.interfaces.LinkInterface;
import com.demo.link.interfaces.impl.LinkInterfaceImpl;

/**
 * @Author: demo
 * @Date: 2018/12/25
 * @Description: com.demo.client
 * @Version: 1.0
 */
public class LinkClient {
    public static void main(String[] args) {
        LinkInterface linkInterface = LinkFactory.getInstance(LinkInterfaceImpl.class);
        System.out.println("size = " + linkInterface.size() + ", isEmpty = " + linkInterface.isEmpty()); ;
        linkInterface.add("hello");
        linkInterface.add("world");
        linkInterface.add("java");
        System.out.println("size = " + linkInterface.size() + ", isEmpty = " + linkInterface.isEmpty()) ;
        System.out.println("remove java : " + linkInterface.remove("java"));
        System.out.println("size = " + linkInterface.size() + ", isEmpty = " + linkInterface.isEmpty()) ;

        Object[] objects = linkInterface.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }


    }
}
