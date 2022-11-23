package com.example.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "greetingClient")
@Path("/hello")
public interface GreetingClient extends AutoCloseable {

    @GET
    String getGreeting();
}
