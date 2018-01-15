package satti.ibraheem.restEasy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@Controller
@RequestMapping("/cusomters")
public class CustomerService {
	static Set<Customer> Customers;
	static {
		Customers=new HashSet<Customer>();
		Customer foobar=null;
		for(int i=0;i<10;i++) {
			foobar=new Customer(i,"Customer"+i);
			Customers.add(foobar);
			
		}
		
	}
	@RequestMapping(value="/{customerId}",method=RequestMethod.GET,headers= "Accept-application/json", produces = {"application/json"})
	@ResponseBody
	public Customer getFoobar(@PathVariable int customerId) {
		Iterator X=Customers.iterator();
		while (X.hasNext()) {
			Customer f=(Customer) X.next();
			if(f.getId()==customerId) {
				return f;
			}
		}
		return null;
		
	}

}
