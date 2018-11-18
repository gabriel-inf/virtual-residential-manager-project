import java.util.ArrayList;

public class CommonArea extends CondominumDependency{
	private Enum<CommonAreaTypes> type;
	private ArrayList<Configuration> configurations;
	
	public CommonArea(Enum<CommonAreaTypes> type) {
		this.type=type;
		this.configurations = new ArrayList<Configuration>();
	}
}
