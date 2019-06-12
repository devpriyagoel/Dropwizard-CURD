package com.mygroup.resources;
import com.mygroup.api.Saying;
import com.codahale.metrics.annotation.Timed;
import com.mygroup.firstprojApplication;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;


@Path("/firstproj")
@Produces(MediaType.APPLICATION_JSON)
public class firstprojResource {
    private final String template;
    private final String defaultName;
    private final String defaultAlias;
    private final AtomicLong counter;

    public firstprojResource(String template, String defaultName, String defaultAlias){
        this.template = template;
        this.defaultName = defaultName;
        this.defaultAlias = defaultAlias;
        this.counter = new AtomicLong();
    }


    @GET
    @Path("/{id}")
    public Saying sayHello(@PathParam("id") int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampledb", "devpriyagoel", "postgres")) {

            System.out.println("Connected to PostgreSQL database!");
            System.out.println(id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.person WHERE id=id");
            if(resultSet.next()) {
                System.out.printf("%s  %s  %s%n", resultSet.getString("id"),
                        resultSet.getString("name"), resultSet.getString("alias"));
                final String value = String.format(template, resultSet.getString("name"), resultSet.getString("alias"));
                return new Saying(counter.incrementAndGet(), value, id);
            }else{
                final String value = "error occurred";
                return new Saying(counter.incrementAndGet(), value, id);
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
            final String value = "error occurred";
            return new Saying(counter.incrementAndGet(), value, id);
        }
        // retrieve information about the contact with theprovided id

    }
}