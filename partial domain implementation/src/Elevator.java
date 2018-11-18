import java.util.ArrayList;

public class Elevator {
	private Integer actualFloor;
	private Integer destinationFloor;
	private ArrayList<Integer> demandedFloors;
	private int buildingNumber;
	
	public Elevator(int buildingNumber) {
		this.actualFloor=0;
		this.destinationFloor=null;
		this.demandedFloors=new ArrayList<Integer>();
		this.buildingNumber=buildingNumber;
	}
	
	public Integer getActualFloor() {
		return actualFloor;
	}
	public Integer getDestinationFloor() {
		return destinationFloor;
	}
	public ArrayList<Integer> getDemandedFloors() {
		return demandedFloors;
	}
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	public void call(int destinationFloor) {
		if(this.destinationFloor==null)
			this.destinationFloor=destinationFloor;
		else
			this.demandedFloors.add(destinationFloor);
			
	}
	
	public void move() {
		if(destinationFloor!=null) {
			this.actualFloor=this.destinationFloor;
			if(!demandedFloors.isEmpty())
				this.destinationFloor=this.demandedFloors.remove(0);
		}
	}
}
