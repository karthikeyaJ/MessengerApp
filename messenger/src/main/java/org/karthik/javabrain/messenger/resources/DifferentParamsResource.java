package org.karthik.javabrain.messenger.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/differentParams")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DifferentParamsResource {

	@GET
	@Path("/annotations")
	public String getDifferentParamsUsingAnnotations(@MatrixParam ("MatrixParam") String matrixParam
													,@HeaderParam ("authSessionId") String header 
													,@CookieParam ("cookieName") String name) {
		return "Matrix Param :"+matrixParam+"\tHeader: "+header+"\tcookie :"+name;
	}
	
	
}
