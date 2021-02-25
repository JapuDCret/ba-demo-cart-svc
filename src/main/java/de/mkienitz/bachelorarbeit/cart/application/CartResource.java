package de.mkienitz.bachelorarbeit.cart.application;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.opentracing.Traced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cart")
@RequestScoped
public class CartResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartResource.class.getName());

    @Inject
    private CartApplicationService service;

    @GET
    @Operation(description = "Get shopping cart")
    @Traced(operationName = "CartResource.getShoppingCart")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{shoppingCartId}")
    public Response getShoppingCart(@PathParam("shoppingCartId") String shoppingCartId) {
        if(shoppingCartId == null) {
            shoppingCartId = "00000000-0000-0000-0000-000000000000";
        }

        return Response.ok(service.getShoppingCart(shoppingCartId)).build();
    }
}
