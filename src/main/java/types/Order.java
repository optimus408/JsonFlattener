package types;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;

    private User buyer;

    private User seller;

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    private List<LineItem> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public static Order mockOrder() {
        Order anOrder = new Order();
        anOrder.setBuyer(User.mockBuyer());
        anOrder.setSeller(User.mockSeller());
        anOrder.setId("11-11-111-11111");
        anOrder.getItems().add(LineItem.mockItem());
        return anOrder;
    }
}
