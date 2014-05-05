package edu.neumont.csc380.ExceptionManagement.notFound;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import edu.neumont.csc380.ExceptionManagement.unauthorized.UnauthorizedException;

public class NotFoundExceptionMapper implements ExceptionMapper<UnauthorizedException> {

	public Response toResponse(UnauthorizedException exception) {
		Status currentStatus = Response.Status.NOT_FOUND; 
		return Response.status(currentStatus).header("exception", exception.getMessage()).build();
	}

}
