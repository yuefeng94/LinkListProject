package com.demo.node;

/**
 * @Author: demo
 * @Date: 2018/12/24
 * @Description: com.demo
 * @Version: 1.0
 */
public class NodeDemo {

    public static void  main(String[] args) {
        Node root = new Node("火车头");
        Node a1 = new Node("火车a");
        Node b1 = new Node("火车b");
        Node c1 = new Node("火车c");
        root.setNext(a1);
        a1.setNext(b1);
        b1.setNext(c1);
        print(root);

    }
    public static void print(Node node) {
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
