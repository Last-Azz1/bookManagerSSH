package pers.ssh.domain;

public class Book {
    private Integer id;
    private String bookname;
    private String booktype;
    private String author;
    private String publisher;
    private Float price;
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Book() {
    }

    public Book(Integer id, String bookname, String booktype, String author, String publisher, Float price, Integer stock) {
        this.id = id;
        this.bookname = bookname;
        this.booktype = booktype;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", booktype='" + booktype + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
