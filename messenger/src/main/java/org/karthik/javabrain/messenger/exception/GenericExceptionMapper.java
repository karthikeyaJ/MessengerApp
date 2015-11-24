package org.karthik.javabrain.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.karthik.javabrain.messenger.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex){
		 ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),500,"http://venkatakarthikeyajangal.me");
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.type(MediaType.APPLICATION_XML)
					.entity(errorMessage)
					.build();
	}

}
