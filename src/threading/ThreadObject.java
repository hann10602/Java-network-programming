package threading;

public class ThreadObject {
	private Integer count = 0;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public synchronized void increase() {
		this.count++;
	}
}
