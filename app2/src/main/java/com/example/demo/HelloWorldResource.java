package com.example.demo;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class HelloWorldResource {

    @Inject
    @RestClient
    private GreetingClient greetingClient;

    @Timed(name = "HelloRequestTime",
        absolute = true,
        description = "Time taken to respond to hello world")
    @Counted(name = "HelloRequestCount",
        absolute = true,
        description = "Number of times hello is called")
    @GET
    public Response sayHello() throws InterruptedException {
        Thread.sleep(5000);
        String greeting = greetingClient.getGreeting();
        return Response.ok(greeting).build();
    }

}