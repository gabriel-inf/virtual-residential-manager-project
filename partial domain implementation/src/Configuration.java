import java.util.ArrayList;

public class Configuration {
	private int startingHour;
	private int endingHour;
	private ArrayList<Integer> daysOfTheWeek;
	private Enum<Groups> group;
	private boolean active;
	
	public Configuration(int startingHour, int endingHour, ArrayList<Integer> days, Enum<Groups> group) {
		this.startingHour=startingHour;
		this.endingHour=endingHour;
		this.daysOfTheWeek = new ArrayList<Integer>();
		this.daysOfTheWeek.addAll(days);
		this.group=group;
	}

}
