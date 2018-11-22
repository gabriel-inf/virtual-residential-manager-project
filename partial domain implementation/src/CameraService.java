import java.util.ArrayList;

import systemexceptions.PersonNotIdentifiedException;

public class CameraService {
	
	public Person identifyPerson(Person person, int cameraId) throws Exception {
		PersonDAO personDAO = new PersonDAO();
		CameraDAO cameraDAO = new CameraDAO();
		ArrayList<Person> systemPeople = new ArrayList<Person>();
		Camera camera = cameraDAO.getCameraById(cameraId);
		if(camera != null) {
			systemPeople.addAll(personDAO.getAllPeople());
			if(camera.getRecognitionModule().identify(person, systemPeople))
				return person;
		}
		throw new PersonNotIdentifiedException();
	}

	public int peopleWaitingBeforeOpening(Camera camera){
		return camera.getNumPeopleWaiting();
	}	
//	public static void main(String[] args) throws Exception {
//		PersonDAO personDAO = new PersonDAO();
//		Person p = new Person(0, "Maria", null, Groups.Administrator, true);
//		CameraService cs = new CameraService();
//		System.out.println(cs.identifyPerson(p , 0));
//	}
}
