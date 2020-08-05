package com.geeksforgeeks.springdatalec5.service;

public interface IService<T> {
    public void create(T object);
    public T get(long id);
    void update(T object);
}
