/**
 * 
 */
package com.restaurant.booking;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.handlers.ResourceHandlerBuilder;
import io.muserver.rest.RestHandlerBuilder;

/**
 * 
 */
public class EntryPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RestaurnatApi restaurnatApi = new RestaurnatApi();

//		MuServer server = MuServerBuilder.httpServer()
//				.addHandler(RestHandlerBuilder.restHandler(restaurnatApi).addCustomWriter(new JacksonJaxbJsonProvider())
//						.addCustomReader(new JacksonJaxbJsonProvider()))
//				.addHandler(ResourceHandlerBuilder.fileOrClasspath("src/main/resources/web", "/web")) .start();

		MuServer server = MuServerBuilder.muServer().withHttpPort(8084)
				.addHandler(RestHandlerBuilder.restHandler(restaurnatApi).addCustomWriter(new JacksonJaxbJsonProvider())
						.addCustomReader(new JacksonJaxbJsonProvider()))
				.addHandler(ResourceHandlerBuilder.fileOrClasspath("src/main/resources/web", "/web").withDefaultFile("index.html")).start();
		System.out.println("Server Started");

		System.out.println("API example: " + server.uri());

	}

}
