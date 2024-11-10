
public class Book {
	private int maSach;
	private String tenSach;
	private int namSX;
	private String tomTatNoiDung;
	private double giaTien;

	public Book() {

	}

	public Book(int maSach, String tenSach, int namSX, String tomTatNoiDung, double giaTien) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.namSX = namSX;
		this.tomTatNoiDung = tomTatNoiDung;
		this.giaTien = giaTien;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		if (tenSach != null)
			this.tenSach = tenSach;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		if (namSX > 0) {
			this.namSX = namSX;
		}
	}

	public String getTomTatNoiDung() {
		return tomTatNoiDung;
	}

	public void setTomTatNoiDung(String tomTatNoiDung) {
		this.tomTatNoiDung = tomTatNoiDung;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		if (giaTien > 0) {
			this.giaTien = giaTien;
		}
	}

	@Override
	public String toString() {
		return "Book [maSach=" + maSach + ", tenSach=" + tenSach + ", namSX=" + namSX + ", tomTatNoiDung="
				+ tomTatNoiDung + ", giaTien=" + giaTien + "]";
	}

	public void display() {
		System.out.println(this.toString());
	}

}
