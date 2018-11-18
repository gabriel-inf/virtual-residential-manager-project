import java.util.ArrayList;

public class Database {	//	Class implemented using the Singleton design pattern.
	private static Database instance = null;
	private static ArrayList<User> systemUsers;
	private static ArrayList<Visitor> systemVisitors;
	
	private Database() throws Exception {	//	The Person constructor throws an exception if the group
											//	used to create the object is not valid. The Visitor constructor also
											//	throws exception.
		systemUsers = new ArrayList<User>();
		systemVisitors = new ArrayList<Visitor>();
		
		systemUsers.add(new User(0, "Maria", "Maria", "123", 2, 2, Groups.Administrator));
		systemUsers.add(new User(1, "Joao", "Joao", "123", 1, 1, Groups.User));
		systemUsers.add(new User(2, "Jose", "Jose", "123", 2, 2, Groups.User));
		
		systemVisitors.add(new Visitor(0, "Pedro", Groups.Visitor, getUserById(1)));
		systemVisitors.add(new Visitor(1, "Jack", Groups.Maintenance, getUserById(0)));
		
	}
	
	public static Database getInstance() throws Exception {
		if(instance == null)
			instance = new Database();
		return instance;
	}
	
	public ArrayList<User> getAllUsers(){
		return systemUsers;
	}
	public ArrayList<Visitor> getAllVisitors(){
		return systemVisitors;
	}
	public User getUserById(int id) {	//	In case the user is not found, the method will return null.
		for (User user : systemUsers) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
}
