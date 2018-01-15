package satti.ibraheem.restEasy;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class LoggingFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.print("Header: "+ requestContext.getHeaders());
		
		
		
	}

}
