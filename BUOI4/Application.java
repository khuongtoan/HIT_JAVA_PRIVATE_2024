import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	static Scanner sc = new Scanner(System.in);
	ArrayList<Book> bookList;

	public Application() {
		bookList = new ArrayList<>();
	}

	public void addBook(Book a) {
		bookList.add(a);
		System.out.println("add successful ");
	}

	public void updateBookInfoById() {
		System.out.println("Nhập vào mã sách muốn cập nhật: ");
		int maSach = sc.nextInt();
		sc.nextLine();

		Book bookToUpdate = null;
		for (Book book : bookList) {
			if (book.getMaSach() == maSach) {
				bookToUpdate = book;
				break;
			}
		}

		if (bookToUpdate == null) {
			System.out.println("Không tìm thấy cuốn sách với mã sách " + maSach);
			return;
		}

		System.out.print("Nhập tên sách mới: ");
		String newName = sc.nextLine();
		bookToUpdate.setTenSach(newName);

		System.out.print("Nhập năm xuất bản mới: ");
		int newYear = sc.nextInt();
		bookToUpdate.setNamSX(newYear);

		sc.nextLine();
		System.out.print("Nhập tóm tắt nội dung mới: ");
		String newSummary = sc.nextLine();
		bookToUpdate.setTomTatNoiDung(newSummary);

		System.out.print("Nhập giá tiền mới: ");
		double newPrice = sc.nextDouble();
		bookToUpdate.setGiaTien(newPrice);

		System.out.println("Thông tin sách đã được cập nhật:");
		System.out.println(bookToUpdate.toString());
	}

	public void printBookList() {
		for (Book a : bookList) {
			a.display();
		}
	}

	public void printAncientBooks() {
		int res = Integer.MAX_VALUE;

		for (Book a : bookList) {
			res = Math.min(res, a.getNamSX());
		}
		System.out.println("Các cuốn sách cổ nhất là:");
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getNamSX() == res) {
				bookList.get(i).display();
			}
		}

	}

	public void suitableBook(double moneyUser) {
		Book result = new Book();
		double tmps = Double.MAX_VALUE;

		for (Book a : bookList) {
			double df = Math.abs(moneyUser - a.getGiaTien());
			if (df < tmps) {
				tmps = df;
				result = a;
			}
		}
		result.display();
	}

	public void sortByName(boolean reverse) {
		int flag = 1;
		if (reverse) {
			flag = -1;
		}

		for (int i = 0; i < bookList.size() - 1; i++) {
			for (int j = i + 1; j < bookList.size(); j++) {
				if (bookList.get(i).getTenSach().charAt(0) * flag > bookList.get(j).getTenSach().charAt(0) * flag) {
					Book tmps = bookList.get(i);
					bookList.set(i, bookList.get(j));
					bookList.set(j, tmps);
				}
			}
		}
	}

	public void sortByCost(boolean reverse) {
		int flag = 1;
		if (reverse) {
			flag = -1;
		}

		for (int i = 0; i < bookList.size() - 1; i++) {
			for (int j = i + 1; j < bookList.size(); j++) {
				if (bookList.get(i).getGiaTien() * flag > bookList.get(j).getGiaTien() * flag) {
					Book tmps = bookList.get(i);
					bookList.set(i, bookList.get(j));
					bookList.set(j, tmps);
				}
			}
		}
	}

}
