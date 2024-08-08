package system.onoff;

public class SyncDataThread implements Runnable {

	private Data data;

	public SyncDataThread(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		data.sync();
	}
	
}
