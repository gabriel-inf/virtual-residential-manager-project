import java.util.ArrayList;


public class User extends Person{
	private String login;
	private String password;
	private int floor;
	private int building;
	private int apartmentNumber;
	private ArrayList<Notification> notifications;
	
	public User(int id, String name, String login, String password, int apartmentNumber, int floor, int building, Enum<Groups> group) throws Exception {
			super(id, name, null, group, creatingUser);		//	Using null for the photo attribute.
			this.login = login;
			this.password = password;
			this.floor = floor;
			this.building = building;
			this.notifications = new ArrayList<Notification>();
			this.apartmentNumber = apartmentNumber;
	}
	
	public String getLogin() {
		return this.login;
	}
	public String getPassword() {
		return this.password;
	}
	public int getBuilding() {
		return this.building;
	}
	public int getFloor() {
		return this.floor;
	}
	public ArrayList<Notification> getNotifications() {
		return notifications;
	}
	public int getApartmentNumber() {
		return this.apartmentNumber;
	}
	public void addNotification(String description, Object photo) {
		this.notifications.add(new Notification(description, photo));
	}
	@Override
	public String toString() {
		return "[Id:" + this.getId() + ", Name: "+this.getName()+", Photo: "+this.getPhoto()+", Group: "+this.getGroup()+
				", Login: "+this.getLogin()+", Password: "+this.getPassword()+", Building: "+this.getBuilding()+
				", Floor: "+this.getFloor()+", Notifications: "+this.getNotifications()+"]";
	}
	
//	public static void main(String[] args) {
//		PersonDAO pDAO = new PersonDAO();
//		try{
//			ArrayList<User> users = Database.getInstance().getAllUsers();
//			ArrayList<Visitor> visitors = Database.getInstance().getAllVisitors();
//			
//			for (User user : users) {
//				System.out.println(user);
//				System.out.println("\n");
//			}
//			for (Visitor visitor : visitors) {
//				System.out.println(visitor);
//				System.out.println("\n");
//			}
//			pDAO.saveUser("tester", "tester", "tester", 1, 1, 1, Groups.User);
//			
//			ArrayList<User> users2 = Database.getInstance().getAllUsers();
//			for (User user : users2) {
//				System.out.println(user);
//				System.out.println("\n");
//			}
//		}
//		catch(InvalidPersonGroupException ipg) {
//			System.out.println(ipg);
//			}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}	
}
