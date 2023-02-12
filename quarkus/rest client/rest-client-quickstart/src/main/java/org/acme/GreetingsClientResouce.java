package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@Path("/client")
public class GreetingsClientResouce {

    @Inject
    @RestClient
    GreetingServerService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("Service Called");
        return greetingService.hello();
    }



    @GET
    @Path("/testFormEncoded")
    @Produces(MediaType.APPLICATION_FORM_URLENCODED) 
    public String testFormEncoded() {
        return "testFormEncoded";
    }

}
