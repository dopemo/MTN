package satti.ibraheem.restEasy;
//import java.util.*;
import org.codehaus.jackson.annotate.JsonAutoDetect;
@JsonAutoDetect
public class Customer {
	String name;
	int id;
	String password;
	String token;
	String secret;
	String authcode;
	Customer()
	{
		this.name="Customer";
		this.id=1;
	}
	Customer(int id,String names)
	{
		this.name=names;
		this.id=id;
	}
	public String getName() {
		return this.name;
		
	}
	public int getId() {
		return this.id;
		
	}
	
	public String getCustomerInfo() {
		return this.name+" "+this.id;
	}
	public void setName(String authcode) {
		this.name=authcode;
	}
	public void addToken(String token) {
		this.token=token;
	}
	public String getToken() {
		return this.token;
	}
	public void addSecret(String secret) {
		this.secret=secret;
	}
	public String getsecret() {
		return this.secret;
	}
	public void addauthcode(String authcode) {
		this.authcode=authcode;
	}
	public String getauthcode() {
		return this.authcode;
	}
	public void setpass(String pass) {
		this.password=pass;
	}
	public String getPass() {
		return this.password;
	}
	public Boolean checkPass(String pass,String name)
	{
		if(this.password.equals(pass)&&this.name.equals(name)){
			return true;
		}
		else
		{
			return false;
		}
	}
	public Boolean isValidToken(String token) {
		if(this.token.equals(token))
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
	
	

}
