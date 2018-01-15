package satti.ibraheem.restEasy;
import java.util.*;
public class dataService {
	String company;
	static ArrayList<Customer> customer=new ArrayList<Customer>();
	dataService(String company){
		this.company=company;
	}
	//
	public  void addCustomer(int id,String name){
		
		Customer cust=new Customer(id,name);
		customer.add(cust);
		
	}
	
	public String toString() 
	{
		String result=this.company+" ";
		for(Customer customers : customer)
		{
			result+=customers.getCustomerInfo()+"<br>";
		}
		return result;
	}

	public String getCustomers(String name) {
		boolean flag=false;
		for(Customer customers : customer)
		{
			if(customers.getName().equals(name)) {
				flag=true;
				break;
			}
			else
			{
				flag=false;
			}
		}
		if(flag) {
			return name+" Was Found!";
		}
		else {
			return name+ " was not found in our database!!";
		}
	}

	
	
	

}
