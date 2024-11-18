package javaprivate5;

import java.util.Scanner;

public class Address {
	private String commune;
	private String distric;
	private String city;

	static Scanner sc = new Scanner(System.in);

	public Address(String commune, String distric, String city) {
		this.commune = commune;
		this.distric = distric;
		this.city = city;
	}

	public Address() {

	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDistrict() {
		return distric;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void input() throws Exception {
		System.out.println("enter commune:");
		String commune = sc.nextLine();
		System.out.println("enter distric:");
		String distric = sc.nextLine();
		System.out.println("enter city");
		String city = sc.nextLine();

		if (commune == null || commune.isEmpty() || distric == null || distric.isEmpty() || city == null
				|| city.isEmpty()) {
			throw new Exception("Invalid address: All fields must be non-empty.");
		}
		this.setCommune(commune);
		this.setDistric(distric);
		this.setCity(city);
	}

	public void output() {
		System.out.println("Commune: " + commune);
		System.out.println("Distric: " + distric);
		System.out.println("City: " + city);
	}
}
