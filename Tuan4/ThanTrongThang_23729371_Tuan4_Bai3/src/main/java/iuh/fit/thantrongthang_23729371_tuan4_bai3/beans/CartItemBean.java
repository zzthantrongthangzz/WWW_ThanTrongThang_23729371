package iuh.fit.thantrongthang_23729371_tuan4_bai3.beans;

import java.io.Serializable;

public class CartItemBean implements Serializable {
    private Product product;
    private int quantity;

    public CartItemBean() {
    }

    public CartItemBean(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
//Getter & Setter

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
