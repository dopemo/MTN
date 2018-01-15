package satti.ibraheem.restEasy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.security.Principal;

public class User implements Principal {
	 
	  private String username;
	  private String password;
	  private String token;
	  public User(String username, String password) {
		
		this.username = username;
		this.password = password;
		this.token = "notAssigned";
		PrintStream fileStream;
		try {
			fileStream = new PrintStream(new FileOutputStream("C:\\Users\\admin\\Desktop\\UserInfo.txt",true));
			fileStream.println(this.username+", "+this.password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }
	  
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String username) {
		this.username=username;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	  
	}