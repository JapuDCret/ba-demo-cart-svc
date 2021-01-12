package de.mkienitz.bachelorarbeit.cart;

import java.util.List;

public class ShoppingCart {

    private String shoppingCartId;

    private List<ShoppingCartItem> items;

    public ShoppingCart() {
    }

    public ShoppingCart(String shoppingCartId, List<ShoppingCartItem> items) {
        this.shoppingCartId = shoppingCartId;
        this.items = items;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartId='" + shoppingCartId + '\'' +
                ", items=" + items +
                '}';
    }
}
