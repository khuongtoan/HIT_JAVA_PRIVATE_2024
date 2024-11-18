package javaprivate5;

import java.util.Scanner;

public class Person {
	protected String name;
	protected int age;
	protected Address address;

	static Scanner sc = new Scanner(System.in);

	public Person(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Person() {
		this.address = new Address();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void input() throws Exception {

		System.out.println("Enter name:");
		String name = sc.nextLine();

		if (name == null || name.isEmpty()) {
			throw new Exception("Name cannot be empty");
		}

		System.out.println("Enter age:");
		int age;
		try {
			age = Integer.parseInt(sc.nextLine());
			if (age <= 0) {
				throw new Exception("Age must be greater than 0!");
			}
		} catch (Exception e) {
			throw new Exception("Invalid age");
		}
		this.name = name;
		this.age = age;
		this.address.input();

	}

	public void output() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		this.address.output();
	}

}
