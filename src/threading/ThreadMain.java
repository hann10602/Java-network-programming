package threading;

public class ThreadMain {
	public static void main(String[] args) {
		ThreadObject o = new ThreadObject();
		Thread t1 = new ThreadThread(o);
		Thread t2 = new Thread(new ThreadRunnable(o));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(o.getCount());
	}
}
