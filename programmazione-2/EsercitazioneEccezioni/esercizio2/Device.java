package esercizio2;

public abstract class Device implements IDevice {

	private boolean ready = false;
	
	public boolean isReady() {
		return ready;
	}
	
	@Override
	public void start() {
		ready = true;
	}
	
	@Override
	public void stop() {
		ready = false;
	}
}
