package javaprivate5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClassRoom {
	public static ArrayList<Student> ds = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void addStudent() {
		try {
			Student a = new Student();
			a.input();
			ds.add(a);
			System.out.println("Add successful! ");
		} catch (Exception e) {
			System.out.println("Error when entering student information: " + e.getMessage());
		}
	}

	public static void printStudentList() {
		System.out.printf("%-10s%-20s%-10s%-20s%-10s%-10s%-30s\n", "ID", "Name", "Age", "Class", "GPA", "Status",
				"Address");

		for (Student student : ds) {
			Address address = student.getAddress();
			String fullAddress = address.getCommune() + ", " + address.getDistrict() + ", " + address.getCity();
			System.out.printf("%-10d%-20s%-10d%-20s%-10.2f%-10s%-30s\n", student.getId(), student.getName(),
					student.getAge(), student.getNameClass(), student.getGpa(), student.checkFall() ? "Fail" : "Pass",
					fullAddress);
		}
	}

	public static void sortByGpa() {
		Collections.sort(ds, (s1, s2) -> Float.compare(s1.getGpa(), s2.getGpa()));
		System.out.println("The list has been sorted by GPA: ");
	}

	public static void deleteStudentById() {
		System.out.print("Enter the student ID you want to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean found = false;
		for (int i = 0; i < ds.size(); i++) {
			if (ds.get(i).getId() == id) {
				ds.remove(i);
				found = true;
				System.out.println("Student with ID of " + id + " has been deleted.");
				break;
			}
		}
		if (!found) {
			System.out.println("Student ID not found ");
		}
	}

	public static void menu() {
		while (true) {

			System.out.println("\nMenu:");
			System.out.println("1. Enter student information");
			System.out.println("2. Print student information");
			System.out.println("3. Sort students by GPA");
			System.out.println("4. Delete students by ID");
			System.out.println("5. Exit the program");

			System.out.print("Select function (1-5): ");
			int choice = 0;
			try {
				choice = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("Invalid selection");
			}

			switch (choice) {
			case 1:
				try {
					if (ds.get(ds.size() - 1).getId() == 555) {
						System.out.println("The list is full");
						break;
					}
					addStudent();

				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					break;
				}
				break;

			case 2:
				printStudentList();
				break;

			case 3:
				sortByGpa();
				break;

			case 4:
				deleteStudentById();
				break;

			case 5:
				System.out.println("Program exited.");
				System.exit(0);

			default:
				System.out.println("Reselect a valid function.");
			}
		}
	}

	public static void main(String[] args) {
		Address address1 = new Address("Phuong 1", "Quan 1", "Ha Noi");
		ds.add(new Student("Nguyen Anh", 20, address1, "Lop A", 3.5f));

		Address address2 = new Address("Phuong 2", "Quan 2", "Hai Phong");
		ds.add(new Student("Le Hoa", 21, address2, "Lop B", 2.8f));

		Address address3 = new Address("Phuong 3", "Quan 3", "Da Nang");
		ds.add(new Student("Tran Minh", 22, address3, "Lop C", 1.9f));

		Address address4 = new Address("Phuong 4", "Quan 4", "HCM");
		ds.add(new Student("Pham Mai", 19, address4, "Lop D", 3.2f));

		Address address5 = new Address("Phuong 5", "Quan 5", "Can Tho");
		ds.add(new Student("Nguyen Lan", 20, address5, "Lop E", 2.0f));

		menu();
	}
}
