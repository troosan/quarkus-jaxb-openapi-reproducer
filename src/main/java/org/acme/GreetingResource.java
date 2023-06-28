package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;

import org.acme.model.HelloResponse;
import org.jboss.resteasy.reactive.RestResponse;


@Path("/hello")
public class GreetingResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RestResponse<HelloResponse> hello() {
		HelloResponse response = new HelloResponse();
		response.setGreeting("Hello");
		response.setName("World");

		return RestResponse.ok(response);
	}
}
