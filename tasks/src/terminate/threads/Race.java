package terminate.threads;

public class Race {
	
	private volatile boolean finished;
	private int position = 0;
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public int getPosition() {
		return position;
	}

	public void incrementPosition() {
		position++;
	}

}
