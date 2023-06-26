package lk.ijse.Jayasakuna.dao;


import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudDAO <T,ID>extends SuperDAO {

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

     boolean update(T dto) throws SQLException, ClassNotFoundException;

     boolean delete(ID id) throws SQLException, ClassNotFoundException;

     T getID(ID id) throws SQLException, ClassNotFoundException;

     ArrayList<String> loadID(String id) throws SQLException, ClassNotFoundException;
}
