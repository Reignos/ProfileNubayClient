package edu.neumont.csc380.ExceptionManagement.invalidInput;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {
	public Response toResponse(InvalidInputException exception){
		Status currentStatus = Response.Status.BAD_REQUEST; 
		return Response.status(currentStatus).header("exception", exception.getMessage()).build();
	}
}
