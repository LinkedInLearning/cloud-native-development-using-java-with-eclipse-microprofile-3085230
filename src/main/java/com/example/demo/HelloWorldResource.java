package com.example.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/hello")
public class HelloWorldResource {

    @Timed(name = "HelloRequestTime",
        absolute = true,
        description = "Time taken to respond to hello world")
    @Counted(name = "HelloRequestCount",
        absolute = true,
        description = "Number of times hello is called")
    @GET
    public Response sayHello() {
        return Response.ok("Hello World").build();
  }

}