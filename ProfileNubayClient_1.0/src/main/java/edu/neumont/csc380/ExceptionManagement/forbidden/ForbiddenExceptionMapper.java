package edu.neumont.csc380.ExceptionManagement.forbidden;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

	public Response toResponse(ForbiddenException exception) {
		Status currentStatus = Response.Status.FORBIDDEN;
		return Response.status(currentStatus).header("exception", exception.getMessage()).build();
	}
	

}
