import systemexceptions.UnableToVinculateException;

public class SchedulePattern {
	private int originFloor;
	private int destinationFloor;
	private String hour;
	private User patternHolder;
	
	public SchedulePattern(int originFloor, int destinationFloor, String hour, User patternHolder) throws UnableToVinculateException {
		if(patternHolder != null) {
			this.originFloor=originFloor;
			this.destinationFloor=destinationFloor;
			this.hour=hour;	
			this.patternHolder=patternHolder;
		}
		else
			throw new UnableToVinculateException();
	}
	public int getOriginFloor() {
		return originFloor;
	}
	public int getDestinationFloor() {
		return destinationFloor;
	}
	public String getHour() {
		return hour;
	}
	public User getPatternHolder() {
		return patternHolder;
	}
	
	
}
