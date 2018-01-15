package satti.ibraheem.restEasy;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tst")
public class SecuredResource {
@GET
@Path("message")
@Produces(MediaType.TEXT_PLAIN)
public String securedMethod()
{
	String token=" this is secured!";
	return token;

}

}
