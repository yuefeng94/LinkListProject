package com.demo.link.interfaces.impl;

import com.demo.link.interfaces.LinkInterface;
import com.demo.linkNode.Link;

/**
 * @Author: demo
 * @Date: 2018/12/25
 * @Description: com.demo.link.interfaces.impl
 * @Version: 1.0
 */
public  class LinkInterfaceImpl<T> implements LinkInterface<T> {
    private Link link = new Link();
    @Override
    public boolean add(T t) {
        return link.add(t);
    }

    @Override
    public Object get(Integer index) {
        return link.get(index);
    }

    @Override
    public boolean set(Integer index, Object newValue) {
        return link.set(index,newValue);
    }

    @Override
    public boolean remove(T t) {
        return link.remove(t);
    }

    @Override
    public int size() {
        return link.size();
    }

    @Override
    public boolean isEmpty() {
        return link.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return link.toArray();
    }

    @Override
    public boolean contains(Object obj) {
        return link.contains(obj);
    }
}
