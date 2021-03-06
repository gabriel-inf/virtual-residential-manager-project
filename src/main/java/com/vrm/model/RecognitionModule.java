package com.vrm.model;

import java.util.ArrayList;

import com.vrm.data.Database;
import com.vrm.systemexceptions.IdentificationParametersException;

public class RecognitionModule {

	public boolean identify(Person person, ArrayList<Person> systemPeople) throws IdentificationParametersException {
		if(!systemPeople.isEmpty()) {
			for (Person systemPerson : systemPeople) {
				if(person.equals(systemPerson))
					return true;
			}
			return false;
		}
		else
			throw new IdentificationParametersException();
	}
	
}
