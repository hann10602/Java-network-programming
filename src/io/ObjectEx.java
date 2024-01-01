package io;

import java.io.Serializable;

public class ObjectEx implements Serializable {
	private String name;
	private String pass;
	private Integer age;

	public ObjectEx(String name, String pass, Integer age) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ObjectEx [name=" + name + ", pass=" + pass + ", age=" + age + "]";
	}
}
