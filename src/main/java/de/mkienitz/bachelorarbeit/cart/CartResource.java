package de.mkienitz.bachelorarbeit.cart;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/cart")
@Singleton
public class CartResource {

    private static Logger logger = LoggerFactory.getLogger(CartResource.class.getName());

    @Inject
    private CartService service;

    @GET
    @Operation(description = "Get translations")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response getShoppingCart(@QueryParam("seed") String seed) {
        if(seed == null) {
            seed = "12345678";
        }
        return Response.ok(service.getShoppingCart(seed)).build();
    }
}
