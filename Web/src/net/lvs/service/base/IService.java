package net.lvs.service.base;

import java.util.List;

public interface IService<E> {
    List<E> getList();
    void addNew(E e);
    void delete(String id);
    void update(String id, E e);
}
