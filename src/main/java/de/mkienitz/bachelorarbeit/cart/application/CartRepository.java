package de.mkienitz.bachelorarbeit.cart.application;

import de.mkienitz.bachelorarbeit.cart.domain.CartItem;
import de.mkienitz.bachelorarbeit.cart.domain.ShoppingCartItem;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class CartRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartRepository.class.getName());

    private static final List<CartItem> CART_ITEMS = new ArrayList<CartItem>()
    {{
        add(new CartItem(1, "item.cantaloupe", 2.50));
        add(new CartItem(2, "item.coconut", 1.50));
        add(new CartItem(3, "item.grapes", 1.20));
        add(new CartItem(4, "item.peach", 0.60));
        add(new CartItem(5, "item.pear", 0.35));
        add(new CartItem(6, "item.pineapple", 1.80));
        add(new CartItem(7, "item.pomegranate", 1.40));
        add(new CartItem(8, "item.watermelon", 2.20));
    }};

    @Traced(operationName = "CartRepository.getShoppingCartItems")
    public List<ShoppingCartItem> getShoppingCartItems(final String shoppingCartId) {
        return this.generateShoppingCartItems(shoppingCartId.hashCode());
    }

    private List<ShoppingCartItem> generateShoppingCartItems(final int seed) {
        final Random rnd = new Random(seed);

        LOGGER.trace("generateShoppingCartItems(): seed = " + seed);

        List<CartItem> cartItems = getRandomSelectionOfCartItems(rnd);

        // generate a list containing 3-5 items
        final int numOfItems = 3 + rnd.nextInt(3);

        return pickItemsWithRandomAmount(cartItems, numOfItems, rnd);
    }

    private List<CartItem> getRandomSelectionOfCartItems(final Random rnd) {
        List<CartItem> cartItems = new ArrayList<>(CART_ITEMS);

        // shuffle the baseList with the seeded Random
        Collections.shuffle(cartItems, rnd);

        return cartItems;
    }

    private List<ShoppingCartItem> pickItemsWithRandomAmount(final List<CartItem> cartItems, final int numOfItems, final Random rnd) {
        List<ShoppingCartItem> items = new ArrayList<>();

        LOGGER.trace("pickItemsWithRandomAmount(): picking " + numOfItems + " random items");

        for(int i = 0; i < numOfItems; i++) {
            // get an item from the randomly shuffled list
            CartItem item = cartItems.get(i);

            // generate an amount of 1-3 items
            int rAmount = 1 + rnd.nextInt(3);

            items.add(new ShoppingCartItem(item, rAmount));
        }

        return items;
    }
}
