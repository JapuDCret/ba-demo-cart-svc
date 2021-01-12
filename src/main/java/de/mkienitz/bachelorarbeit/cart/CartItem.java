package de.mkienitz.bachelorarbeit.cart;

public class CartItem {

    protected int id;

    protected String translationKey;

    protected double price;

    public CartItem(int id, String translationKey, double price) {
        this.id = id;
        this.translationKey = translationKey;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public void setTranslationKey(String translationKey) {
        this.translationKey = translationKey;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CartItem{" +
                "id=" + id +
                ", translationKey='" + translationKey + '\'' +
                ", price=" + price +
                '}';
    }
}
