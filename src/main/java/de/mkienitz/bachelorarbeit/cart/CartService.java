package de.mkienitz.bachelorarbeit.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CartService {

    private static Logger log = LoggerFactory.getLogger(CartService.class.getName());

    private static final List<CartItem> CART_ITEMS = new ArrayList<CartItem>()
    {{
        add(new CartItem(0, "item.cantaloupe", 2.50));
        add(new CartItem(1, "item.coconut", 1.50));
        add(new CartItem(2, "item.grapes", 1.20));
        add(new CartItem(3, "item.peach", 0.60));
        add(new CartItem(4, "item.pear", 0.35));
        add(new CartItem(5, "item.pineapple", 1.80));
        add(new CartItem(6, "item.pomegranate", 1.40));
        add(new CartItem(7, "item.watermelon", 2.20));
    }};

    public ShoppingCart getShoppingCart(String seed) {
        final Random rnd = new Random(seed.hashCode());

        final int numOfItems = 3 + rnd.nextInt(3);

        List<ShoppingCartItem> items = new ArrayList<>();

        for(int i = 0; i < numOfItems; i++) {
            int rIndex;
            boolean isAlreadyContained;
            do {
                rIndex = rnd.nextInt(8);

                isAlreadyContained = false;

                for(ShoppingCartItem item : items) {
                    isAlreadyContained = (rIndex == item.id);
                    if(isAlreadyContained) { break; };
                }
            } while(isAlreadyContained);

            CartItem item = CART_ITEMS.get(rIndex);

            int rAmount = 1 + rnd.nextInt(3);

            items.add(new ShoppingCartItem(item, rAmount));
        }
        ShoppingCart shoppingCart = new ShoppingCart(items);

        return shoppingCart;
    }
}
