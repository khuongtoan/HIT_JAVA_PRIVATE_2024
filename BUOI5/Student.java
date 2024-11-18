package javaprivate5;

import java.util.Scanner;

public class Student extends Person {
	static int nextId = 550;
	private int id;
	private String nameClass;
	private float gpa;
	public final float criteria = 2;

	private Scanner sc = new Scanner(System.in);

	public Student(String name, int age, Address address, String nameClass, float gpa) {
		super(name, age, address);
		this.id = nextId++;
		this.nameClass = nameClass;
		this.gpa = gpa;
	}

	public Student() {
		this.id = nextId++;
	}

	public int getId() {
		return id;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public float getCriteria() {
		return criteria;
	}

	@Override
	public void input() throws Exception {

		super.input();

		System.out.println("Enter class name:");
		this.nameClass = sc.nextLine();

		if (nameClass == null || nameClass.isEmpty()) {
			throw new Exception("NameClass cannot emty");
		}

		try {
			System.out.println("Enter GPA: ");
			this.gpa = Float.parseFloat(sc.nextLine());
			if (gpa <= 0) {
				throw new Exception("Invalid gpa ( gpa must be greater than 0)!");
			}
		} catch (Exception e) {
			throw new Exception("Invalid gpa");
		}

	}

	@Override
	public void output() {
		super.output();
		System.out.println("Id: " + id);
		System.out.println("NameClass: " + nameClass);
		System.out.println("Gpa: " + gpa);
	}

	public boolean checkFall() {
		return gpa < criteria;
	}

}
