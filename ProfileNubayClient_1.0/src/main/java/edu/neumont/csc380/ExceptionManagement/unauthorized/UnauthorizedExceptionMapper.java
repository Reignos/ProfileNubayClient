package edu.neumont.csc380.ExceptionManagement.unauthorized;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class UnauthorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {

	public Response toResponse(UnauthorizedException exception) {
		Status currentStatus = Response.Status.UNAUTHORIZED; 
		return Response.status(currentStatus).header("exception", exception.getMessage()).build();
	}

}
