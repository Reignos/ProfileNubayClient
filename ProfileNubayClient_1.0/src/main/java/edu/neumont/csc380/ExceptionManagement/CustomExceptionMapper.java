package edu.neumont.csc380.ExceptionManagement;

import java.util.HashMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.neumont.csc380.ExceptionManagement.forbidden.ForbiddenException;
import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ExceptionManagement.notFound.NotFoundException;
import edu.neumont.csc380.ExceptionManagement.unauthorized.UnauthorizedException;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {
	
	HashMap<Class<?>,Status> exceptionMap = new HashMap<Class<?>, Status>();
	
	public CustomExceptionMapper(){
		exceptionMap.put(ForbiddenException.class, Status.FORBIDDEN);
		exceptionMap.put(InvalidInputException.class, Status.BAD_REQUEST);
		exceptionMap.put(NotFoundException.class, Status.NOT_FOUND);
		exceptionMap.put(UnauthorizedException.class, Status.UNAUTHORIZED);
	}
	
	public Response toResponse(Exception arg0) {
		if(exceptionMap.containsKey(arg0.getClass()))
			return Response.status(exceptionMap.get(arg0.getClass())).build();
		else
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}
	
}
