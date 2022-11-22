package com.example.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldResource {

  @GET
  public Response sayHello() {
    return Response.ok("Hello World").build();
  }

}