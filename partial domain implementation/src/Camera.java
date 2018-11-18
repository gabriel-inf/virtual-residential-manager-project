import java.util.ArrayList;

import systemexceptions.IdentificationParametersException;

public class Camera {
	
	public boolean identify(Person person, ArrayList<Person> systemPeople) throws IdentificationParametersException {
		if(person!=null && !systemPeople.isEmpty()) {
			for (Person systemPerson : systemPeople) {
				if(systemPerson==person)
					return true;
			}
			return false;
		}
		else
			throw new IdentificationParametersException();
	}
	
	public int getNumPeopleWaiting() {
		//	Maybe we can try to implement a method that returns a random int.
		return 0;
	}
	public boolean registerEntrance() {
		//	Method that will be used to register the entrance of a person/group.
		return true;
	}
	public Object captureImage() {
		return "Image Captured";
	}
}
