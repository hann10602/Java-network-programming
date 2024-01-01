package threading;

public class ThreadThread extends Thread {
	private ThreadObject o;
	
	public ThreadThread(ThreadObject o) {
		super();
		this.o = o;
	}

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++) {
			this.o.increase();
		}
	}
}
