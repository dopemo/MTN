package satti.ibraheem.restEasy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
@Provider
public class AuthenticationFilter implements ContainerRequestFilter{
	private static final String AUTHORIZATION_HEADER_KEY="Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX="Basic ";
	private static final String SECURED_URL_PREFIX="hello";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
		List<String> authHeader=requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if(authHeader!=null&&authHeader.size()>0) {
				User user=new User ("admin","password");
				User user2=new User("superadmin","secret");
				UserService admins=new UserService();
				admins.addUser(user);
				admins.addUser(user2);
				String authToken=authHeader.get(0);
				authToken=authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString=Base64.decodeAsString(authToken);
				StringTokenizer tokenizer=new StringTokenizer(decodedString, ":");
				String username=tokenizer.nextToken();
				String password=tokenizer.nextToken();
				String token=user.getToken();
				String fileName = "C:\\Users\\admin\\Desktop\\tokens.txt";
			  	String line="";
			  	String temp="";
			  	Boolean flag=false;
					  try {
						FileReader fileReader = 
						            new FileReader(fileName);
						BufferedReader bufferedReader = 
				                new BufferedReader(fileReader);

				            
							try {
								while((line = bufferedReader.readLine()) != null) {
									if(line.contains(user.getPassword())) {
										flag=true;
										break;
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
				
				if(flag==false) 
				{
					String key="newGeneratedToken";
					Date todaysDate = new Date();
					 DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
					 Date date2=new Date();
				 	 Calendar cal = Calendar.getInstance();
				 	 cal.setTime(todaysDate);
				 	 cal.add(Calendar.MINUTE, 5);
				 	 date2 = cal.getTime();
				 	 DateFormat df3= new SimpleDateFormat("dd-MM-yyyy hh:mm a");
				 	 String timeStamp2=df3.format(date2);
					 
					 String timeStamp=df2.format(todaysDate);
					user.setToken(user.getPassword()+generateRandomChars(key, key.length()));
					PrintStream fileStream;
					try {
						fileStream = new PrintStream(new FileOutputStream("C:\\Users\\admin\\Desktop\\tokens.txt",true));
						fileStream.println(user.getPassword()+generateRandomChars(token, token.length()));
						fileStream.println("-"+timeStamp);
						fileStream.println("expTime-"+timeStamp2);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(username.equals(user.getUsername())&&password.equals(user.getPassword()))
				{	
					
					return;
				}
			}
				Response unauthorizedStatus=Response
											.status(Response.Status.UNAUTHORIZED)
											.entity("user cannot access this resourse.")
											.build();
				requestContext.abortWith(unauthorizedStatus);
			}
		
		}
	public static String generateRandomChars(String candidateChars, int length) {
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
	}
	
		
	}


