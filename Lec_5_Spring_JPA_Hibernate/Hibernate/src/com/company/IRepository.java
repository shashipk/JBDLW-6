package com.company;

public interface IRepository<T> {
    public void save(T object);
    public Object get(Class<T> tClass, long id);
    public void update(Object object);
    public void delete(Object object);
}
