package iuh.fit.thantrongthang_23729371_tuan4_bai4.beans;

import java.io.Serializable;

public class CartItemBean implements Serializable {
    private Book book;
    private int quantity;

    public CartItemBean() {
    }

    public CartItemBean(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }
//Getter & Setter

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return book.getPrice() * quantity;
    }
}
