package com.demo.linkNode;

/**
 * @Author: demo
 * @Date: 2018/12/25
 * @Description: com.demo.linkNode
 * @Version: 1.0
 */
public class Link<T> {

    private class Node {
        private T data;   //存放数据
        private Node next;//连接节点

        public Node(T data) {
            this.data = data;
        }

        /**
         * 维护节点的排序
         * @param node
         */
        public void addNode(Node node) {
            if (this.next == null) { //root.next == null
                    this.next = node;
            } else {
                this.next.addNode(node);
            }
        }

        /**
         * 递归将链表中的数据存入对象数组中
         */
        public void toArrayNode() {
            Link.this.arrObj[Link.this.foot++] = this.data;
            if (this.next != null) { //递归调用
                this.next.toArrayNode();
            }
        }

        /**
         * 判断是否包含指定元素
         * @return
         */
        public boolean containNode(Object obj){
            if (this.data == null) {
                return  false;
            }
             if (this.data.equals(obj)) {
                 return true;
             } else {
                 if (this.next != null) {
                     return this.next.containNode(obj);
                 } else {
                     return false;
                 }
             }
        }

        /**根据指定索引查找数据*/
        public T get(int index) {
            if (Link.this.foot ++ == index) {
                return this.data;
            } else {
                if (this.next != null) {
                    return this.next.get(index);
                } else {
                    return null;
                }
            }
        }

        /**根据指定索引修改数据*/
        public boolean setNode(Integer index, Object newValue) {
            if (Link.this.foot ++ == index) {//匹配指定索引
                this.data = (T)newValue;//修改数据
                return true;
            } else {
                if (this.next != null) { //递归操作
                    return this.next.setNode(index, newValue);
                } else {
                    return false;
                }
            }
        }

        /**移除指定元素节点*/
        public boolean removeNode(Node preNode,T obj) {
            /**
             * 根节点在Link类中进行判断，这里直接从root.next开始判断
             */
            if (this.data.equals(obj)) {
                preNode.next = this.next; //删除节点的上一级节点的next = 删除节点的下一级节点
                return true;
            } else if (this.next != null) {
                return this.next.removeNode(this,obj);
            } else {
                return false;
            }
        }
    }

    //---------------------以下是Link类----------------------//
    private int foot = 0; //对象数组索引
    private Object[] arrObj;//对象数组
    private Node root = null;//根节点
    private int count;//记录元素个数
    /**添加数据*/
    public boolean add(T data) {
        if (root == null) {
            root = new Node(data);//将数据封装在节点中（数据自身不具备排序性）
        } else {
            //节点应该交给Node来处理
            Node node = new Node(data);
            this.root.addNode(node);
        }
        this.count++;
        return true;
    }

    /**
     * 将链表数据转为对象数组数据
     * @return
     */
    public Object[] toArray() {
        if (this.isEmpty()) {
            return null;
        }
        this.arrObj = new Object[this.count];
        foot = 0; //清零操作
        this.root.toArrayNode();
        return  this.arrObj;
    }

    /**判断是否包含指定元素*/
    public boolean contains(Object obj) {
        if (obj == null || this.root == null) {
            return false;
        } else {
            return this.root.containNode(obj);
        }
    }

    /**根据索引查询数据*/
    public <T> T get(Integer index) {
        if (index >= this.count) {
            return null;
        }
        this.foot = 0;//清零操作
        return (T)this.root.get(index);
    }

    /**根据指定索引修改数据*/
    public boolean set(Integer index, Object newValue) {
        if (index >= this.count || index < 0 || this.root == null) {
            return false;
        }
        this.foot = 0;
        return this.root.setNode(index,newValue);
    }

    /**移除指定元素*/
    public boolean remove(T t) {
        boolean flag = false;
        if (this.contains(t)) {//包含有要删除的数据
            if (this.root.data.equals(t)) { //移除根节点数据
                this.root = this.root.next;
                flag = true;
            } else if (this.root.next != null) {  //移除不是根节点中的数据，则从this.root.next开始
                flag = this.root.next.removeNode(this.root,t);
            }
        }
        if (flag) { //删除成功
            this.count--;
        }
        return flag;
    }
    /**获取元素个数*/
    public int size() {
        return this.count;
    }
    /**判断是否为空*/
    public boolean isEmpty() {
        return this.root == null && this.count == 0;
    }
}
