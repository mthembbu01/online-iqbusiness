package net.iqbusiness.buhle.onlineregistrationapp.service;

import java.util.List;

public interface IService<E> {
    E getOne(String idNumber);

    List<E> getAll();

    E save(E e);

    E updateOne(E e);

    void deleteOne(E e) ;

    void deleteOne(Long id) ;
}
