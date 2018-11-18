
public class Gate extends CondominumDependency{
	private boolean isOpen;
	private boolean closePerson;
	
	public Gate() {
		this.isOpen=false;
		this.closePerson=false;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	public boolean isClosePerson() {
		return closePerson;
	}
	
	public void open() {
		if(!this.isOpen)
			this.isOpen=true;
	}
	public void close() {
		if(this.isOpen)
			this.isOpen=false;
	}
	
}
