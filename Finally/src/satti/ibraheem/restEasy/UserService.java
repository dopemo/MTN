package satti.ibraheem.restEasy;
import java.util.*;

public class UserService {
	List<User>users=new ArrayList<User>();
	public void addUser(User user) {
		
		users.add(user);
		
	}
	public Boolean isUser(User user) {
		for(User user1:users)
		{
			if(user1.getUsername().equals(user.getUsername())&&user.getPassword().equals(user.getPassword()))
			{
				return true;
			}
			
		}
		return false;
	}

}
