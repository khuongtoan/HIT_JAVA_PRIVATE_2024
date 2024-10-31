package buois3;

public class Student {
	private String studentCode;
	private String fullName;
	private byte age;
	private String gender;
	private String phoneNumber;
	private String email;

	public Student() {

	}

	public Student(String studentCode, String fullName, byte age, String gender, String phoneNumber, String email) {
		this.studentCode = studentCode;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void display() {
		System.out.println("studentCode=" + studentCode + ", fullName=" + fullName + ", age=" + age + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + ", email=" + email);
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}