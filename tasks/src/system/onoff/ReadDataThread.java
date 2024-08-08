package system.onoff;

public class ReadDataThread implements Runnable {

	private Data data;

	public ReadDataThread(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		data.read();
	}
	
}
