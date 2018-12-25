package com.demo.node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: demo
 * @Date: 2018/12/24
 * @Description: com.demo
 * @Version: 1.0
 */
public class Node {
    private Object data;//存放数据
    private Node next;//下一个节点

    public Node(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

}
