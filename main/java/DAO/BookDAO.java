package DAO;

import Entity.Book;

import java.util.List;

public interface BookDAO {

    public Book getByID(Long id) throws DAOException;

    public List<Book> getAll() throws DAOException;

    public void addBook(Book book) throws IllegalArgumentException,DAOException;

    public void update(Book book) throws IllegalArgumentException,DAOException;

    public void remove(String nameBook) throws DAOException;

}
