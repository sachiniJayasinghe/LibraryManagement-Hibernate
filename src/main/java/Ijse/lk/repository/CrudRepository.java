package Ijse.lk.repository;

import Ijse.lk.entity.User;

import java.util.List;

public interface CrudRepository<T> extends SuperDAO{
    public List<T > getAll()  throws Exception ;
    public boolean add(T entity)  throws Exception;
    public boolean update(T entity)  throws Exception ;
    public boolean exist(Long id)  throws Exception ;
    public boolean delete(Long id)  throws Exception ;
}








































