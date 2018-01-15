package satti.ibraheem.restEasy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.server.spi.Container;

import com.sun.org.apache.xerces.internal.util.URI;

import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import io.jsonwebtoken.*;
import java.util.Date;    
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


 
@Path("hello")
////<form>
//First name: <input type="text" name="firstname"><br>
//Last name: <input type="text" name="lastname">
//</form>
public class Testing {
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_HTML)
	  public String signin() {
		Customer test=new Customer(1,"testing");
		dataService list=new dataService("MTN");
		list.addCustomer(2,"mane");
		list.addCustomer(3,"mane2");
		String test1="<div id='test'></div><script>var temp=prompt('PLEASE ENTER YOUR PASSWORD:');"
		+"if(temp=='khalifa') {document.getElementByID('test').innerHTML='IT WORKS!'}</script>";
		
	    return test1;
	  }
//	  @GET
//	  @Produces({MediaType.TEXT_HTML})
//	  public InputStream viewHome()
//	  {
//	     String f = "C:\\Users\\admin\\Desktop\\form.html";
//	     
//	  }

	  @SuppressWarnings("unused")
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  @Path("/users")
	  public String sayXMLHello(@PathParam("name")String name) {
//	    //String response="<?xml version='1.0'?>"+
//	    				"<hello> "+name+" </hello>";
		  
		  String fileName = "C:\\Users\\admin\\Desktop\\form.html";
		  String line="";
		  String temp="";
		  try {
			FileReader fileReader = 
			            new FileReader(fileName);
			BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            
				try {
					while((line = bufferedReader.readLine()) != null) {
						temp+=line;
					    //System.out.println(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	    dataService lst=new dataService("Mtn");
	    lst.addCustomer(4,"mane");
		lst.addCustomer(5,"mane2");
		String test=lst.getCustomers(name);
		//String 
		
	    return temp;
	    
	  }
	  	@POST
	    @Path("/addCustomer")
	    @Produces("text/html")
	    public Response getResultByPassingValue(
	                    @FormParam("nameKey") String name,
	                    @FormParam("countryKey") String country) {
		  if(name.equals("admin")&&country.equals("secret")) {
			  dataService list=new dataService("MTN");
				list.addCustomer(11,"mane");
				list.addCustomer(13,"mane2");
	        
	        String output = "<font face='verdana' size='2'>" +
	                "Web Service has added your Customer information with Name - <u>"+name+"</u>, Country - <u><br>"+list.toString()+"</u></font>";
	        return Response.status(200).entity(output).build();
		  }
		  else
		  {		String error="<h1>Sorry username was found in our database</h1>";
			  return Response.status(200).entity(error).build();
		  }
		  
	 
	    }
	  	@GET
		  @Produces(MediaType.TEXT_PLAIN)
		  @Path("{name}")
		  public String securityParam(@PathParam("name")String name) {
	  		 String fileName = "C:\\Users\\admin\\Desktop\\tokens.txt";
	  		String line="";
			  String temp="";
			  String date="-";
			  String timeStamp=null;
			  String expDate;
			  Date todaysDate=new Date();
			  
			  
			  try {
				FileReader fileReader = 
				            new FileReader(fileName);
				BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            
					try {
						while((line = bufferedReader.readLine()) != null) {
							if(name.equals(line))
							{ 
								line = bufferedReader.readLine();
								if(line.contains("-"))
									{
										date=line.substring(1,line.length());
										DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
										Date dateIssued=new Date();
										try {
											dateIssued = formatter.parse(date);
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										line=bufferedReader.readLine();
										if(line.contains("expTime-")) {
											temp=line.substring(8,line.length());
											DateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
											Date dateExpired=new Date();
											String datexpired=formatter2.format(dateExpired);
											try {
												dateExpired = formatter.parse(temp);
											} catch (ParseException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
											if(todaysDate.before(dateExpired))
											{
											
									
												return "Welcome to MTN restful API with secure web tokens!";
											}
											
											else {
												return "sorry your token has expired as of "+temp;
											}
											
										}
									}
							}
						    //System.out.println(line);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		return "Sorry your token is either expired or not found!";
	  	}
	  	
	  	
	  
	
	  
	  
}