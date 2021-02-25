package de.mkienitz.bachelorarbeit.cart.application;

import de.mkienitz.bachelorarbeit.cart.domain.ShoppingCart;
import de.mkienitz.bachelorarbeit.cart.domain.ShoppingCartItem;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CartApplicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartApplicationService.class.getName());

    @Inject
    private CartRepository repository;

    @Traced(operationName = "CartApplicationService.getShoppingCart")
    public ShoppingCart getShoppingCart(final String shoppingCartId) {
        LOGGER.debug("getShoppingCart(): requesting shopping cart with id = " + shoppingCartId);

        List<ShoppingCartItem> items = repository.getShoppingCartItems(shoppingCartId);

        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartId, items);

        return shoppingCart;
    }
}
