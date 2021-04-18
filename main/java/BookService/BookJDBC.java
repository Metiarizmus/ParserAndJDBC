package BookService;

import DAO.BookDAO;
import DAO.DAOException;
import DAO.DAOFactory;
import Entity.Book;
import getInfo.Parser;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BookJDBC extends DAOFactory implements BookDAO {



    public BookJDBC() {

    }


    @Override
    public List<Book> getAll() throws DAOException {
        List<Book> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Book book = null;

        try {
            connection = getConnection();
            statement=connection.prepareStatement("select * from book ");
            result=statement.executeQuery();
            while (result.next()){
              list.add(map(result));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return list;
    }



    @Override
    public void addBook(Book book) throws IllegalArgumentException, DAOException {
        if(book.getId() != null) {
            throw new IllegalArgumentException("Book is already create, the Book id is not null");
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection= getConnection();

            statement = connection.prepareStatement("INSERT INTO BOOK (author,date,name,price,url) VALUES (?,?,?,?,?)");
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getDate());
            statement.setString(3, book.getName());
            statement.setString(4, book.getPrice());
            statement.setString(5, book.getUrl());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }

    @Override
    public void update(Book book) throws IllegalArgumentException, DAOException {
        if(book.getId() != null) {
            throw new IllegalArgumentException("Book is already create, the Book id is not null");
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection=getConnection();
            statement = connection.prepareStatement("update BOOK set author=?,date=?,name=?,price=?,url=?");
            statement.setString(1, book.getAuthor());
            statement.setString(2, book.getDate());
            statement.setString(3, book.getName());
            statement.setString(4, book.getPrice());
            statement.setString(5, book.getUrl());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(String nameBook) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet getKey = null;


        try {
            connection=getConnection();

            statement=connection.prepareStatement("delete from book where id = " + getId(nameBook).get(0));

            statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    private ArrayList<Integer> getId(String name) { //select id of name
        ArrayList<Integer> list = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;

        try{
            connection=getConnection();
            statement=connection.createStatement();

            String sql = "select id from book where name = '" + name+"'";
            res = statement.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                list.add(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (res!=null){
                try {
                    res.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return list;
    }

    public HashSet<Book> selectAllBookByAuthor(String nameAuthor) throws DAOException{

        HashSet<Book> list = new HashSet<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;


        try {
            connection = getConnection();
            //connection.setTransactionIsolation(1); Транзакции
            statement=connection.prepareStatement("select * from book where author = '" + nameAuthor+"' ");
            result=statement.executeQuery();

            while (result.next()){
                list.add(map(result));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (result!=null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return list;
    }


    @Override
    public Book getByID(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Book book = null;

        try {
            connection = getConnection();
            statement=connection.prepareStatement("select * from book where id="+id);
            result=statement.executeQuery();

            if (result.next()) {
                book=map(result);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return book;
    }


    private static Book map(ResultSet result) throws SQLException {
        Book book = new Book();
        book.setId(result.getLong("id"));
        book.setAuthor(result.getString("author"));
        book.setDate(result.getString("date"));
        book.setName(result.getString("name"));
        book.setPrice(result.getString("price"));
        book.setUrl(result.getString("url"));
        return book;
    }
}
