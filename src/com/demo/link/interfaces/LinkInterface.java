package com.demo.link.interfaces;

/**
 * @Author: demo
 * @Date: 2018/12/25
 * @Description: com.demo.link.interfaces
 * @Version: 1.0
 */
public interface LinkInterface<T> {
    public boolean add(T t);
    public Object get(Integer index);
    public boolean set(Integer index, Object newValue);
    public boolean remove(T t);
    public int size();
    public boolean isEmpty();
    public Object[] toArray();
    public boolean contains(Object obj);

}
