package io;

public class ObjectEx {
	private String name;
	private String pass;
	private String age;

	public ObjectEx(String name, String pass, String age) {
		super();
		this.name = name;
		this.pass = pass;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
