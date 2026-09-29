package iuh.fit.thantrongthang_23729371_tuan4_bai4.beans;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String tittle;
    private String author;
    private double price;
    private String imgBook;


    public Book() {
    }

    public Book(int id, String tittle, String author, double price, String imgBook) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
        this.price = price;
        this.imgBook = imgBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgBook() {
        return imgBook;
    }

    public void setImgBook(String imgBook) {
        this.imgBook = imgBook;
    }
}
