package system.onoff;

public class OnlineOfflineSystem {

	public static void main(String[] args) {
		Data data = new Data();
		//data.setOutOfSync(true);
		Thread readData = new Thread(new ReadDataThread(data));
		Thread syncData = new Thread(new SyncDataThread(data));
		syncData.setDaemon(true);
		readData.start();
		syncData.start();
	}

}
