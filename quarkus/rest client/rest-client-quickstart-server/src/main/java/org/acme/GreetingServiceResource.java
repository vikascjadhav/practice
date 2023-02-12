package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/server")
@ApplicationScoped
public class GreetingServiceResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/testFormEncoded")
    @Produces(MediaType.APPLICATION_FORM_URLENCODED) 
    public String testFormEncoded() {
        return "testFormEncoded - This is Response from Server";
    }
}