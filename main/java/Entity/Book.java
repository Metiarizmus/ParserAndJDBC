package Entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private String price;
    private String author;
    private String date;
    private String url;

    public Book(){

    }


    public Book(String name, String price, String author, String date, String url) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.date = date;
        this.url = url;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Book) && (id != null)
                ? id.equals(((Book) other).id)
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ?(this.getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", url='" + url + '\'' +
                '}';
    }


}
