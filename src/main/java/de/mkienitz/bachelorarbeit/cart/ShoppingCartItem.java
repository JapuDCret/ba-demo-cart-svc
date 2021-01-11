package de.mkienitz.bachelorarbeit.cart;

public class ShoppingCartItem extends CartItem {

    protected int amount;

    public ShoppingCartItem(int id, String translationKey, double price, int amount) {
        super(id, translationKey, price);

        this.amount = amount;
    }

    public ShoppingCartItem(CartItem baseItem, int amount) {
        super(baseItem.id, baseItem.translationKey, baseItem.price);

        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", translationKey='" + translationKey + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
