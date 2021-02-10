package de.mkienitz.bachelorarbeit.cart.application;

import de.mkienitz.bachelorarbeit.cart.domain.CartItem;
import de.mkienitz.bachelorarbeit.cart.domain.ShoppingCart;
import de.mkienitz.bachelorarbeit.cart.domain.ShoppingCartItem;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class CartService {

    private static final Logger log = LoggerFactory.getLogger(CartService.class.getName());

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

    @Traced(operationName = "CartService.getShoppingCart")
    public ShoppingCart getShoppingCart(String shoppingCartId) {
        List<ShoppingCartItem> items = this.generateRandomItemList(shoppingCartId.hashCode());

        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartId, items);

        return shoppingCart;
    }

    private List<ShoppingCartItem> generateRandomItemList(int seed) {
        final Random rnd = new Random(seed);

        List<CartItem> baseList = new ArrayList<>(CART_ITEMS);

        // shuffle the baseList with the seeded Random
        Collections.shuffle(baseList, rnd);

        List<ShoppingCartItem> items = new ArrayList<>();

        // generate a list containing 3-5 items
        final int numOfItems = 3 + rnd.nextInt(3);

        for(int i = 0; i < numOfItems; i++) {
            // get an item from the randomly shuffled list
            CartItem item = baseList.get(i);

            int rAmount = 1 + rnd.nextInt(3);

            items.add(new ShoppingCartItem(item, rAmount));
        }

        return items;
    }
}
