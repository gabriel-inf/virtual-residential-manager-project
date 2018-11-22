import java.util.ArrayList;

public class Database {	//	Class implemented using the Singleton design pattern.
	private static Database instance = null;
	private static ArrayList<User> systemUsers;
	private static ArrayList<Visitor> systemVisitors;
	private static ArrayList<Camera> systemCameras;
	private static AlarmSystem alarmSystem;
	
	private Database() throws Exception {	//	The Person constructor throws an exception if the group
											//	used to create the object is not valid. The Visitor constructor also
											//	throws exception.
		systemUsers = new ArrayList<User>();
		systemVisitors = new ArrayList<Visitor>();
		systemCameras = new ArrayList<Camera>();
		alarmSystem = new AlarmSystem();
		
		systemUsers.add(new User(0, "Maria", "Maria", "123", 20, 2, 2, Groups.Administrator));
		systemUsers.add(new User(1, "Joao", "Joao", "123", 10 , 1, 1, Groups.User));
		systemUsers.add(new User(2, "Jose", "Jose", "123", 21, 2, 2, Groups.User));
		
		systemVisitors.add(new Visitor(3, "Pedro", Groups.Visitor, systemUsers.get(1)));
		systemVisitors.add(new Visitor(4, "Jack", Groups.Maintenance, systemUsers.get(0)));
		
		systemCameras.add(new Camera(0));
		systemCameras.add(new Camera(1));
		systemCameras.add(new Camera(2));
		
		
		
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
	public ArrayList<Camera> getAllCameras(){
		return systemCameras;
	}
	public AlarmSystem getCondominiumAlarmSystem() {
		return alarmSystem;
	}
	public void save(User user) {
		systemUsers.add(user);
	}
	public void save(Visitor visitor) {
		systemVisitors.add(visitor);
	}
}
