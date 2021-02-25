package de.mkienitz.bachelorarbeit.cart;

import de.mkienitz.bachelorarbeit.cart.application.CartResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/data")
public class CartSvcRestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();

        s.add(CORSFilter.class);
        s.add(CartResource.class);

        return s;
    }
}
