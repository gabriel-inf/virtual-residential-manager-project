
public class GateService {
	public void openGateService(int numAuthorizedPeople, Gate gate) {
		CameraService cameraService = new CameraService();
		int peopleBeforeOpening = cameraService.peopleWaitingBeforeOpening(gate.getGateCamera());
		gate.open();
		//	Implement logic to verify if there are intruders after opening the gate.
		gate.close();
	}
}
