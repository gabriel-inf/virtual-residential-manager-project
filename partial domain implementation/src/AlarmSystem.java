
public class AlarmSystem {
	private boolean active;
	
	public AlarmSystem() {
		this.active = false;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void activateAlarms() {
		this.active = true;
	}
	public void deactivateAlarms() {
		this.active = false;
	}
}
