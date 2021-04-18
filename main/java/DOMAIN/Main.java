package DOMAIN;

import BookService.BookJDBC;
import Entity.Book;
import getInfo.Parser;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BookJDBC put = new BookJDBC();

        for (Book q : put.selectAllBookByAuthor("Дэниел Киз ")){
            System.out.println(q);

        }


    }

    public static ArrayList<Book> insertBook() { //add to database from parser
        Parser parser = new Parser();
        ArrayList<Book> list = new ArrayList<>();

        for (int i = 0; i < parser.setNameBook().size(); i++) {
            String name = parser.setNameBook().get(i);
            String price = parser.setCostBook().get(i);
            String author = parser.setAuthorBook().get(i);
            String date = parser.setDataBook().get(i);
            String url = parser.setUrlBook().get(i);

            list.add(new Book(name,price,author,date,url));
        }


        return list;
    }


}
