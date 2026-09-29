package iuh.fit.thantrongthang_23729371_tuan4_bai4.beans;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
    private List<CartItemBean> items;

    public CartBean() {
        items = new ArrayList<>();
    }

    public List<CartItemBean> getItems() {
        return items;
    }

    // thêm sản phẩm
    public void addBook(Book b, int quantity) {
        for (CartItemBean item : items) {
            if (item.getBook().getId() == b.getId()) {
//                 item.setQuantity(item.getQuantity() + 1);
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItemBean(b, quantity));
    }

    // xóa sản phẩm
    public void removeBook(int BookId) {
        items.removeIf(item -> item.getBook().getId() == BookId);
    }

    // cập nhật số lượng
    public void updateQuantity(int BookId, int quantity) {
        for (CartItemBean item : items) {
            if (item.getBook().getId() == BookId) {
                if (quantity > 0) {
                    item.setQuantity(quantity);
                } else {
                    // nếu nhập <= 0 thì xóa luôn sản phẩm
                    removeBook(BookId);
                }
                return;
            }
        }
    }

    // tính tổng tiền
    public double getTotal() {
        double total = 0;
        for (CartItemBean item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    // xóa hết giỏ hàng
    public void clear() {
        items.clear();
    }
}