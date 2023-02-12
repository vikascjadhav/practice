package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/hello")
@RegisterRestClient
@ApplicationScoped
@RegisterClientHeaders
public interface GreetingServerService {
    @GET
    @Path("/testFormEncoded")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() ;
}
