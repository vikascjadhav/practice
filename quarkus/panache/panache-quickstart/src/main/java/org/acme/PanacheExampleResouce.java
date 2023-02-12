package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/panache")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class PanacheExampleResouce {
    @GET
    public List<Person> listPersons() {
        List<Person> list = Person.listAll();
        System.out.println(list.size());
        return list;
    }

    @Path("/find/{name}")
    @GET    
    public List<Person> findByName(@PathParam("name") String name) {
        List<Person> list = Person.list("lname = ?1 or lname = 'J1'", name);
        System.out.println(Person.count("fname = ?1", name));
        return list;
    }

    @Path("/delete/{name}")
    @GET    
    @Transactional
    public Long deleteByName(@PathParam("name") String name) {
         return Person.delete("lname = ?1 or lname = 'J1'", name);
    }

}
